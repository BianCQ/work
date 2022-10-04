package com.workspace.tuling01.exception;

public class GlobalExceptionHandler {

    /**
     * 处理已知异常
     *
     */
    @ResponseBody
    @ExceptionHandler(value = ApiException.class)
    public CommonResult handle (ApiException e){
        if (e.getErrorCode() !=null){
            return CommonResult.failed(e.getErrorCode());

        }
        return CommonResult.failed(e.getMessage());
    }



}
