package com.workspace.tuling01.service;

import com.workspace.tuling01.pms.model.dto.ProductSaveParamsDTO;

import java.util.List;

public interface PmsProductService extends IService<PmsProduct> {

    Page list(ProductConditionDTO condition);

    /**
     * 更新字段的公共方法
     */

    boolean updateNewStatus(Integer publishStatus, List<Long> ids, SFunction<PmsProduct, ?> getPublishStatus);

    boolean create(ProductSaveParamsDTO productSaveParamsDTO);

    boolean update(ProductSaveParamsDTO productSaveParamsDTO);
}
