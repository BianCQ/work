package com.workspace.tuling01.srevice.impl;

import com.workspace.tuling01.pms.controller.PmsProductController;

public class PmsProductCategoryServiceImpl extends ServiceImpl<PmsProductCategoryMapper,PmsProductCategoryService> {

    /**
     * 获取商品分类列表
     * @param parentId 一级： 0
     * @param pageNum
     * @param pageSize
     * @Return
     */

    @Override
    public Page list(Long parentId, Integer pageNum, Integer pageSize){

       Page page =new Page(pageNum,pageSize);
        //条件构造器
        QueryWrapper<PmsProductCategory> queryWrapper = new  QueryWrapper<>();
        //queryWrapper.eq("parent_id",parentId);
        QueryWrapper.lambda.eq(PmsProductCategory::getParentId,parentId);
        return this.page(page, queryWrapper);
    }
}
