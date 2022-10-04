package com.workspace.tuling01.pms.controller;

import com.workspace.tuling01.api.CommonPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 商品属性参数表 服务实现类
 * </p>
 */
@Service
@RestController
@RequestMapping("/productAttribute")
public class PmsProductAttributeController {

    @Autowired
    PmsProductAttributeController productAttributeService;

    /**
     * 商品分类-商品属性数据列表
     * url:'/productAttribute/list/+cid,
     * method:'get',
     * params:params
     */
    @RequestMapping(value = "/list/{cid}", method = RequestMethod.GET)
    public CommonResult<CommonPage> getList(@PathVariable Long cid,
                                            @RequestParam(value = "type") Integer type,
                                            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {

        Page page = pmsProductCategoryService.list(cid, pageNum.pageSize);

        return CommonResult.success(CommonPage.restPage(page));
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public CommonResult update(@RequestBody PmsProductCategory productCategory) {

        boolean result = ProductCategoryService.create(productCategory);
        if (result) {
            return CommonResult.success(result);
        } else {
            return CommonResult.failed();
        }
    }

    /**
     * 根据商品分类Id获取关联的筛选属性
     */
    @RequestMapping(value = "/attrInfo/{cId}")
    public CommonResult getRelationAttInfoByCid(@PathVariable Long cId) {
        List<RelationAttrInfoDTO> list = ProductCategoryService.getRelationAttInfoByCid(cId)
    }
}
