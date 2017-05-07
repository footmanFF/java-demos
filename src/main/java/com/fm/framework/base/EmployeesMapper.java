package com.fm.framework.base;

import org.apache.ibatis.annotations.Select;

/**
 * Created by zhangli on 2017/5/2.
 */
public interface EmployeesMapper {

    @Select("SELECT * FROM employees WHERE emp_no = #{emp_no}")
    Employees getEmployees(long emp_no);

}
