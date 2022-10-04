package com.workspace.tuling01.pms.model.dto;

@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "商品保存数据传输对象", description = "用于商品添加，修改保存的参数接受 ")
public class ProductSaveParamsDTO extends PmsProduct {

    //会员价格
    @ApiModelProperty(value = "会员价格")
    private List<PmsMemberPrice> memberPriceList;
    //商品满减
    @ApiModelProperty(value = "商品满减")
    private List<PmsProductFullReduction> productFullReductionList;
    //商品阶梯价格
    @ApiModelProperty(value = "商品阶梯价格")
    private List<PmsProductLadder> productLadderList;
    //商品属性相关
    @ApiModelProperty(value = "商品属性相关")
    private List<PmsProductAttributeValue> pmsProductAttributeValueList;
    //商品sku库存信息
    @ApiModelProperty(value = "商品sku库存信息")
    private List<PmsSkuStock> skuStockList;

}
