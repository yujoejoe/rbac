package cn.wolfcode.rbac.service;

import cn.wolfcode.rbac.domain.Department;
import cn.wolfcode.rbac.query.PageResult;
import cn.wolfcode.rbac.query.QueryObject;

import java.util.List;

public interface IDepartmentService {

    //增加 或 修改 (通过department对象中是否存在id判断。不存在-insert；存在-update)
    void insertOrUpdate(Department department);

    //删除
    void delete(Long id);

    //查询单个
    Department getOne(Long id);

    //查询所有
    List<Department> getAll();

    PageResult query(QueryObject qo);
}
