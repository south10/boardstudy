package me.south10.controller;

import lombok.extern.slf4j.Slf4j;
import me.south10.domain.BoardVO;
import me.south10.domain.Criteria;
import me.south10.domain.PageMaker;
import me.south10.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
        rttr.addFlashAttribute("msg", "success");
        return "redirect:/board/listAll";
    }

    @RequestMapping(value ="/listAll", method = RequestMethod.GET)
    public void listAll(Model model)throws Exception{
        log.info("show all list....");
        model.addAttribute("list", service.listAll());
    }

    @RequestMapping(value = "/read", method = RequestMethod.GET)
    public void read(@RequestParam("bno")int bno, Model model)throws Exception{
        model.addAttribute(service.read(bno));
    }

    @RequestMapping(value = "/remove", method = RequestMethod.POST)
    public String remove(@RequestParam("bno")int bno, RedirectAttributes rttr) throws Exception{
        service.remove(bno);
        rttr.addFlashAttribute("msg","success");
        return "redirect:/board/listAll";
    }

    @RequestMapping(value = "/modify", method = RequestMethod.GET)
    public void modifyGET(int bno, Model model) throws Exception{
        log.info("modifyGET....");
        model.addAttribute(service.read(bno));
    }

    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    public String modifyPOST(BoardVO board, RedirectAttributes rttr) throws Exception{
        log.info("modifyPOST....");
        service.modify(board);
        rttr.addFlashAttribute("msg", "success");
        return "redirect:/board/listAll";
    }

    @RequestMapping(value = "/listCri", method = RequestMethod.GET)
    public void listAll(Criteria cri, Model model) throws Exception{
        log.info("show list page with criteria....");
        model.addAttribute("list", service.listCriteria(cri));
    }

    @RequestMapping(value = "/listPage", method = RequestMethod.GET)
    public void listPage(@ModelAttribute("cri") Criteria cri, Model model) throws Exception{
        log.info(cri.toString());
        model.addAttribute("list", service.listCriteria(cri));
        PageMaker pageMaker = new PageMaker();
        pageMaker.setCri(cri);
        //pageMaker.setTotalCount(131);
        pageMaker.setTotalCount(service.countPaging(cri));
        model.addAttribute("pageMaker", pageMaker);
    }

    @RequestMapping(value = "/readPage", method = RequestMethod.GET)
    public void read(@RequestParam("bno") int bno, @ModelAttribute("cri") Criteria cri, Model model) throws Exception{
        model.addAttribute(service.read(bno));
    }

    @RequestMapping(value = "/removePage", method = RequestMethod.POST)
    public String remove(@RequestParam("bno") int bno, Criteria cri, RedirectAttributes rttr) throws Exception{
        service.remove(bno);
        rttr.addAttribute("page", cri.getPage());
        rttr.addAttribute("perPageNum", cri.getPerPageNum());
        rttr.addFlashAttribute("msg", "success");
        return "redirect:/board/listPage";
    }

    @RequestMapping(value = "/modifyPage", method = RequestMethod.GET)
    public void modifyPagingGET(@RequestParam("bno") int bno, @ModelAttribute("cri") Criteria cri, Model model) throws Exception{
        model.addAttribute(service.read(bno));
    }

    @RequestMapping(value = "/modifyPage", method = RequestMethod.POST)
    public String modifyPagingPOST(BoardVO board, Criteria cri, RedirectAttributes rttr) throws Exception{
        service.modify(board);
        rttr.addAttribute("page", cri.getPage());
        rttr.addAttribute("perPageNum", cri.getPerPageNum());
        rttr.addFlashAttribute("msg", "success");
        return "redirect:/board/listPage";
    }
}
