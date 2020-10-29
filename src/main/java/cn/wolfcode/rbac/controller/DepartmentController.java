package cn.wolfcode.rbac.controller;

import cn.wolfcode.rbac.domain.Department;
import cn.wolfcode.rbac.query.PageResult;
import cn.wolfcode.rbac.query.QueryObject;
import cn.wolfcode.rbac.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/department")   //前台的action或href内容-01
public class DepartmentController {

    @Autowired
    private IDepartmentService departmentService;
    //调用方法 一般调用方法的接口对象

    //查询所有部门
    @RequestMapping("/list")   //衔接前台的action或href内容-02
    public String selectAll(Model model, QueryObject qo) {                   //Model模型载具
        PageResult all = departmentService.query(qo) ;   //带有分页效果的结果集
//        List<Department> all = departmentService.getAll();
        model.addAttribute("pageResult",all);           //相当于微信小程序的wx.setStorageSync()
        // 请求转发，可携带参数
        // return "forward:/WEB-INF/views/department/list.jsp";    //无基础建议此写法
        // mvc.xml中有视图解析器，故可简写为
        return "department/list";
    }

    //删除操作
    @RequestMapping("/delete")
    public String delete(Long id) {
        departmentService.delete(id);
        //刷新：重定向
        return "redirect:/department/list";
    }

    //跳转到input页面，把数据(可为空)发送到input页面
    @RequestMapping("/input")
    public String input(Long id,Model model) {
        if (id != null) {
            //查询
            Department one = departmentService.getOne(id);
            //封装
            model.addAttribute("d", one);
        }
        //请求转发 （编辑：携带参数；添加：不携带参数）
        return "department/input";
    }

    //在input页面 添加 或 修改
    @RequestMapping("/saveOrUpdate")
    public String insertOrUpdate(Department department){
        departmentService.insertOrUpdate(department);
        //刷新：重定向
        return "redirect:/department/list";
    }

}
