package com.workspace.tuling01.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.Date;

/***
 *
 */
public class OssServiceImpl implements OssService {

    @Autowired
    private  OSSClient ossClient
    public OssPolicyResult policy(){
        result = new
         //存储目录
        SimpleDateFormat sdf = new SimpleDateFormat("yyyMMdd");
        String dir = ALIYUN_OSS_DIR_PREFIX+sdf.fromat(new Date());
        //签名有效期
    }

}
