package me.south10.controller;

import lombok.extern.slf4j.Slf4j;
import me.south10.domain.UserVO;
import me.south10.dto.LoginDTO;
import me.south10.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

/**
 * Created by south10 on 2016-06-23.
 */
@Controller
@Slf4j
@RequestMapping("/user")
public class UserController {
    @Inject
    private UserService service;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public void loginGET(@ModelAttribute("dto")LoginDTO dto){

    }

    @RequestMapping(value = "/loginPost", method = RequestMethod.POST)
    public void loginPOST(LoginDTO dto, HttpSession session, Model model) throws Exception{
        UserVO vo = service.login(dto);

        if (vo == null) {
            return;
        }

        model.addAttribute("userVO", vo);
    }
}
