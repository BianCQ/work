package com.workspace.tuling01.pms.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class PmsProductAttributeCategoryController {


    /**
     * 商品类型修改
     * return request({
     * url:'/productAttribute/category/update/+id',
     * method:'post',
     * data:data
     * })
     */


    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public CommonResult update(PmsProductAttributeCategory productAttributeCategory) {
        boolean result = attributeCategoryService.updateById(productAttributeCategory);
        if (result) {
            return CommonResult.success(result);
        } else {
            return CommonResult.failed();
        }
    }

    /**
     * 商品类型删除
     * url:'/productCategory/delete/+id',
     * method:'post'
     */
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public CommonResult create(PmsProductAttributeCategory productAttributeCategory) {

        boolean result = attributeCategoryService.add(PmsProductAttributeCategory);
        if (result) {
            return CommonResult.success(result);
        } else {
            return CommonResult.failed();
        }
    }

    /**
     * 添加商品类型
     *
     * @param productAttributeCategory
     * @return
     */

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public CommonResult delete(@PathVariable Long id) {
        boolean result = attributeCategoryService.removeById(id);
        if (result) {
            return CommonResult.success(result);
        } else {
            return CommonResult.failed();
        }
    }
}
