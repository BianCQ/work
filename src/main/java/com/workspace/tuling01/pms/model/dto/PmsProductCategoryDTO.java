package com.workspace.tuling01.pms.model.dto;

import com.workspace.tuling01.pms.controller.PmsProductCategory;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "对象",description = "分类添加")
public class PmsProductCategoryDTO extends PmsProductCategory {
    private List<Long> productAttributeIdList;

}
