package com.workspace.tuling01.pms.model.dto;

import java.math.BigDecimal;

@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "商品的数据传输对象",description = "商品的数据传输对象")
public class ProductDTO{

    private Long id;

    private Long name;

    private Long pic;
@ApiModelProperty(value = "促销价格")
    private BigDecimal promotionPrice;
    @ApiModelProperty(value = "市场价")
    private BigDecimal originalPrice;
    @ApiModelProperty(value = "副标题")
    private String subTitle;

}
