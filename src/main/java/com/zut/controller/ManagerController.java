package com.zut.controller;

import com.zut.entity.Manager;
import com.zut.service.ManagerService;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import java.io.IOException;

/**
 * (Manager)表控制层
 *
 * @author 古月小白
 * @since 2022-03-06 21:17:20
 */
@Controller
@RequestMapping("man")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class ManagerController {
    /**
     * 服务对象
     */
    @Resource
    private ManagerService managerService ;

    /**
     * 分页查询
     *
     * @param manager 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Manager>> queryByPage(Manager manager, PageRequest pageRequest) {
        return ResponseEntity.ok(this.managerService.queryByPage(manager, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Manager> queryById(@PathVariable("id") String id) {
        return ResponseEntity.ok(this.managerService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param manager 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Manager> add(Manager manager) {
        return ResponseEntity.ok(this.managerService.insert(manager));
    }

    /**
     * 编辑数据
     *
     * @param manager 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Manager> edit(Manager manager) {
        return ResponseEntity.ok(this.managerService.update(manager));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(String id) {
        return ResponseEntity.ok(this.managerService.deleteById(id));
    }

    /**
     * 管理员身份登录核验
     * @param httpServletRequest
     * @param httpServletResponse
     * @return
     */
    @RequestMapping("loginManager.action")
    public String loginManager(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Model model, HttpSession session1) throws IOException {

        System.out.println("**进入后台controller***");
        System.out.println("-----------");
        String username = httpServletRequest.getParameter("username");
        String password = httpServletRequest.getParameter("password");
        System.out.println(username);
        Manager manager =new Manager();
        manager.setUsername(username);
        manager.setPassword(password);
        System.out.println(username+"**U----P**"+password);
        Boolean r = managerService.loginByManager(manager);

        System.out.println("*********"+r);
        model.addAttribute("Manager",manager);
        if (r) {

            model.addAttribute("manager",manager);

            return "index";
        }
        System.out.println("****失败*****");

        return "login";
    }

    /**
     *
     * 中转调回index
     */
    @RequestMapping("toIndex.action")
    public String toIndex(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Model model, HttpSession session1){
        String username = httpServletRequest.getParameter("username");
        Manager manager = managerService.queryById(username);

        model.addAttribute("manager",manager);

        return "index";
    }
    @Test
    public void mm(){
        Manager manager = new Manager();
        manager = managerService.queryById("胡明奇");
        System.out.println("********");
        System.out.println(manager.getPassword());
    }

}

