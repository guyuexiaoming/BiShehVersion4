package com.zut.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zut.entity.Announ;
import com.zut.entity.Manager;
import com.zut.entity.P;
import com.zut.entity.User;
import com.zut.service.AnnounService;
import com.zut.service.ManagerService;
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
 * (Announ)表控制层
 *
 * @author 古月小白
 * @since 2022-03-06 21:17:16
 */
@Controller
@RequestMapping("announ")
public class AnnounController {
    /**
     * 服务对象
     */
    @Resource
    private AnnounService announService;

    @Resource
    private ManagerService managerService;

    /**
     * 查询所有数据
     */
    @RequestMapping("toListAnnoun")
    public String toListP(@RequestParam(value="pn",defaultValue="1")Integer pn, HttpSession httpSession, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Model model){

        System.out.println("pn:--------"+pn);
        PageHelper.startPage(pn,5);
        List<Announ> announList = announService.queryAll();
        System.out.println(announList.toArray());
        for (Announ announ:announList) {
            System.out.println(announ.toString());
            String m = announ.getAnTitle();
            System.out.println(m);
        }
        PageInfo page = new PageInfo(announList, 5);
        System.out.println(page.toString()+"5555555555");
        model.addAttribute("pages", page);
        httpSession.setAttribute("pages", page);
        model.addAttribute("announList",announList);
        httpSession.setAttribute("announList", announList);
        String username = httpServletRequest.getParameter("username");
        Manager manager = managerService.queryById(username);
        model.addAttribute(manager);
        model.addAttribute(announList);

        return "announcement";
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Announ> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.announService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param
     * @return 新增结果
     */

    @RequestMapping("addAnnouncement")
    public String addUser(@RequestParam(value="pn",defaultValue="1")Integer pn,HttpSession httpSession, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Model model) {

        //获取前端传回来的数据，并将其封装进行更新操作

        String title = httpServletRequest.getParameter("title");
        String content = httpServletRequest.getParameter("content");

        //封装实体类
        Announ announ = new Announ();
        announ.setAnTitle(title);
        announ.setAnBody(content);

        Announ announcementReturn = announService.insert(announ);

        System.out.println(announcementReturn.getAnTitle());





        System.out.println("pn:--------"+pn);
        PageHelper.startPage(pn,5);
        List<Announ> announList = announService.queryAll();
        System.out.println(announList.toArray());
        for (Announ announ1:announList) {
            System.out.println(announ1.toString());
            String m = announ1.getAnTitle();
            System.out.println(m);
        }
        PageInfo page = new PageInfo(announList, 5);
        System.out.println(page.toString()+"5555555555");
        model.addAttribute("pages", page);
        httpSession.setAttribute("pages", page);
        model.addAttribute("announList",announList);
        httpSession.setAttribute("announList", announList);
        String username = httpServletRequest.getParameter("user_name");
        Manager manager = managerService.queryById(username);
        model.addAttribute(manager);
        model.addAttribute(announList);
        return "announcement";


    }

    /**
     * 中转添加用户
     */
    @RequestMapping("toAddAnnouncement.action")
    public String toAddUser(@RequestParam(value="pn",defaultValue="1")Integer pn,HttpSession httpSession, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Model model){

        String username = httpServletRequest.getParameter("username");
        Manager manager = managerService.queryById(username);

        model.addAttribute("manager",manager);

        return "addAnnouncement";
    }

    /**
     * 编辑数据
     *
     * @param
     * @return 编辑结果
     */
    @PutMapping
    @RequestMapping("toUpdateAnnouncement")
    public String edit(@RequestParam(value="pn",defaultValue="1")Integer pn,HttpSession httpSession, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Model model) {
        //获取前端传回来的数据，并将其封装进行更新操作

        String announcementId = httpServletRequest.getParameter("id");
        String title = httpServletRequest.getParameter("title");
        String content = httpServletRequest.getParameter("content");

        //封装实体类
        Announ announ = new Announ();
        announ.setAnId(Integer.parseInt(announcementId));
        announ.setAnTitle(title);
        announ.setAnBody(content);

        Announ announcementReturn = announService.update(announ);

        System.out.println(announcementReturn.getAnTitle());





        System.out.println("pn:--------"+pn);
        PageHelper.startPage(pn,5);
        List<Announ> announList = announService.queryAll();
        System.out.println(announList.toArray());
        for (Announ announ1:announList) {
            System.out.println(announ1.toString());
            String m = announ1.getAnTitle();
            System.out.println(m);
        }
        PageInfo page = new PageInfo(announList, 5);
        System.out.println(page.toString()+"5555555555");
        model.addAttribute("pages", page);
        httpSession.setAttribute("pages", page);
        model.addAttribute("announList",announList);
        httpSession.setAttribute("announList", announList);
        String username = httpServletRequest.getParameter("user_name");
        Manager manager = managerService.queryById(username);
        model.addAttribute(manager);
        model.addAttribute(announList);
        return "announcement";
    }
    /**
     *
     * 中转跳转编辑
     */
    @RequestMapping("toUpdateAnnouncement.action")
    public String toUpdateUser(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Model model, HttpSession session1){
        String announcementId = httpServletRequest.getParameter("id");
        String username = httpServletRequest.getParameter("username");
        Manager manager = managerService.queryById(username);

        model.addAttribute("manager",manager);
        model.addAttribute("id",announcementId);
        return "updateAnnouncement";
    }

    /**
     * 删除数据
     *
     *
     * @return 删除是否成功
     */
    @DeleteMapping
    @RequestMapping("toDeleteAnnoun")
    public String  deleteById(@RequestParam(value="pn",defaultValue="1")Integer pn,HttpSession httpSession, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Model model) {


        String announId = httpServletRequest.getParameter("id");
        System.out.println(announId);
        String username = httpServletRequest.getParameter("username");
        System.out.println(username);

        boolean s = announService.deleteById(Integer.parseInt(announId));
        System.out.println(s);



        System.out.println("pn:--------"+pn);
        PageHelper.startPage(pn,5);
        List<Announ> announList = announService.queryAll();
        System.out.println(announList.toArray());
        for (Announ announ:announList) {
            System.out.println(announ.toString());
            String m = announ.getAnTitle();
            System.out.println(m);
        }
        PageInfo page = new PageInfo(announList, 5);
        System.out.println(page.toString()+"5555555555");
        model.addAttribute("pages", page);
        httpSession.setAttribute("pages", page);
        model.addAttribute("announList",announList);
        httpSession.setAttribute("announList", announList);
        Manager manager = managerService.queryById(username);
        model.addAttribute(manager);
        model.addAttribute(announList);

        return "announcement";
    }

}

