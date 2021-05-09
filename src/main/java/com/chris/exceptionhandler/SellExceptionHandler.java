package com.chris.exceptionhandler;

import com.chris.config.ProjectUrlConfig;
import com.chris.exception.SellException;
import com.chris.exception.SellerAuthorizeException;
import com.chris.utils.ResultVOUtil;
import com.chris.viewobj.ResultVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.invocation.ReactiveReturnValueHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@ControllerAdvice
public class SellExceptionHandler {

    @Autowired
    private ProjectUrlConfig projectUrlConfig;

    //拦截登录异常
    //http://sell.natapp4.cc/sell/wechat/qrAuthorize?returnUrl=http://sell.natapp4.cc/sell/seller/login
    @ExceptionHandler(value = SellerAuthorizeException.class)
    public ModelAndView handlerAuthorizeException() {
        return new ModelAndView("redirect:"
        .concat(projectUrlConfig.getWechatOpenAuthorize())
        .concat("/sell/wechat/qrAuthorize")
        .concat("?returnUrl=")
        .concat(projectUrlConfig.getSell())
        .concat("/sell/seller/login"));
    }
    
    
    //处理商品不存在的异常    
    @ExceptionHandler(value=SellException.class)
    @ResponseBody
    public ResultVO handleSellException(SellException e) {
    	return ResultVOUtil.error(e.getCode(),e.getMessage());
    }
}
