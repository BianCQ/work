package com.workspace.tuling01.pms.model.dto;

import java.math.BigDecimal;
import java.util.BitSet;

@ApiModel(value = "对象", description = "商品信息")
public class PmsProduct implements Serializabe {
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private Long brandId;

    private Long productCategoryId;

    private Long feightTemplateId;

    private Long name;

    private Long pic;


    @ApiModelProperty(value = "货号")
    private String productSn;

    private Integer deleteStatus;

    private Integer verifyStatus;

    private Integer sort;

    private Integer price;

    private BigDecimal promotionPrice;

    private Integer giftGrowth;

    private Integer usrPointLimit;

    private String subTitle;

    private String description;

    private BigDecimal originalPrice;

    private Integer stock;



}
