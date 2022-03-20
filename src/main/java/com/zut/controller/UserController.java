package com.zut.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zut.entity.Manager;
import com.zut.entity.User;
import com.zut.service.ManagerService;
import com.zut.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * (User)表控制层
 *
 * @author 古月小白
 * @since 2022-03-06 21:17:20
 */
@Controller
@RequestMapping("user")
public class UserController {
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;

    @Resource
    private ManagerService managerService;


    /**
     * 查询所有对象
     */

    @RequestMapping("toListUser")
    public String toListUser(@RequestParam(value="pn",defaultValue="1")Integer pn, HttpSession httpSession, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Model model){

        System.out.println("pn:--------"+pn);
        PageHelper.startPage(pn,5);
        List<User> userList = userService.queryAll();
        System.out.println(userList.toArray());
        for (User user:userList) {
            System.out.println(user.toString());
            String m = user.getUserName();
            System.out.println(m);
        }
        PageInfo page = new PageInfo(userList, 5);
        System.out.println(page.toString()+"5555555555");
        model.addAttribute("users1", page);
        httpSession.setAttribute("users1", page);
        model.addAttribute("users",userList);
        httpSession.setAttribute("users", userList);
        String username = httpServletRequest.getParameter("username");
        Manager manager = managerService.queryById(username);
        model.addAttribute(manager);
        model.addAttribute(userList);
        return "users";
    }



    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<User> queryById(@PathVariable("id") double id) {
        return ResponseEntity.ok(this.userService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param
     * @return 新增结果
     */

    @RequestMapping("addUser")
    public String addUser(@RequestParam(value="pn",defaultValue="1")Integer pn,HttpSession httpSession, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Model model) {

        //获取前端传回来的数据，并将其封装进行插入操作

        String username = httpServletRequest.getParameter("username");
        String password = httpServletRequest.getParameter("password");
        String name = httpServletRequest.getParameter("name");
        String phone = httpServletRequest.getParameter("phone");
        String carnumber = httpServletRequest.getParameter("carnumber");
        //封装实体类
        User userNew = new User();
        userNew.setUserName(username);
        userNew.setUserPassword(password);
        userNew.setName(name);
        userNew.setPhone(phone);
        userNew.setCarnumber(carnumber);

        boolean userReturn = userService.insertUser(userNew);

        System.out.println(userReturn);





        System.out.println("pn:--------"+pn);
        PageHelper.startPage(pn,5);
        List<User> userList = userService.queryAll();
        System.out.println(userList.toArray());
        for (User user:userList) {
            System.out.println(user.toString());
            String m = user.getUserName();
            System.out.println(m);
        }
        PageInfo page = new PageInfo(userList, 5);
        System.out.println(page.toString()+"5555555555");
        model.addAttribute("users1", page);
        httpSession.setAttribute("users1", page);
        model.addAttribute("users",userList);
        httpSession.setAttribute("users", userList);
        String user_name = httpServletRequest.getParameter("user_name");
        Manager manager = managerService.queryById(user_name);
        model.addAttribute(manager);
        model.addAttribute(userList);
        return "users";


    }
    /**
     * 中转添加用户
     */
    @RequestMapping("toAddUser.action")
    public String toAddUser(@RequestParam(value="pn",defaultValue="1")Integer pn,HttpSession httpSession, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Model model){

        String username = httpServletRequest.getParameter("username");
        Manager manager = managerService.queryById(username);

        model.addAttribute("manager",manager);

        return "addUser";
    }

    /**
     * 编辑数据
     *
     * @param
     * @return 编辑结果
     */
    @PutMapping
    @RequestMapping("toUpdateUser")
    public String edit(@RequestParam(value="pn",defaultValue="1")Integer pn,HttpSession httpSession, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Model model) {
        //获取前端传回来的数据，并将其封装进行更新操作
        String userid = httpServletRequest.getParameter("id");
        System.out.println(userid);
        String username = httpServletRequest.getParameter("username");
        String password = httpServletRequest.getParameter("password");
        String name = httpServletRequest.getParameter("name");
        String phone = httpServletRequest.getParameter("phone");
        String carnumber = httpServletRequest.getParameter("carnumber");
        //封装实体类
        User userNew = new User();
        userNew.setUserId(Double.valueOf(userid));
        userNew.setUserName(username);
        userNew.setUserPassword(password);
        userNew.setName(name);
        userNew.setPhone(phone);
        userNew.setCarnumber(carnumber);

        User userReturn = userService.update(userNew);

        System.out.println(userReturn.getUserName());





        System.out.println("pn:--------"+pn);
        PageHelper.startPage(pn,5);
        List<User> userList = userService.queryAll();
        System.out.println(userList.toArray());
        for (User user:userList) {
            System.out.println(user.toString());
            String m = user.getUserName();
            System.out.println(m);
        }
        PageInfo page = new PageInfo(userList, 5);
        System.out.println(page.toString()+"5555555555");
        model.addAttribute("users1", page);
        httpSession.setAttribute("users1", page);
        model.addAttribute("users",userList);
        httpSession.setAttribute("users", userList);
        String user_name = httpServletRequest.getParameter("user_name");
        Manager manager = managerService.queryById(user_name);
        model.addAttribute(manager);
        model.addAttribute(userList);
        return "users";
    }
    /**
     *
     * 中转跳转编辑
     */
    @RequestMapping("toUpdateUser.action")
    public String toUpdateUser(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Model model, HttpSession session1){
        String userid = httpServletRequest.getParameter("id");
        String username = httpServletRequest.getParameter("username");
        Manager manager = managerService.queryById(username);

        model.addAttribute("manager",manager);
        model.addAttribute("id",userid);
        return "updateUser";
    }

    /**
     * 删除数据
     *
     *
     * @return 删除是否成功
     */
    @DeleteMapping
    @RequestMapping("todeteleUser")
    public String  deleteById(@RequestParam(value="pn",defaultValue="1")Integer pn,HttpSession httpSession, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Model model) {


        String userid = httpServletRequest.getParameter("id");
        System.out.println(userid);
        String username = httpServletRequest.getParameter("username");
        System.out.println(username);

        boolean s = userService.deleteById(Double.valueOf(userid));
        System.out.println(s);



        System.out.println("pn:--------"+pn);
        PageHelper.startPage(pn,5);
        List<User> userList = userService.queryAll();
        System.out.println(userList.toArray());
        for (User user:userList) {
            System.out.println(user.toString());
            String m = user.getUserName();
            System.out.println(m);
        }
        PageInfo page = new PageInfo(userList, 5);
        System.out.println(page.toString()+"5555555555");
        model.addAttribute("users1", page);
        httpSession.setAttribute("users1", page);
        model.addAttribute("users",userList);
        httpSession.setAttribute("users", userList);
        Manager manager = managerService.queryById(username);
        model.addAttribute(manager);
        model.addAttribute(userList);
        return "users";
    }

}

