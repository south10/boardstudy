package me.south10.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * Created by south10 on 2016-06-23.
 */
@Slf4j
public class SampleInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("pre handle......");

        HandlerMethod method = (HandlerMethod) handler;
        Method methodObj = method.getMethod();

        log.info("Bean: {}", method.getBean());
        log.info("Method: {}", methodObj);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("post handle.....");
        Object result = modelAndView.getModel().get("result");

        if (result != null) {
            request.getSession().setAttribute("result", result);
            response.sendRedirect("/doA");
        }
    }
}
