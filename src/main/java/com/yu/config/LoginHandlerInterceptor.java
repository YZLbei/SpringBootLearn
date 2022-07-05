package com.yu.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/7/5 20:13
 * @Description:
 */
public class LoginHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse
            response, Object handler) throws Exception {
// 获取 loginUser 信息进行判断
        Object user = request.getSession().getAttribute("loginuser");
        if (user == null){ // 未登录，返回登录页面
            request.setAttribute("msg","没有权限，请先登录");
            request.getRequestDispatcher("/index.html").forward(request,response);
            return false;
        }else {
// 登录，放行
            return true;
        }
    }
}

