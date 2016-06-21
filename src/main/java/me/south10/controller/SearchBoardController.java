package me.south10.controller;

import lombok.extern.slf4j.Slf4j;
import me.south10.domain.BoardVO;
import me.south10.domain.PageMaker;
import me.south10.domain.SearchCriteria;
import me.south10.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by south10 on 2016-06-14.
 */
@Controller
@RequestMapping("/sboard/*")
@Slf4j
public class SearchBoardController {
    @Inject
    BoardService service;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public void listPage(@ModelAttribute("cri") SearchCriteria cri, Model model) throws Exception{
        log.info(cri.toString());
        //model.addAttribute("list", service.listCriteria(cri));
        model.addAttribute("list", service.listSearchCriteria(cri));
        PageMaker pageMaker = new PageMaker();
        pageMaker.setCri(cri);
        //pageMaker.setTotalCount(service.countPaging(cri));
        pageMaker.setTotalCount(service.listSearchCount(cri));
        model.addAttribute("pageMaker", pageMaker);
    }

    @RequestMapping(value = "/readPage", method = RequestMethod.GET)
    public void read(@RequestParam("bno")int bno, @ModelAttribute("cri") SearchCriteria cri, Model model) throws Exception{
        model.addAttribute(service.read(bno));
    }

    @RequestMapping(value = "/removePage", method = RequestMethod.POST)
    public String remove(@RequestParam("bno") int bno, SearchCriteria cri, RedirectAttributes rttr) throws Exception{
        service.remove(bno);
        rttr.addAttribute("page", cri.getPage());
        rttr.addAttribute("perPageNum", cri.getPerPageNum());
        rttr.addAttribute("searchType", cri.getSearchType());
        rttr.addAttribute("keyword", cri.getKeyword());
        rttr.addFlashAttribute("msg", "success");
        return "redirect:/sboard/list";
    }

    @RequestMapping(value = "/modifyPage", method = RequestMethod.GET)
    public void modifyPageGET(@RequestParam("bno")int bno, @ModelAttribute("cri") SearchCriteria cri, Model model) throws Exception{
        model.addAttribute(service.read(bno));
    }

    @RequestMapping(value = "/modifyPage", method = RequestMethod.POST)
    public String modifyPagePOST(BoardVO vo, SearchCriteria cri, RedirectAttributes rttr) throws Exception{
        service.modify(vo);
        rttr.addAttribute("page", cri.getPage());
        rttr.addAttribute("perPageNum", cri.getPerPageNum());
        rttr.addAttribute("searchType", cri.getSearchType());
        rttr.addAttribute("keyword", cri.getKeyword());
        rttr.addFlashAttribute("msg", "success");
        return "redirect:/sboard/list";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public void registerGET() throws Exception{

    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerPOST(BoardVO vo, RedirectAttributes rttr) throws Exception{
        service.regist(vo);
        rttr.addFlashAttribute("msg", "success");
        return "redirect:/sboard/list";
    }

    @RequestMapping("/getAttach/{bno}")
    @ResponseBody
    public List<String> getAttach(@PathVariable("bno") Integer bno) throws Exception{
        return service.getAttach(bno);
    }
}
