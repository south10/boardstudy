package me.south10.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by south10 on 2016-06-23.
 */
@Slf4j
public class AuthInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();

        if(session.getAttribute("login") == null){
            log.info("current user is not logined");
            saveDest(request);
            response.sendRedirect("/user/login");
            return false;
        }
        return true;
    }

    private void saveDest(HttpServletRequest request) {
        String uri = request.getRequestURI();
        String query = request.getQueryString();

        if(query == null || query.equals("null")){
            query = "";
        }else {
            query = "?" + query;
        }

        if(request.getMethod().equals("GET")){
            log.info("dest: " + (uri + query));
            request.getSession().setAttribute("dest", uri + query);
        }
    }
}
