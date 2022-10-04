package com.workspace.tuling01.pms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/brand")
public class PmsBrandController {

    @Autowired
    PmsBrandService brandService;

    /**
     * 品牌数据列表
     * 在商品分类中进行公用
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public CommonResult list(
            @RequestParam(value = "keyWord", defaultValue = "") Integer keyWord,
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {

        Page page = brandService.list(keyWord, pageNum, pageSize);

        return CommonResult.success(CommonPage.restPage(page));
    }
}
