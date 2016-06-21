package me.south10.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by south10 on 2016-06-13.
 */
@ControllerAdvice
@Slf4j
public class CommonExceptionAdvice {
    //@ExceptionHandler(Exception.class)
    public String common(Exception e){
        log.info(e.toString());
        return "error_common";
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView errorModelAndView(Exception ex){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/error_common");
        modelAndView.addObject("exception", ex);
        return modelAndView;
    }
}
