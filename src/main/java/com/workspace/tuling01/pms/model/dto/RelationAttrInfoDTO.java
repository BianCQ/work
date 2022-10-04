package com.workspace.tuling01.pms.model.dto;


@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "分类和管理数据", description = "用于筛选属性的已报错数据的初始化")
public class RelationAttrInfoDTO {

    //商品类型id
    private Long attributeCategoryId;

    //商品属性
    private Long attributeId;

}
