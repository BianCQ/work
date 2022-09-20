package com.workspace.tuling01.pms.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *     商品信息 前端控制器
 *     <p>
 *
 * @author XuShu
 * @since 2022-01-23
 *
 */
@RestController
@RequestMapping("/pms/pmsProduce")
public class PmsProductController {

    @Autowired
    PmsProductService pmsProductService;

    @ApiOperation("商品列表")
    @RequestMapping(value = "/List",method = RequestMethod.GET)
    public CommonResult<List<PmsProduce>> list(){
        List<PmsProduct> list = ProductService.list();
        return CommonResult.success(list);
    }
}
