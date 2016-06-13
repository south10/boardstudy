package me.south10.controller;

import lombok.extern.slf4j.Slf4j;
import me.south10.domain.BoardVO;
import me.south10.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.inject.Inject;

/**
 * Created by south10 on 2016-06-10.
 */
@Controller
@RequestMapping("/board/*")
@Slf4j
public class BoardController {
    @Inject
    private BoardService service;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public void registerGET(BoardVO board, Model model) throws Exception {
        log.info("register get.......");
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerPOST(BoardVO board, RedirectAttributes rttr) throws Exception{
        log.info("register post......");
        log.info(board.toString());
        service.regist(board);
        rttr.addAttribute("msg", "success");
        return "redirect:/listAll";
    }

    @RequestMapping(value ="/listAll", method = RequestMethod.GET)
    public void listAll(Model model)throws Exception{
        log.info("show all list....");
        model.addAttribute("list", service.listAll());
    }
}
