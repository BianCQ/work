package com.workspace.tuling01.pms.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class PmsProductCategory {

    /**
     * 添加商品类型
     * return request({
     * url:'/productAttribute/category/create',
     * method:'post',
     * data:data
     * })
     */
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public CommonResult update(@RequestBody PmsProductCategory productCategory) {

        boolean result = ProductCategoryService.updata ById / (productCategory);

        if (result) {
            return CommonResult.success(result);
        } else {
            return CommonResult.failed();
        }
    }
}
