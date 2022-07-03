package com.yu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/7/3 17:11
 * @Description:不建议这么使用，应该用视图控制器映射
 */
@Controller
public class IndexController {
    
//    //不建议这么使用，应该用视图控制器映射
//    @RequestMapping({"/","/index.html"})
//    public String index(){
//        return "index";
//    }
}
