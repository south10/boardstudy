package me.south10.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Locale;

/**
 * Created by south10 on 2016-06-10.
 */
@Controller
@Slf4j
public class TestController {
    @RequestMapping(value = "/doA", method = RequestMethod.GET)
    public String doA(){
        log.info("doA 호출");
        return "home";
    }

    @RequestMapping(value = "/doB", method = RequestMethod.GET)
    public String doB(Locale locale, Model model){
        log.info("doB 호출");
        model.addAttribute("result", "DOB RESULT");
        return "home";
    }

    @RequestMapping(value = "/doC", method = RequestMethod.GET)
    public String doC(RedirectAttributes rttr){
        rttr.addFlashAttribute("msg", "first message");
        return "redirect:/test/doD";
    }

    @RequestMapping(value = "/doD", method = RequestMethod.GET)
    public String doD(String msg){
        log.info("msg : " + msg);
        return "doD";
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public void ajaxTest(){

    }
}
