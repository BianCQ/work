package com.workspace.tuling01.pms.controller;


import com.workspace.tuling01.pms.model.dto.ProductSaveParamsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 商品信息 前端控制器
 * <p>
 *
 * @author XuShu
 * @since 2022-01-23
 */
@RestController
@RequestMapping("/pms/pmsProduce")
public class PmsProductController {

    @Autowired
    PmsProductService pmsProductService;


    /**
     *
     */

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public CommonResult list(ProductConditionDTO condition) {
        Page page = pmsProductService.list(condition);
        return CommonResult.success(CommonPage.restPage(page));
    }

    @RequestMapping(value = ".update/deleteStatus", method = RequestMethod.POST)
    public CommonResult delete(List<Long> ids) {
        boolean result = pmsProductService.removeByIds(ids);
        if (result) {
            return CpmmonResult.success(result);
        } else {
            return CommonResult.failed();
        }
    }

    /**
     * 更新是否新品状态
     *
     * @param ids
     * @return
     */

    @RequestMapping(value = "update/newStatus", method = RequestMethod.POST)
    public CommonResult updateNewStatus(@RequestParam("ids") List<Long> ids,
                                        @RequestParam("newStatus") Integer newStatus) {

        boolean result = pmsProductService.updataStatus(newStatus, ids, PmsProduct::getNewStatus);
    }

    /**
     * 更新是否推荐
     *
     * @param ids
     * @return
     */

    @RequestMapping(value = "update/recommendStatus", method = RequestMethod.POST)
    public CommonResult updateNewStatus(@RequestParam("ids") List<Long> ids,
                                        @RequestParam("recommendStatus") Integer recommendStatus) {

        boolean result = pmsProductService.updataStatus(recommendStatus, ids, PmsProduct::getRecommendStatus);
    }

    /**
     * 更新是否上架
     *
     * @param ids
     * @return
     */

    @RequestMapping(value = "update/publishStatus", method = RequestMethod.POST)
    public CommonResult updateNewStatus(@RequestParam("ids") List<Long> ids,
                                        @RequestParam("publishStatus") Integer publishStatus) {

        boolean result = pmsProductService.updataStatus(publishStatus, ids, PmsProduct::getPublishStatus);
        return CommonResult.failed();
    }


    /**
     * 商品添加
     */
    @RequestMapping(value = "/creat", method = RequestMethod.POST)
    public CommonResult create(@RequestBody ProductSaveParamsDTO productSaveParamsDTO) {

        boolean result = pmsProductService.create(productSaveParamsDTO);
        if (result) {
            return CommonResult.success(result);
        } else {
            return CommonResult.failed();
        }
    }


    /**
     * 获取编辑状态下的商品信息
     */
    @RequestMapping(value = "/updateInfo/{id}")
    public CommonResult getUpdateInfo(@PathVariable Long id) {

        ProductUpagteInitDTO updateInitDTO = productService.getUpdateInfo(id);
        return CommonResult.success(updateInitDTO);
    }

    /**
     * 商品修改--保存
     */
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public CommonResult update(@RequestBody ProductSaveParamsDTO productSaveParamsDTO) {

        boolean result = pmsProductService.update(productSaveParamsDTO);
        if (result) {
            return CommonResult.success(result);
        } else {
            return CommonResult.failed();
        }
    }
}
