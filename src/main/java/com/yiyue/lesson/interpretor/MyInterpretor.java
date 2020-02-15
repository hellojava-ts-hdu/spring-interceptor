package com.yiyue.lesson.interpretor;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyInterpretor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("拦截方法访问之前调用");
        String requesturi = request.getRequestURI();
        System.out.println(requesturi+"接口被MyInterpretor拦截了");
        //判断用户是否携带凭证
        String token = request.getHeader("token");
        if (StringUtils.isEmpty(token)){
            request.getRequestDispatcher("/api/open/unLogin").forward(request,response);
            return false;
        }else {
            return true;
        }

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("拦截方法访问之后调用");
    }

    @Override
    public void afterCompletion(HttpServletRequest request,HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("整个流程之后调用");
    }
}
