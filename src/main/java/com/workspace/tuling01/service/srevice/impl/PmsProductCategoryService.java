package com.workspace.tuling01.service.srevice.impl;

import java.util.List;

public interface PmsProductCategoryService extends Iservice<PmsProductCategory> {


    /**
     * 获取商品分类列表
     * @param parentId
     * @param pageNum
     * @param pageSize
     * @Return
     */

    Page list (Long parentId,Integer pageNum, Integer pageSize);

    void updateNavStatus(List<Long>ids, Integer navStatus);
}

