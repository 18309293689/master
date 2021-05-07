package com.study.springboot_swagger2_01.utils;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;
import java.io.*;
import java.net.SocketException;

/**
 * ftp工具类
 */
public class FtpUtil {

    private String ftpIp = "";
    private String ftpUserName = "";
    private String ftpPassword = "";
    private Integer ftpPort = 21;
    private Integer httpPort = 80;
    public FTPClient ftpClient = null;


    /**
     * ftp下载文件
     * @param ftpPath  ftp服务器路径
     * @param localPath  保存文件的路径
     * @param fileName  文件名称
     * @throws Exception
     */
    public void downFile(String ftpPath,String localPath,String fileName) throws Exception {
        try {
            ftpClient = this.getFTPClient(ftpIp,ftpUserName,ftpPassword,ftpPort);
            ftpClient.setControlEncoding("UTF-8"); // 中文支持
            ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
            ftpClient.enterLocalPassiveMode();
            ftpClient.changeWorkingDirectory(ftpPath);
            File localFile = new File(localPath + File.separatorChar + fileName);
            OutputStream os = new FileOutputStream(localFile);
            ftpClient.retrieveFile(fileName, os);
            os.close();
            ftpClient.logout();

        } catch (FileNotFoundException e) {
            System.out.println("没有找到" + ftpPath + "文件");
            e.printStackTrace();
        } catch (SocketException e) {
            System.out.println("连接FTP失败.");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("文件读取错误。");
            e.printStackTrace();
        }
    }




    /**
     * Description: 向FTP服务器上传文件
     * FTP服务器中文件所在路径 格式： ftptest/aa
     * @param fileName ftp文件名称
     * @param input 文件流
     * @return 成功返回true，否则返回false
     */
    public  boolean uploadFile(String ftpPath,String fileName, InputStream input) {
        boolean success = false;
        try {
            int reply;
            ftpClient = getFTPClient(ftpIp, ftpUserName, ftpPassword, ftpPort);
            reply = ftpClient.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
                ftpClient.disconnect();
                return success;
            }
            ftpClient.setControlEncoding("UTF-8"); // 中文支持
            ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
            ftpClient.enterLocalPassiveMode();

            if(ftpPath!=null && !"".equals(ftpPath)) {
                CreateDirecroty(ftpPath); //在ftp服务器中创建文件夹
            }
            ftpClient.changeWorkingDirectory(ftpPath);
            ftpClient.storeFile(fileName, input);
            input.close();
            ftpClient.logout();
            success = true;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (ftpClient.isConnected()) {
                try {
                    ftpClient.disconnect();
                } catch (IOException ioe) {
                }
            }
        }
        return success;
    }

    /**
     * 获取FTPClient对象
     * @param ftpIp     FTP主机服务器
     * @param ftpPassword FTP 登录密码
     * @param ftpUserName FTP登录用户名
     * @param ftpPort     FTP端口 默认为21
     * @return
     */
    public FTPClient getFTPClient(String ftpIp, String ftpUserName,String ftpPassword, int ftpPort) {
        FTPClient ftpClient = new FTPClient();
        try {
            ftpClient = new FTPClient();
            ftpClient.connect(ftpIp,ftpPort);// 连接FTP服务器
            ftpClient.login(ftpUserName, ftpPassword);// 登陆FTP服务器
            if (!FTPReply.isPositiveCompletion(ftpClient.getReplyCode())) {
                System.out.println("未连接到FTP，用户名或密码错误。");
                ftpClient.disconnect();
            } else {
                System.out.println("FTP连接成功。");
            }
        } catch (SocketException e) {
            e.printStackTrace();
            System.out.println("FTP的IP地址可能错误，请正确配置。");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("FTP的端口错误,请正确配置。");
        }
        return ftpClient;
    }


    //改变目录路径
    public boolean changeWorkingDirectory(String directory) {
        boolean flag = true;
        try {
            flag = ftpClient.changeWorkingDirectory(directory);
            if (flag) {
                System.out.println("进入文件夹" + directory + " 成功！");

            } else {
                System.out.println("进入文件夹" + directory + " 失败！开始创建文件夹");
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return flag;
    }

    //创建多层目录文件，如果有ftp服务器已存在该文件，则不创建，如果无，则创建
    public boolean CreateDirecroty(String remote) throws IOException {
        boolean success = true;
        String directory = remote + "/";
        // 如果远程目录不存在，则递归创建远程服务器目录
        if (!directory.equalsIgnoreCase("/") && !changeWorkingDirectory(new String(directory))) {
            int start = 0;
            int end = 0;
            if (directory.startsWith("/")) {
                start = 1;
            } else {
                start = 0;
            }
            end = directory.indexOf("/", start);
            String path = "";
            String paths = "";
            while (true) {
                String subDirectory = new String(remote.substring(start, end).getBytes("GBK"), "iso-8859-1");
                path = path + "/" + subDirectory;
                if (!existFile(path)) {
                    if (makeDirectory(subDirectory)) {
                        changeWorkingDirectory(subDirectory);
                    } else {
                        System.out.println("创建目录[" + subDirectory + "]失败");
                        changeWorkingDirectory(subDirectory);
                    }
                } else {
                    changeWorkingDirectory(subDirectory);
                }

                paths = paths + "/" + subDirectory;
                start = end + 1;
                end = directory.indexOf("/", start);
                // 检查所有目录是否创建完毕
                if (end <= start) {
                    break;
                }
            }
        }
        return success;
    }

    //判断ftp服务器文件是否存在
    public boolean existFile(String path) throws IOException {
        boolean flag = false;
        FTPFile[] ftpFileArr = ftpClient.listFiles(path);
        if (ftpFileArr.length > 0) {
            flag = true;
        }
        return flag;
    }
    //创建目录
    public boolean makeDirectory(String dir) {
        boolean flag = true;
        try {
            flag = ftpClient.makeDirectory(dir);
            if (flag) {
                System.out.println("创建文件夹" + dir + " 成功！");

            } else {
                System.out.println("创建文件夹" + dir + " 失败！");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }



    public String getFtpIp() {return ftpIp;}
    public void setFtpIp(String ftpIp) {this.ftpIp = ftpIp;}
    public String getFtpUserName() {return ftpUserName;}
    public void setFtpUserName(String ftpUserName) {this.ftpUserName = ftpUserName;}
    public String getFtpPassword() {return ftpPassword;}
    public void setFtpPassword(String ftpPassword) {this.ftpPassword = ftpPassword;}
    public Integer getFtpPort() {return ftpPort;}
    public void setFtpPort(Integer ftpPort) {this.ftpPort = ftpPort;}
    public Integer getHttpPort() {return httpPort;}
    public void setHttpPort(Integer httpPort) {this.httpPort = httpPort;}
    public FTPClient getFtpClient() {return ftpClient;}
    public void setFtpClient(FTPClient ftpClient) {this.ftpClient = ftpClient;}

    public FtpUtil(String ftpIp, String ftpUserName, String ftpPassword, Integer ftpPort, Integer httpPort) {
        this.ftpIp = ftpIp;
        this.ftpUserName = ftpUserName;
        this.ftpPassword = ftpPassword;
        this.ftpPort = ftpPort;
        this.httpPort = httpPort;
    }

    public FtpUtil() {
    }
}