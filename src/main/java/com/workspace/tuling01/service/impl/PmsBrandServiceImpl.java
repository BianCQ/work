package com.workspace.tuling01.service.impl;

import com.workspace.tuling01.service.PmsBrandService;
import org.springframework.util.StringUtils;

import java.util.List;


public class PmsBrandServiceImpl extends ServiceImpl<PmsBrandMapper, PmsBrand> implements PmsBrandService {
    @Override
    public Page list(String keyWord, Integer pageNum, Integer pageSize) {

        Page page = new Page(pageNum, pageSize);

        QueryWrapper<PmsBrand> pmsBrandQueryWrapper = new QueryWrapper<PmsBrand>();
        if (!StringUtils.isEmpty(keyWord)) {
            pmsBrandQueryWrapper.lambda().like(PmsBrand::GetName);
        }

        return this.page(page, pmsBrandQueryWrapper);
    }

    @Override
    public boolean updateNewStatus(Integer status, List<Long> ids, SFunction<PmsProduct, ?> getPublishStatus) {
        UpdateWrapper<PmsProduct> updateWrapper = new UpdateWrapper<>();
        updateWrapper.lambda().set(getPublishStatus, status)
                .in(PmsProduct::getId, ids);//where in (ids )
        return this.update(updateWrapper);
    }

}
