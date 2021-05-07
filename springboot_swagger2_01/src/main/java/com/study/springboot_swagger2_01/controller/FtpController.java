package com.study.springboot_swagger2_01.controller;


import com.jcraft.jsch.SftpException;
import com.study.springboot_swagger2_01.configuration.FtpConfig;
import com.study.springboot_swagger2_01.message.ErrorCodeAndMsg;
import com.study.springboot_swagger2_01.message.ResultMap;
import com.study.springboot_swagger2_01.message.SystemException;
import com.study.springboot_swagger2_01.pojo.FileType;
import com.study.springboot_swagger2_01.service.FileTypeService;
import com.study.springboot_swagger2_01.utils.GetAppId;
import com.study.springboot_swagger2_01.utils.RedisUtil;
import com.study.springboot_swagger2_01.utils.SftpUtil;
import com.study.springboot_swagger2_01.utils.StringUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.annotation.Resource;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.time.LocalDateTime;
import java.util.*;

@RestController
@Api(value="ftp",tags="ftp文件上传")
@RequestMapping("ftp")
public class FtpController {

    @Autowired
    private FtpConfig ftpConfig;

    @Resource
    private RedisUtil redisUtil;

    @Resource
    private GetAppId getAppId;

    @Autowired
    private FileTypeService fileTypeService;

    @ApiOperation(value="批量文件上传")
    @PostMapping(value="/batch-upload-file")
    public Map<String,Object> batchFileUpload(@RequestHeader(required = false) String appId, @RequestParam("file") MultipartFile [] file, String name) throws SftpException, IOException {
        //上传人的名字不能为空
        if (StringUtils.isBlank(name)){
            throw new SystemException(ErrorCodeAndMsg.NAME_ISNOT_NULL);
        }
        //不能没上传文件
        if(file.length==0||file==null) {
            throw new SystemException(ErrorCodeAndMsg.FILE_NOT_EXISTENCE);
        }

        //文件格式错误的响应信息集合
        List<String> FILE_FORMAT_MISMATCH=new ArrayList<String>();
        //文件上传成功后的响应信息map
        Map<String,Object> map=new HashMap<String,Object>();
        List<Map<String,Object>> FILE_UPLOAD_SUCCESS=new ArrayList<Map<String,Object>>();
        //文件上传的key,用于获取上传后的路径
        String file_key=null;
        //批量上传
        for (MultipartFile multipartFile : file) {
            //获得后缀
            String suffix=multipartFile.getOriginalFilename().substring(multipartFile.getOriginalFilename().lastIndexOf(".")+1).trim();
            //获得前缀
            String preffix=multipartFile.getOriginalFilename().substring(0,multipartFile.getOriginalFilename().lastIndexOf(".")).trim();
            //获得文件名（含前后缀）
            String fileName=multipartFile.getOriginalFilename();

            //文件不是指定的类型时则不上传并返回错误响应信息（这里以图片为例,备注文件类型可以存到redis中）
            if(!(suffix.equals("jpg") || suffix.equals("png") || suffix.equals("jpeg"))){
                FILE_FORMAT_MISMATCH.add(fileName);
                continue;
            }

            //生成文件上传的key
            file_key="file:"+ UUID.randomUUID().toString().toLowerCase().replace("-", "");
            //上传文件，并返回上传的路径名
            String path= SftpUtil.fileUpload(ftpConfig,suffix.toLowerCase(), new RandomStringUtils().random(50, true, true)+"."+suffix.toLowerCase(), multipartFile.getInputStream());
            //文件上传成功信息存入map
            map.put(file_key, path);
            FILE_UPLOAD_SUCCESS.add(map);
            redisUtil.set(file_key, path);
            FileType  fileType=new FileType();
            fileType.setFileName(preffix);
            fileType.setType(suffix);
            fileType.setPath(path);
            fileType.setCreateTime(LocalDateTime.now());
            fileType.setCreateBy(name);
            fileType.setAppId(getAppId.isDefaultAppId(appId));
            fileTypeService.save(fileType);
        }

        //返回响应信息给前端
        Map<String,Object> resultMap=new HashMap<String,Object>();
        resultMap.put("upload-success", map);
        resultMap.put("not-suppord", FILE_FORMAT_MISMATCH);
        return new ResultMap().Data(resultMap);
    }

}