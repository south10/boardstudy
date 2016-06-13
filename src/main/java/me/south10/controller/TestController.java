package me.south10.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Created by south10 on 2016-06-10.
 */
@Controller
@RequestMapping("/test/*")
@Slf4j
public class TestController {
    @RequestMapping(value = "/doA", method = RequestMethod.GET)
    public void doA(){
        log.info("doA 호출");
    }

    @RequestMapping(value = "/doB", method = RequestMethod.GET)
    public void doB(String bno){
        log.info("bno : {}", bno);
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
}
