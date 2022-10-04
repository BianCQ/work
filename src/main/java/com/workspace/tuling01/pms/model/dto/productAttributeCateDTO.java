package com.workspace.tuling01.pms.model.dto;


import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel()
public class productAttributeCateDTO {
    //商品类型id
    private Long id;

    //商品类型名称
    private String name;

    //商品属性二级级联
    private List<PmsProductAttribute> pmsProductAttributes;
}
