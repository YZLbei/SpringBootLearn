package com.yu.dao;

import com.yu.pojo.Department;
import com.yu.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/7/3 16:59
 * @Description:
 */
@Repository
public class EmployeeDao {
    //模拟数据库中的数据
    private static Map<Integer, Employee> employees = null;
    @Autowired
    private DepartmentDao departmentDao;
    static {
        employees  = new HashMap<>();
        employees .put(1001,new Employee(1001,"AA","wewewew@qq.com",0,new Department(101,"教学部")));
        employees .put(1002,new Employee(1002,"BB","wewewew@qq.com",1,new Department(102,"教学部2")));
        employees .put(1003,new Employee(1003,"CC","wewewew@qq.com",0,new Department(103,"教学部3")));
        employees .put(1004,new Employee(1004,"DD","wewewew@qq.com",1,new Department(104,"教学部4")));
        employees .put(1005,new Employee(1005,"EE","wewewew@qq.com",1,new Department(105,"教学部5")));
    }

    //增减一个员工
    private static Integer init = 1006;
    public void save(Employee employee){
        if (employee.getId()==null){
            employee.setId(init++);
        }
        employee.setDepartment(departmentDao.getDepartmentByid(employee.getDepartment().getId()));
        
        employees.put(employee.getId(),employee);
    }
    
    //获取所有部门信息
    public Collection<Employee> getEmployee(){
        return employees.values();
    }


    public Employee getEmployeeByid(Integer id){
        return employees.get(id);
    }
    
    
}
