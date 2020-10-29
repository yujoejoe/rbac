package cn.wolfcode.rbac.service.impl;

import cn.wolfcode.rbac.domain.Employee;
import cn.wolfcode.rbac.mapper.EmployeeMapper;
import cn.wolfcode.rbac.query.EmployeeQueryObject;
import cn.wolfcode.rbac.query.PageResult;
import cn.wolfcode.rbac.query.QueryObject;
import cn.wolfcode.rbac.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public void insertOrUpdate(Employee employee) {
        if (employee.getId() != null) {
            employeeMapper.updateByPrimaryKey(employee);
        } else {
            employeeMapper.insert(employee);
        }
    }

    @Override
    public void delete(Long id) {
        employeeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Employee getOne(Long id) {
        Employee employee = employeeMapper.selectByPrimaryKey(id);
        return employee;
    }

    @Override
    public List<Employee> getAll() {
        List<Employee> employees = employeeMapper.selectAll();
        return employees;
    }

    @Override
    public PageResult query(EmployeeQueryObject qo) {
        int count = employeeMapper.selectForCount(qo);
        PageResult pageResult;
        if (count != 0) {
            List<Employee> data = employeeMapper.selectForData(qo);
            pageResult = new PageResult(data,count,qo.getCurrentPage(),qo.getPageSize());
        } else {
            pageResult = new PageResult(qo.getCurrentPage(),qo.getPageSize());
        }
        return pageResult;
    }

    @Override
    public void saveEmpAndRoleRelation(Long empId, Long[] roleIds) {
        if (empId != null) {
            employeeMapper.deleteEmpAndRoleRelation(empId);
        }
        //for快捷键 iter
        if (roleIds != null) {
            for (Long roleId : roleIds) {
                employeeMapper.saveEmpAndRoleRelation(empId,roleId);
            }
        }
    }
}
