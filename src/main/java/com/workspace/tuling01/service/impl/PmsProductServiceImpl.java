package com.workspace.tuling01.service.impl;

import com.workspace.tuling01.pms.model.dto.*;
import com.workspace.tuling01.service.PmsProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.lang.reflect.Method;
import java.util.List;

@Service
public class PmsProductServiceImpl extends ServiceImpl<PmsProductMpper, PmsProduct> implements PmsProductService {

    @Autowired
    PmsPriductMapper pmsPriductMapper;

    @Autowired
    PmsMemberPriceService memberPriceService;

    @Autowired
    PmsProductLadderService productLadderService;

    @Autowired
    PmsProductFullReductionService productFullReductionService;

    @Autowired
    PmsSkuStockService skuStockService;

    @Autowired
    PmsProductAttributeValueService productAttributeValueService;

    @Override
    public Page list(ProductConditionDTO condition) {

        Page page = new Page(condition.getPageNum(), condition.getPageSize());

        QueryWrapper<PmsProduct> queryWrapper = new QueryWrapper<>();
        LambdaQueryWrapper<PmsProduct> lambda = queryWrapper.lambda();
        //商品分类
        if (StringUtils.isEmpty(condition.getKeyword())) {
            queryWrapper.like(PmsProduct::getName, condition.getKeyword);
        }
        //商品品牌
        if (condition.getBrandId() != null && condition.getBrandId() > 0) {
            lambdaWrapper.eq(PmsProduct::getBrandId, condition.getBrandId());
        }
        //上架状态
        if (condition.getPublishStatus() != null && condition.getPublishStatus() > 0) {
            lambdaWrapper.eq(PmsProduct::getPublishStatus, condition.getPublishStatus());
        }
        //审核状态
        if (condition.getVerifyStatus() != null && condition.getVerifyStatus() > 0) {
            lambdaWrapper.eq(PmsProduct::getVerifyStatus, condition.getVerifyStatus());
        }
        return this.page(page, lambdaWrapper);
    }


    /**
     * 添加
     */

    @Override
    @Transactional
    public boolean create(ProductSaveParamsDTO productSaveParamsDTO) {

        //1 保存商品基本信息--商品主表

        PmsProduct pmsProduct = productSaveParamsDTO;
        product.setIid(null);
        boolean result = this.save(product);
        if (result) {
            switch (product.getPromotionType()) {
                case 2:

                    //2 会员价格


                    //根据商品id删除
                    DeleteManyListByProductId(product.getId(), memberPriceService);
                    SaveManyList(productSaveParamsDTO.getMemberPriceList(),
                            product.getId(), memberPriceService);
                    break;
                case 3:

                    //根据商品id删除
                    DeleteManyListByProductId(product.getId(), productLadderService);

                    //阶梯价格
                    SaveManyList(productSaveParamsDTO.getProductLadderList(),
                            product.getId(), productLadderService);
                    break;
                case 4:

                    //根据商品id删除
                    DeleteManyListByProductId(product.getId(), productFullReductionService);
                    //减满价格
                    SaveManyList(productSaveParamsDTO.getProductFullReductionList(),
                            product.getId(), productFullReductionService);
                    break;
            }

            //根据商品id删除
            DeleteManyListByProductId(product.getId(), skuStockService);

            //3 sku
            SaveManyList(productSaveParamsDTO.getSkuStockList(), product.getId(),
                    skuStockService);

            //根据商品id删除
            DeleteManyListByProductId(product.getId(), memberPriceService);

            // spu
            SaveManyList(productSaveParamsDTO.productAttributeValueService(),
                    product.getId(), productAttributeValueService);


        }
        return result;
    }

    /**
     * 根据商品id删除关联数据
     */
    public void DeleteManyListByProductId(Long productId, IService service) {

        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("product_id,productId");
        service.remove(queryWrapper);

    }

    /**
     * 公共方法  保存会员价格 阶梯价格 减满价格 sku spu商品的关联数据
     * <p>
     * 统一  都需要设置商品id，都需要批量保存
     */
    public void SaveManyList(List list, Long productId, IService service) {
        //如果数据为空 或者长度为零 不做任何操作
        if (CollectionUtils.isEmpty(list)) return;
        try {


            //循环 赋值商品ID
            for (Object obj : list) {
                Method setProductIdMethod = obj.getClass().getMethod("setProductId", Long.class);
                setProductIdMethod.invoke(obj, productId);

            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
