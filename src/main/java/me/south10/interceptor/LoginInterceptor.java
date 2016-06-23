package me.south10.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

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

        //ModelMap modelMap = modelAndView.getModelMap();
        Object userVO = modelAndView.getModel().get("userVO");

        if (userVO != null) {
            log.info("new login success");
            session.setAttribute(LOGIN, userVO);
            Object dest = session.getAttribute("dest");
            //response.sendRedirect("/");
            response.sendRedirect(dest != null ? (String)dest : "/");
        }
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();

        if(session.getAttribute(LOGIN) != null){
            log.info("clear login data before");
            session.removeAttribute(LOGIN);
        }
        return true;
    }
}
