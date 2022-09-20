package com.workspace.tuling01.pms.controller;

import com.workspace.tuling01.api.CommonPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * </p>
 * 产品分类，前端控制器
 * </p>
 *
 * @author  XuShu
 * @since  2022-01-24
 *
 */
@RestController
@RequestMapping("/productCategory")
public class PmsProductCategoryController {

    @Autowired
    PmsProductCategoryService pmsProductCategoryService;
    /**
     * url:'/prouductCategory/list/'+parentId,
     * method:'get'
     * params: {
     *     pageNum: 1,
     *     pageSize: 5
     * },
     */
    @RequestMapping(value = "/list/{parenId}", method = RequestMethod.GET)
    public CommonResult<List<PmsProductCategory>> getList(@PathVariable Long parenId,
                                                          @RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                                                          @RequestParam(value = "pageSize",defaultValue = "5")Integer pageSize){

      Pafe page = pmsProductCategoryService.list(parenId,pageNum.pageSize);

        CommonResult.success(CommonPage.restPage(page));
    }

}
