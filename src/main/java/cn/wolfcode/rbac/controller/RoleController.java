package cn.wolfcode.rbac.controller;

import cn.wolfcode.rbac.domain.Role;
import cn.wolfcode.rbac.query.PageResult;
import cn.wolfcode.rbac.query.QueryObject;
import cn.wolfcode.rbac.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private IRoleService roleService;

    @RequestMapping("/list")
    public String selectAll(Model model, QueryObject qo) {
        PageResult all = roleService.query(qo);
        model.addAttribute("pageResult",all);
        return "role/list";
    }

    @RequestMapping("delete")
    public String delete(Long id) {
        roleService.delete(id);
        return "redirect:/role/list";
    }

    @RequestMapping("/input")
    public String input(Long id,Model model) {
        if (id != null) {
            Role one = roleService.getOne(id);
            model.addAttribute("role",one);
        }
        return "role/input";
    }

    @RequestMapping("/saveOrUpdate")
    public String saveOrUpdate(Role role) {
        roleService.insertOrUpdate(role);
        return "redirect:/role/list";
    }
}
