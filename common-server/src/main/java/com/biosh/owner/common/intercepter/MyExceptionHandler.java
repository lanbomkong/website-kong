package com.biosh.owner.common.intercepter;

import com.biosh.owner.common.constants.ApplicationRetStubInfo;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @description
 * @date 2019/8/5
 */
@RestControllerAdvice
@Log4j2
public class MyExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public String handlerException(Exception exception) {
       log.info("异常处理：" + exception.getMessage());
       if (exception instanceof ApplicationRetStubInfo) {
           ApplicationRetStubInfo e = (ApplicationRetStubInfo) exception;
          return e.getRetStubDetailInfo().getMessage();
       }
       return "system is busy!";
    }

}
