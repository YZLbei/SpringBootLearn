package com.yu.controller;

import com.yu.dao.EmployeeDao;
import com.yu.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/7/5 21:16
 * @Description:
 */
@Controller
public class EmployeeController {
    @Autowired
    EmployeeDao employeeDao;
    
    @RequestMapping("emps")
    public String list(Model model){
        Collection<Employee> employees = employeeDao.getEmployee();
        model.addAttribute("emps",employees);
        return "emps/list";
    }
}
