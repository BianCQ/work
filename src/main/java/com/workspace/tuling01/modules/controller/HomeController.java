package com.workspace.tuling01.modules.controller;

import com.workspace.tuling01.pms.model.dto.HomeMenusDTO;

import java.util.List;

/**
 * 首页控制器
 */
@ResController
@Api(tags = "HomeController",description="首页内容管理")
@RequestMappering("/home")


public class HomeController {

    @Autowired
    PmsProductCategoryService pmsProductCategoryService;

    /**
     * 获取首页类型导航栏和数据
     *
     */
    @RequesstMapper(value = "/menus",method = RequestMethod.GET)
    public CommonResult getMenus(){
        List<HomeMenusDTO> list =pmsProductCategoryService.getMenus();

        return CommonResult.success(list);


    }
}


