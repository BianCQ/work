package com.workspace.tuling01.exception;


import org.springframework.stereotype.Controller;

@ControllerAdvice
@Slf4j
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

    /**
     * 处理未知异常
     */
    @ResponseBody
    @ExceptionHandler(value = RuntimeException.class)
    public CommonResult handleRuntimeException (RuntimeException e){
        log.error("运行时异常：",e);

        return CommonResult.failed(ResultCode.UNKNOWN());
    }



}
