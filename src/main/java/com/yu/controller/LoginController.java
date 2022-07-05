package com.yu.controller;




import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/7/3 20:59
 * @Description:
 */
@Controller
public class LoginController {
    @RequestMapping("/user/login")
    public String login(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            Model model, HttpSession session){
        if (!StringUtils.isEmpty(username)&&password.equals("123456")){
            session.setAttribute("loginuser",username);
            //return "dashboard";
            return "redirect:/main.html";
        } 
        else {
            //告诉用户登陆失败
            model.addAttribute("msg","用户名或者密码错误");
            return "index";
        }
    }
}
