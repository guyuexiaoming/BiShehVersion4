package com.zut.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zut.entity.Manager;
import com.zut.entity.P;
import com.zut.entity.User;
import com.zut.service.ManagerService;
import com.zut.service.PService;
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
 * (P)表控制层
 *
 * @author 古月小白
 * @since 2022-03-06 21:17:20
 */
@Controller
@RequestMapping("p")
public class PController {
    /**
     * 服务对象
     */
    @Resource
    private PService pService;

    @Resource
    private ManagerService managerService;

    /**
     * 查询所有数据
     */
    @RequestMapping("toListP")
    public String toListP(@RequestParam(value="pn",defaultValue="1")Integer pn, HttpSession httpSession, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Model model){

        System.out.println("pn:--------"+pn);
        PageHelper.startPage(pn,5);
        List<P> pList = pService.queryAll();
        System.out.println(pList.toArray());
        for (P p:pList) {
            System.out.println(p.toString());
            String m = p.getPName();
            System.out.println(m);
        }
        PageInfo page = new PageInfo(pList, 5);
        System.out.println(page.toString()+"5555555555");
        model.addAttribute("pages", page);
        httpSession.setAttribute("pages", page);
        model.addAttribute("ps",pList);
        httpSession.setAttribute("ps", pList);
        String username = httpServletRequest.getParameter("username");
        Manager manager = managerService.queryById(username);
        model.addAttribute(manager);
        model.addAttribute(pList);

        return "parkingAttendant";
    }

    /**
     * 分页查询
     *
     * @param p 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<P>> queryByPage(P p, PageRequest pageRequest) {
        return ResponseEntity.ok(this.pService.queryByPage(p, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<P> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.pService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param p 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<P> add(P p) {
        return ResponseEntity.ok(this.pService.insert(p));
    }

    /**
     * 新增数据
     *
     * @param
     * @return 新增结果
     */

    @RequestMapping("addParkingAttendant")
    public String addUser(@RequestParam(value="pn",defaultValue="1")Integer pn,HttpSession httpSession, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Model model) {

        //获取前端传回来的数据，并将其封装进行更新操作

        String username = httpServletRequest.getParameter("username");
        String password = httpServletRequest.getParameter("password");

        String phone = httpServletRequest.getParameter("phone");

        //封装实体类
        P p = new P();
        p.setPName(username);
        p.setPPassword(password);
        p.setPPhone(phone);

        P pReturn = pService.insert(p);

        System.out.println(pReturn.getPName());





        System.out.println("pn:--------"+pn);
        PageHelper.startPage(pn,5);
        List<P> pList = pService.queryAll();
        System.out.println(pList.toArray());
        for (P p1:pList) {
            System.out.println(p1.toString());
            String m = p1.getPName();
            System.out.println(m);
        }
        PageInfo page = new PageInfo(pList, 5);
        System.out.println(page.toString()+"5555555555");
        model.addAttribute("pages", page);
        httpSession.setAttribute("pages", page);
        model.addAttribute("ps",pList);
        httpSession.setAttribute("ps", pList);
        String user_name = httpServletRequest.getParameter("user_name");
        Manager manager = managerService.queryById(user_name);
        model.addAttribute(manager);
        model.addAttribute(pList);

        return "parkingAttendant";


    }
    /**
     * 中转添加用户
     */
    @RequestMapping("toAddP.action")
    public String toAddUser(@RequestParam(value="pn",defaultValue="1")Integer pn,HttpSession httpSession, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Model model){

        String username = httpServletRequest.getParameter("username");
        Manager manager = managerService.queryById(username);

        model.addAttribute("manager",manager);

        return "addPakingAttendant";
    }

    /**
     * 编辑数据
     *
     * @param p 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<P> edit(P p) {
        return ResponseEntity.ok(this.pService.update(p));
    }

    /**
     * 编辑数据
     *
     * @param
     * @return 编辑结果
     */
    @PutMapping
    @RequestMapping("toUpdateP")
    public String edit(@RequestParam(value="pn",defaultValue="1")Integer pn,HttpSession httpSession, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Model model) {
        //获取前端传回来的数据，并将其封装进行更新操作

        String id = httpServletRequest.getParameter("id");
        String username = httpServletRequest.getParameter("username");
        String password = httpServletRequest.getParameter("password");

        String phone = httpServletRequest.getParameter("phone");

        //封装实体类
        P p = new P();
        p.setPId(Integer.parseInt(id));
        System.out.println(p.getPId());
        p.setPName(username);
        p.setPPassword(password);
        p.setPPhone(phone);

        P pReturn = pService.update(p);

        System.out.println(pReturn.getPName());





        System.out.println("pn:--------"+pn);
        PageHelper.startPage(pn,5);
        List<P> pList = pService.queryAll();
        System.out.println(pList.toArray());
        for (P p1:pList) {
            System.out.println(p1.toString());
            String m = p1.getPName();
            System.out.println(m);
        }
        PageInfo page = new PageInfo(pList, 5);
        System.out.println(page.toString()+"5555555555");
        model.addAttribute("pages", page);
        httpSession.setAttribute("pages", page);
        model.addAttribute("ps",pList);
        httpSession.setAttribute("ps", pList);
        String user_name = httpServletRequest.getParameter("user_name");
        Manager manager = managerService.queryById(user_name);
        model.addAttribute(manager);
        model.addAttribute(pList);

        return "parkingAttendant";
    }
    /**
     *
     * 中转跳转编辑
     */
    @RequestMapping("toUpdateP.action")
    public String toUpdateUser(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Model model, HttpSession session1){
        String userid = httpServletRequest.getParameter("id");
        String username = httpServletRequest.getParameter("username");
        Manager manager = managerService.queryById(username);

        model.addAttribute("manager",manager);
        model.addAttribute("id",userid);
        return "updateParkingAttendant";
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.pService.deleteById(id));
    }

    /**
     * 删除数据
     *
     *
     * @return 删除是否成功
     */
    @DeleteMapping
    @RequestMapping("toDeleteP")
    public String  deleteById(@RequestParam(value="pn",defaultValue="1")Integer pn,HttpSession httpSession, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Model model) {


        String userid = httpServletRequest.getParameter("id");
        System.out.println(userid);
        String username = httpServletRequest.getParameter("username");
        System.out.println(username);

        boolean s = pService.deleteById(Integer.parseInt(userid));
        System.out.println(s);



        System.out.println("pn:--------"+pn);
        PageHelper.startPage(pn,5);
        List<P> pList = pService.queryAll();
        System.out.println(pList.toArray());
        for (P p:pList) {
            System.out.println(p.toString());
            String m = p.getPName();
            System.out.println(m);
        }
        PageInfo page = new PageInfo(pList, 5);
        System.out.println(page.toString()+"5555555555");
        model.addAttribute("pages", page);
        httpSession.setAttribute("pages", page);
        model.addAttribute("ps",pList);
        httpSession.setAttribute("ps", pList);

        Manager manager = managerService.queryById(username);
        model.addAttribute(manager);
        model.addAttribute(pList);

        return "parkingAttendant";
    }

}

