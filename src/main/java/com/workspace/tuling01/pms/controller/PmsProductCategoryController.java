package com.workspace.tuling01.pms.controller;

import com.workspace.tuling01.api.CommonPage;
import com.workspace.tuling01.pms.model.dto.PmsProductCategoryDTO;
import com.workspace.tuling01.pms.model.dto.ProductCateChildrenDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * </p>
 * 产品分类，前端控制器
 * </p>
 *
 * @author XuShu
 * @since 2022-01-24
 */
@RestController
@RequestMapping("/productCategory")
public class PmsProductCategoryController {

    @Autowired
    PmsProductCategoryService pmsProductCategoryService;

    /**
     * url:'/productCategory/list/'+parentId,
     * method:'get'
     * params: {
     * pageNum: 1,
     * pageSize: 5
     * },
     */
    @RequestMapping(value = "/list/{parenId}", method = RequestMethod.GET)
    public CommonResult<List<PmsProductCategory>> getList(@PathVariable Long parenId,
                                                          @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                          @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {

        Page page = pmsProductCategoryService.list(parenId, pageNum.pageSize);

        return CommonResult.success(CommonPage.restPage(page));
    }

    /**
     * url:'/productCategory/update/navStatus
     * method:'post',
     * data:data
     * data.append('ids',ids)'
     * data.append('navStatus',row,navStatus);
     */
    @RequestMapping(value = "/update/navStatus", method = RequestMethod.POST)
    public CommonResult updateNavStatus(@RequestParam(value = "ids") List<Long> ids,
                                        @RequestParam(value = "navStatus") Integer navStatus) {

        boolean result = ProductCategoryService.updateNavStatus(ids, navStatus);

        if (result) {
            return CommonResult.success(result);
        } else {
            return CommonResult.failed();
        }
        /**
         * 商品分类删除
         * url:'/productCategory/delete/+id',
         * method:'post'
         */
        @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
        public CommonResult delete (@PathVariable Long id){
            boolean result = ProductCategoryService.removeById(id);
            if (result) {
                return CommonResult.success(result);
            } else {
                return CommonResult.failed();
            }
        }
    }

    /**
     * 分类添加
     * url:'/productCategory/create',
     * method:'post',
     * data:data
     */

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public CommonResult create(@RequestBody PmsProductCategory productCategory) {

        boolean result = ProductCategoryService.save(productCategory);

        if (result) {
            return CommonResult.success(result);
        } else {
            return CommonResult.failed();
        }
    }

    /**
     * 根据id获取产品分类
     * return request({
     * url :'/productCategory/'+id
     * method:'get',
     * }
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public CommonResult<PmsProductCategory> getById(@PathVariable Long id) {

        PmsProductCategory productCategory = pmsProductCategoryService.getById(id);

        return CommonResult.success(productCategory);
    }

    /**
     * 修改
     * url:'/productCategory/update/+id',
     * method:'post',
     * data:data
     */
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public CommonResult update(
            @RequestBody PmsProductCategory productCategory) {

        boolean result = ProductCategoryService.updata(productCategory);

        if (result) {
            return CommonResult.success(result);
        } else {
            return CommonResult.failed();
        }
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public CommonResult create(@RequestBody PmsProductCategoryDTO productCategoryDTO) {

        boolean result = ProductCategoryService.CustomSave(productCategoryDTO);

        if (result) {
            return CommonResult.success(result);
        } else {
            return CommonResult.failed();
        }
    }

    /**
     * 获取商品一级分类和二级分类的下拉级联数据
     */
    @RequestMapping("/list/withChildren")
    public CommonResult getWithChildren() {
        List<ProductCateChildrenDTO> list = productCategoryService.getWithChildren();
        return CommonResult.success(list);
    }
}
