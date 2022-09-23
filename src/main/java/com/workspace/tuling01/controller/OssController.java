package com.workspace.tuling01.controller;

import com.workspace.tuling01.service.impl.OssServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.UUID;

public class OssController {

    @Controller
    @Api(tags = "OssController",description="Oss管理")
    @RequestMapping("/alivun/oss")
    private OssServiceImpl ossService;

    @ApiOperation(value = "oss上传签名生成")
    @RequestMapping(value = "/policy",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<OssPolicyResult>policy(){
        OssPolicyResult result = ossService.policy();
        return CommonResult.success(result);
    }
    @Value("${upload.product.images}")
    private String uploadBasePath;

    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    @CrossOrigin
    @ResponseBody
    public CommonResult<String>importDate(@RequestParam("image-file")MultipartFile multipartFile)
    SimpleDateFormat sdf = new SimpleDateFormat("/yyy/MM/dd/");
    String format = sdf.format(new Date());
    /*
    *按日期分类
     */
    String realPath = uploadBasePath + format;
    File folder = new File(realPath);
    if (!folder.exists()){
        folder.mkdir();
    }
    String oldName = multiFile.getOriginalFilename();
    String newName = UUID.randomUUID().toString()+ oldName.substring(oldName.lastIndexOf());

    multiFile.transferTo(new File(folder,newName));
    String httpBasePath = "/upload/product/images"+ format+ newName;

    return CommonResult.success(httpBasePath);
}
