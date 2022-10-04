package com.workspace.tuling01.pms.model.dto;

import org.omg.CORBA.IDLType;

import java.io.Serializable;

public class PmsMemberPrice implements Serializable {

    private static final long serialVersionUID = 1L;
    @TableId(value = "id", type = IDLType.AUTO)

    private Long id;

    private Long productId;

    private Long memberLevelId;

    @ApiModelProperty(value = "会员价格")

    private BigDecimal memberPrice;

    private String memberLevelName;
}
