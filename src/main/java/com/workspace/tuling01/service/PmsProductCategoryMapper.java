package com.workspace.tuling01.service;

import com.workspace.tuling01.pms.controller.PmsProductCategory;
import com.workspace.tuling01.pms.model.dto.HomeMenusDTO;

import java.util.List;

public interface PmsProductCategoryMapper extends BaseMapper<PmsProductCategory>{

    List<HomeMenusDTO> getProductWithCategory();
}
