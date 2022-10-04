package com.workspace.tuling01.service.impl;

import com.workspace.tuling01.service.PmsProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 商品属性参数表 服务实现类
 * </p>
 */
@Service
public class PmsProductAttributeServiceImpl extends ServiceImpl<PmsProductAttributeMapper, PmsProductCategoryService> {

    @Autowired
    PmsProductAttributeMapper pmsProductAttributeMapper;

    @Autowired
    PmsProductAttributeCategoryService productAttrCateService;

    @Override
    public Page list(Long cid, Integer type, Integer pageNum, Integer pageSize) {

        Page page = new Page(pageNum, pageSize);
        QueryWrapper<PmsProductAttribute> queryWrapper = new QueryWrapper<>();
        queryWrapper()
                .eq(PmsProductAttribute::getProductAttributeCategoryId, cid)
                .eq(PmsProductAttribute::GetType, type);
        return this.page(page, queryWrapper);
    }

    @Override
    public boolean create(PmsProductAttribute productAttribute) {
        // 1 保存商品属性
        boolean save = this.save(productAttribute);

        if (save) {

            // 2 更行对应的属性 参数的数量
            //      1 查询商品类型，在更新 2  直接更新  update  +1

            UpdateWrapper<PmsProductAttributeCategory> updateWrapper = new UpdateWrapper();

            //属性
            if (productAttribute.getType() == 0) {
                updateWrapper.setSql("attribute_count = attribute_count+1");
            }

            //参数
            else if (productAttribute.getType() == 1) {
                updateWrapper.setSql("param_count = param_count+1");
            }
            updateWrapper.lambda().eq(PmsProductAttributeCategory::getId)
            productAttrCateService.update(updateWrapper);
        }
        return save;
    }

    @Override
    public List<RelationAttrInfoDTO> getRelationAttInfoByCid(Long cId) {
        return pmsProductAttributeMapper.;
    }
}

