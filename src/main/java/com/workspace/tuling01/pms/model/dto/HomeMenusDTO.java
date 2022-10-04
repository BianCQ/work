package com.workspace.tuling01.pms.model.dto;


import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "首页的类型导航栏数据",description = "首页的类型导航栏数据")
public class HomeMenusDTO {

    private  Long id;
    private String name;

    private List<ProductDTO> productList


}
