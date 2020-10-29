package cn.wolfcode.rbac.controller;

import cn.wolfcode.rbac.domain.Department;
import cn.wolfcode.rbac.domain.Employee;
import cn.wolfcode.rbac.domain.Role;
import cn.wolfcode.rbac.query.EmployeeQueryObject;
import cn.wolfcode.rbac.query.PageResult;
import cn.wolfcode.rbac.service.IDepartmentService;
import cn.wolfcode.rbac.service.IEmployeeService;
import cn.wolfcode.rbac.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private IEmployeeService employeeService;
    @Autowired
    private IDepartmentService departmentService;
    @Autowired
    private IRoleService roleService;

    //查询操作
    @RequestMapping("/list")
    public String selectAll(Model model,@ModelAttribute("qo") EmployeeQueryObject qo) {
        PageResult all = employeeService.query(qo);
        model.addAttribute("pageResult",all);
        List<Department> departments = departmentService.getAll();
        model.addAttribute("departments",departments);
        return "employee/list";
    }

    //删除操作
    @RequestMapping("delete")
    public String delete(Long id) {
        employeeService.delete(id);
        return "redirect:/employee/list";
    }

    //跳转到input页面的操作
    @RequestMapping("/input")
    public String input(Long id,Model model) {
        if (id != null) {
            Employee one = employeeService.getOne(id);
            model.addAttribute("employee",one);
        }
        List<Department> all = departmentService.getAll();
        model.addAttribute("departments",all);
        List<Role> roles = roleService.getAll();
        model.addAttribute("roles",roles);
        return "employee/input";
    }

    @RequestMapping("/saveOrUpdate")
    public String saveOrUpdate(Employee employee,Long[] roleIds) {
        employeeService.insertOrUpdate(employee);
        employeeService.saveEmpAndRoleRelation(employee.getId(),roleIds);
        return "redirect:/employee/list";
    }
}
