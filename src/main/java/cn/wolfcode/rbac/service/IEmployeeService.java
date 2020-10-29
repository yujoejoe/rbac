package cn.wolfcode.rbac.service;

import cn.wolfcode.rbac.domain.Employee;
import cn.wolfcode.rbac.query.EmployeeQueryObject;
import cn.wolfcode.rbac.query.PageResult;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IEmployeeService {

    //增加 或 修改
    void insertOrUpdate(Employee employee);

    //删除
    void delete(Long id);

    //查询单个
    Employee getOne(Long id);

    //查询所有
    List<Employee> getAll();

    //带分页效果的数据集
    PageResult query(EmployeeQueryObject qo);

    void saveEmpAndRoleRelation(Long empId,Long[] roleIds);
}
