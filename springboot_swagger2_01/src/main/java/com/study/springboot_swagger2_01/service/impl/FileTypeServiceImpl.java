package com.study.springboot_swagger2_01.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.study.springboot_swagger2_01.mapper.FileTypeMapper;
import com.study.springboot_swagger2_01.pojo.FileType;
import com.study.springboot_swagger2_01.service.FileTypeService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author tony.kroos
 * @since 2020-09-01
 */
@Service
public class FileTypeServiceImpl extends ServiceImpl<FileTypeMapper, FileType> implements FileTypeService {

}
