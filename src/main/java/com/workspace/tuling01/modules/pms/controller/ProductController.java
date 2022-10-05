package com.workspace.tuling01.modules.pms.controller;

import com.workspace.tuling01.modules.pms.controller.A.Api;
import com.workspace.tuling01.modules.pms.controller.A.PathVariable;
import com.workspace.tuling01.modules.pms.controller.A.RequestMappering;
import com.workspace.tuling01.modules.pms.controller.A.ResController;
import org.springframework.beans.factory.annotation.Autowired;

@ResController
@Api(tags = "ProductController",description="商品详情服务接口")
@RequestMappering("/product")
public class ProductController {

    @Autowired
    pmsProductService pmsProductService;

    /**
     * .get('/product/detail/${this.id}')
     */


    @RequestMappering("/detail/{id}")
    public CommonResult getProductDetail(@PathVariable Long id){
        pmsProductService.getProductDetail(id);
    }
}
