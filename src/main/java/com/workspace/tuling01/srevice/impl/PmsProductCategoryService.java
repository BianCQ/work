package com.workspace.tuling01.srevice.impl;

public interface PmsProductCategoryService extends Iservice<PmsProductCategory> {


    /**
     * 获取商品分类列表
     * @param parentId
     * @param pageNum
     * @param pageSize
     * @Return
     */

    Page list (Long parentId,Integer pageNum, Integer pageSize);
}

