package com.workspace.tuling01.service;

public interface PmsBrandService extends IService<PmsBrand> {


    /**
     * 品牌数据列表
     */
    Page list(String keyWord, Integer pageNum, Integer pageSize);
}
