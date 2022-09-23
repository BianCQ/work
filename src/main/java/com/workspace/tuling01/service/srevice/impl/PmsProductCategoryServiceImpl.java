package com.workspace.tuling01.service.srevice.impl;

import java.util.List;

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

    /**
     * 修改导航栏显示状态
     * @param ids
     * @param nacStatus
     */
    @Override
    public boolean updateNavStatus(List<Long> ids, Integer nacStatus){

        UpdateWrapper<PmsProductCategory> pmsProductCategoryUpdateWrapper = new UpdateWrapper<>();

         pmsProductCategoryUpdateWrapper.lambda()
                 //需要更行的列
                 .set(PmsProductCategory::GetNavStatus,navStatus)
                 //条件
                .in(PmsProductCategory::getId,ids);
        return this.update(pmsProductCategoryUpdateWrapper);
    }

}
