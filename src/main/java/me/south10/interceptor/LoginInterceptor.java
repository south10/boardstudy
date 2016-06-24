package me.south10.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by south10 on 2016-06-23.
 */
@Slf4j
public class LoginInterceptor extends HandlerInterceptorAdapter{
    private static final String LOGIN = "login";

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HttpSession session = request.getSession();

        log.info("LoginInterceptor postHandle call.....");
        //ModelMap modelMap = modelAndView.getModelMap();
        Object userVO = modelAndView.getModel().get("userVO");

        if (userVO != null) {
            log.info("new login success");
            session.setAttribute(LOGIN, userVO);

            if(request.getParameter("useCookie") != null){
                log.info("remember me.........");
                Cookie loginCookie = new Cookie("loginCookie", session.getId());
                loginCookie.setPath("/");
                loginCookie.setMaxAge(60 * 60 * 24 * 7);
                response.addCookie(loginCookie);
            }
            Object dest = session.getAttribute("dest");
            log.info("LoginInterceptor dest : " + (String)dest);
            //response.sendRedirect("/");
            response.sendRedirect(dest != null ? (String)dest : "/");
        }
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();

        log.info("LoginInterceptor preHandle call.....");

        if(session.getAttribute(LOGIN) != null){
            log.info("clear login data before");
            session.removeAttribute(LOGIN);
        }
        return true;
    }
}
