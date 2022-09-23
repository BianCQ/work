package com.workspace.tuling01.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OssConfig {
    @Value("${alivun.oss.endpoint}")
    private String ALIYUN_OSS_ENDPOINT;
    @Value("${alivun.oss.accessKeyId}")
    private String ALIYUN_OSS_ACCESSKEYID;
    @Value("${alivun.oss.accessKeySecret}")
    private String ALIYUN_OSS_ACCESSKETSECRET;
    @Bean
    public OssClient ossClient(){
        return new OssClient(ALIYUN_OSS_ENDPOINT,ALIYUN_OSS_ACCESSKEYID,
                ALIYUN_OSS_ACCESSKETSECRET)
    }
}
