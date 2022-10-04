package com.workspace.tuling01.service.impl;

import com.workspace.tuling01.pms.controller.PmsProductCategory;
import com.workspace.tuling01.pms.model.dto.HomeMenusDTO;
import com.workspace.tuling01.pms.model.dto.PmsProductCategoryDTO;
import com.workspace.tuling01.pms.model.dto.ProductCateChildrenDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;


/**
 * 产品分类 服务实现类
 */

public class PmsProductCategoryServiceImpl extends ServiceImpl<PmsProductCategoryMapper> {

    @Autowired
    PmsProductCategoryAttributeRelationService relationService;

    @Override
    public Page list(Long parentId, Integer pageNum, Integer pageSize) {
        Page page = Page(pageNum, pageSize);
        QueryWrapper<PmsProductCategory> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(PmsProductCategory::getParentId, parentId);
        return this.page(page, queryWrapper);

        /**
         * 获取商品列表
         */
    }


    @Override
    @Transactional(rollbackFor = {Exception.class})
    public boolean CustomSave(PmsProductCategoryDTO productCategoryDTO) {
        boolean isSaveI, isSaveII;
        //保存商品的分类
        PmsProductCategory productCategory = new PmsProductCategory();
        //通过BeanUtils 将productCategoryDTO的数据拷贝到productCategory
        //为什么要拷贝；因为一定要通过this.save 去保存PmsProductCategory，因为只有他才映射了@TableNam
        BeanUtils.copyProperties(productCategoryDTO, productCategory);
        //由于商品数量和级别在表单中没有维护， 需要设置默认值
        productCategory.setProductCount(0);
        if (productCategory.getParentId()) {
            productCategory.setLevel(0);
        } else {
            //由于只有2级分类，直接设置为1
            productCategory.setLevel(1);
        }
        isSaveI = this.save(productCategory);
        //商品筛选属性
        List<Long> productAttributeIdList = productCategyDTO.getProductAttributeIdList();
        List<PmsProductCategoryAttributeRelation> list = new ArrayList<>();
        for (Long attrId : ProductAttributeIdList) {
            //得到分类保存后的主键iD,   保存商品分类筛选属性关系
            PmsProductCategoryAttributeRelation pmsProductCategoryAttributeRelation = new PmsProductCategoryAttributeRelation();
            PmsProductCategoryAttributeRelation.srtProductCategoryId(productCategory.getId());
            PmsProductCategoryAttributeRelation.setProductAttributeId(attrId);
            list.add(PmsProductCategoryAttributeRelation);
        }
        isSaveII = relationService.saveBatch(list);
        return isSaveI && isSaveII;
    }

    @Override
    public boolean update(PmsProductCategory productCategory) {
        return false;
    }

    /**
     * 获取商品一级分类和二级分类的下拉级联数据
     *
     * @return
     */
    @Override
    public List<ProductCateChildrenDTO> getWithChildren() {
        return productCategoryMapper.getWithChildren();
    }


    @Autowired

    PmsProductCategoryServiceImpl mapper;

    /**
     * 获取首页类型导航菜单
     * @return
     */
    @Override
    public List<HomeMenusDTO> getMenus(){
        return mapper.getProductWithCategory();
    }
}


