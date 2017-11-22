package com.lanou.Interceptor;

import com.lanou.admin.domain.Admin;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by dllo on 17/11/21.
 */
//登录拦截器 将用户存到session中 再在拦截器中判断用户  low
public class LoginInterceptor implements HandlerInterceptor {



    public boolean preHandle(HttpServletRequest request, HttpServletResponse httpServletResponse, Object o) throws Exception {

        String url = request.getRequestURI();
        if (url.indexOf("login") != -1){
            return true;
        }
        Admin admin = (Admin) request.getSession().getAttribute("loginAdmin");
        if (admin == null){
            request.getRequestDispatcher("/login.html").forward(request,httpServletResponse);
        }
        return true;
    }


    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
