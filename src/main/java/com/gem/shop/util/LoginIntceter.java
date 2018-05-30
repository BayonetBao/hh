package com.gem.shop.util;

import com.gem.shop.entity.User;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginIntceter implements HandlerInterceptor {
    //请求没有处理之前拦截（身份检测）
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        安全认证
//        获得用户的请求URL
        String URL=request.getRequestURI();
        if(URL.endsWith("login.jsp")||URL.endsWith("login.action")
                ||URL.endsWith("register.jsp")||URL.endsWith("register.action")
                ||URL.endsWith("main.action")||URL.endsWith("/")){
            return true;
        }
        //已经登录
        HttpSession session=request.getSession();
        User user= (User) session.getAttribute("user");
        if(user!=null){
            return true;
        }
        //否则转发到登录页面
        request.getRequestDispatcher("/jsp/login.jsp").forward(request,response);
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {

    }
}
