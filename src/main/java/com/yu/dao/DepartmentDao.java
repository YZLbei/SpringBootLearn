package com.yu.dao;

import com.yu.pojo.Department;
import org.springframework.stereotype.Repository;

import java.text.DecimalFormat;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: YuZhenLong
 * @Date: 2022/7/3 16:56
 * @Description:
 */
//添加注解后就会被Spring托管
@Repository
public class DepartmentDao {
    //模拟数据库中的数据
    private static Map<Integer, Department> departments = null;
    static {
        departments = new HashMap<>();
        departments.put(101,new Department(101,"教学部"));
        departments.put(102,new Department(102,"教学部2"));
        departments.put(103,new Department(103,"教学部3"));
        departments.put(104,new Department(104,"教学部4"));
        departments.put(105,new Department(105,"教学部5"));
    }
    
    //获取所有部门信息
    public Collection<Department> getDepartment(){
        return departments.values();
    }
    
    
    public Department getDepartmentByid(Integer id){
        return departments.get(id);
    }
}
