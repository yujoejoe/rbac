package cn.wolfcode.rbac.domain;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Employee {
    private Long id;

    private String name;

    private String password;

    private String email;

    private Integer age;

    private Boolean admin = false;  //默认不是超级管理员

    private Department dept; //部门类型

    private List<Role> roles;  //角色


}