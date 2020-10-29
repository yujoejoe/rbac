package cn.wolfcode.rbac.service;

import cn.wolfcode.rbac.domain.Role;
import cn.wolfcode.rbac.query.PageResult;
import cn.wolfcode.rbac.query.QueryObject;

import java.util.List;

public interface IRoleService {

    //增加 或 修改
    void insertOrUpdate(Role role);

    //删除
    void delete(Long id);

    //查询单个
    Role getOne(Long id);

    //查询所有
    List<Role> getAll();

    PageResult query(QueryObject qo);
}
