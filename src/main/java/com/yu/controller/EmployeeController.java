package com.yu.controller;

import com.yu.dao.DepartmentDao;
import com.yu.dao.EmployeeDao;
import com.yu.pojo.Department;
import com.yu.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
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
    @Autowired
    DepartmentDao departmentDao;
    
    @RequestMapping("emps")
    public String list(Model model){
        Collection<Employee> employees = employeeDao.getEmployee();
        model.addAttribute("emps",employees);
        return "emps/list";
    }
    
    @RequestMapping("emp")
    public String toAddPage(Model model){
        Collection<Department> departments = departmentDao.getDepartment();
        model.addAttribute("departments",departments);
        return "emps/add";
    }

    //接收前端传递的参数，自动封装成为对象[要求前端传递的参数名，和属性名一致]
    @PostMapping("emp")
    public String addEmp(Employee employee){
        System.out.println(employee);
        //添加的操作
        employeeDao.save(employee);
        return "redirect:/emps";
    }
}
