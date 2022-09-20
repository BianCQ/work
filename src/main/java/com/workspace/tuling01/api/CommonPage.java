package com.workspace.tuling01.api;

import java.util.List;

/**
 * 分页数据封装类
 *
 */
public class CommonPage<T> {

    private Integer pageNum;
    private Integer pageSize;
    private Integer totalPage;
    private Long total;
    private List<T> list;

    /**
     * 将MyBatis Plus 分页结果转化为通用结果
     *
     */
    public static <T> CommonPage<T> restPage(Page<T> pageResult ){
        CommonPage<T> result = new CommonPage<>();
        //当前页
        result.setPageNum(Convert.toInt(pageResult.getCurrent()));
        //一页多少条数据
        result.setPageSize(Convert.toInt(pageResult.getSize()));
        //总数居数量
        result.setTotal(PageResult.getTotal());
        //总页数
        result.setTotalPage(Convert.toInt(pageResult.getTotal())/pageResult.getSize()+1);
        //当前页数据
        result.setList(pageResult.getRecords());
        return  result;
    }

}

