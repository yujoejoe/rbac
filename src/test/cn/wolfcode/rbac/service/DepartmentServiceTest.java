package cn.wolfcode.rbac.service;

import cn.wolfcode.rbac.domain.Department;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class DepartmentServiceTest {

    @Autowired
    private IDepartmentService departmentService;

    @Test
    public void insertOrUpdate() {
        Department department = new Department(null,"哈哈部","haha Department");
        departmentService.insertOrUpdate(department);
        Department department02 = new Department(7L,"喜喜部","xixi Department");
        departmentService.insertOrUpdate(department02);
    }

    @Test
    public void delete() {
        //Long类型，所以在数字后加个L
        departmentService.delete(7L);
    }

    @Test
    public void getOne() {
        Department one = departmentService.getOne(5L);
        System.out.println(one);
    }

    @Test
    public void getAll() {
        List<Department> all = departmentService.getAll();
        System.out.println(all);
    }

}