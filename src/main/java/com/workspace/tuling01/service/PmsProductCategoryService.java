package com.workspace.tuling01.service;

import com.workspace.tuling01.pms.controller.PmsProductCategory;
import com.workspace.tuling01.pms.model.dto.HomeMenusDTO;
import com.workspace.tuling01.pms.model.dto.ProductCateChildrenDTO;

import java.util.List;

public interface PmsProductCategoryService extends Iservice<PmsProductCategory> {


    /**
     * 获取商品分类列表
     *
     * @param parentId
     * @param pageNum
     * @param pageSize
     * @Return
     */

    Page list(Long parentId, Integer pageNum, Integer pageSize);

    void updateNavStatus(List<Long> ids, Integer navStatus);

    boolean CustomSave(PmsProductAttribute pmsProductAttribute);

    List<RelationAttrInfoDTO> getRelationAttInfoByCid(Long cId);

    boolean update(PmsProductCategory productCategory);

    /**
     * 获取商品一级分类和二级分类的下拉级联数据
     */
    List<ProductCateChildrenDTO> getWithChildren();

    List<HomeMenusDTO> list= productCategoryService.getMenus();
}

