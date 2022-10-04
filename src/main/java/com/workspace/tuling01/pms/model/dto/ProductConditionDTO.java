package com.workspace.tuling01.pms.model.dto;

@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "商品列表筛选条件", description = "用于商品列表筛选条件的参数接受")
public class ProductConditionDTO {

    private String keyword;
    private Integer pageNum;
    private Integer pageSize;
    private Integer publishStatus;
    private Integer verifyStatus;
    private String productSn;
    private Long productCategoryId;
    private Long brandId;
}
