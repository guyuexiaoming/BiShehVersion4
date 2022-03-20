package com.zut.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zut.entity.Manager;
import com.zut.entity.Orders;
import com.zut.entity.R;
import com.zut.service.ManagerService;
import com.zut.service.RService;
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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Formatter;
import java.util.List;

/**
 * (R)表控制层
 *
 * @author 古月小白
 * @since 2022-03-06 21:17:20
 */
@Controller
@RequestMapping("repair")
public class RController {
    /**
     * 服务对象
     */
    @Resource
    private RService rService;

    @Resource
    private ManagerService managerService;

    /**
     * 查询所有数据
     */
    @RequestMapping("toListRepair")
    public String toListP(@RequestParam(value="pn",defaultValue="1")Integer pn, HttpSession httpSession, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Model model){

        System.out.println("pn:--------"+pn);
        PageHelper.startPage(pn,5);
        List<R> rList = rService.queryAll();
        System.out.println(rList.toArray());
        for (R r:rList) {
            System.out.println(r.toString());
            String m = r.getRName();
            System.out.println(m);
        }
        PageInfo page = new PageInfo(rList, 5);
        System.out.println(page.toString()+"5555555555");
        model.addAttribute("pages", page);
        httpSession.setAttribute("pages", page);
        model.addAttribute("rs",rList);
        httpSession.setAttribute("rs", rList);
        String username = httpServletRequest.getParameter("username");
        Manager manager = managerService.queryById(username);
        model.addAttribute(manager);
        model.addAttribute(rList);

        return "repair";
    }

    /**
     * 分页查询
     *
     * @param r 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<R>> queryByPage(R r, PageRequest pageRequest) {
        return ResponseEntity.ok(this.rService.queryByPage(r, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<R> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.rService.queryById(id));
    }

    /**
     * 添加数据
     *
     * @param
     * @return 添加结果
     */
    @PutMapping
    @RequestMapping("toAddRepair")
    public String addRepair(@RequestParam(value="pn",defaultValue="1")Integer pn,HttpSession httpSession, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Model model)  {
        //获取前端传回来的数据，并将其封装进行添加操作

        String pId = httpServletRequest.getParameter("pId");
        String cwId = httpServletRequest.getParameter("cwId");
        String rTime = httpServletRequest.getParameter("rTime");
        String rName = httpServletRequest.getParameter("rName");
        String rMoney = httpServletRequest.getParameter("rMoney");
        String rOpinion = httpServletRequest.getParameter("rOpinion");
        //封装实体类
        R r = new R();

        r.setPId(Integer.parseInt(pId));
        r.setCwId(Integer.parseInt(cwId));
        SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd");
        Date date = null;
        try {
            date = formatter.parse(rTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        r.setRTime(date);
        r.setRName(rName);
        r.setRMoney(Integer.parseInt(rMoney));
        r.setROpinion(rOpinion);

        System.out.println(r.getRName());
        R rReturn = rService.insert(r);

        System.out.println(rReturn.getRName());





        System.out.println("pn:--------"+pn);
        PageHelper.startPage(pn,5);
        List<R> rList = rService.queryAll();
        System.out.println(rList.toArray());
        for (R r1:rList) {
            System.out.println(r1.toString());
            String m = r1.getRName();
            System.out.println(m);
        }
        PageInfo page = new PageInfo(rList, 5);
        System.out.println(page.toString()+"5555555555");
        model.addAttribute("pages", page);
        httpSession.setAttribute("pages", page);
        model.addAttribute("rs",rList);
        httpSession.setAttribute("rs", rList);
        String username = httpServletRequest.getParameter("user_name");
        Manager manager = managerService.queryById(username);
        model.addAttribute(manager);
        model.addAttribute(rList);

        return "repair";
    }

    /**
     *
     * 中转跳转添加
     */
    @RequestMapping("toAddRepair.action")
    public String toAddRepair(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Model model, HttpSession session1){
        String orderId = httpServletRequest.getParameter("id");
        String username = httpServletRequest.getParameter("username");
        Manager manager = managerService.queryById(username);

        model.addAttribute("manager",manager);
        model.addAttribute("id",orderId);
        return "addRepair";
    }

    /**
     * 审批操作
     *
     * @param
     * @return 审批结果
     */
    @PutMapping
    @RequestMapping("toDealRepair")
    public String dealRepair(@RequestParam(value="pn",defaultValue="1")Integer pn,HttpSession httpSession, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Model model)  {
        //获取前端传回来的数据，并将其封装进行更新操作
        String repairId = httpServletRequest.getParameter("id");
        System.out.println(repairId);
        //获取老数据
        R rs = rService.queryById(Integer.parseInt(repairId));


        String rName = httpServletRequest.getParameter("rName");

        String rOpinion = httpServletRequest.getParameter("rOpinion");
        //封装实体类
        R r = new R();
        r.setRId(Integer.parseInt(repairId));
        r.setPId(rs.getPId());
        r.setCwId(rs.getCwId());

        r.setRTime(rs.getRTime());
        r.setRName(rs.getRName()+"审批意见："+rName+"。");
        r.setRMoney(rs.getRMoney());
        r.setROpinion(rOpinion);

        System.out.println(r.getRName());
        R rReturn = rService.update(r);

        System.out.println(rReturn.getRName());





        System.out.println("pn:--------"+pn);
        PageHelper.startPage(pn,5);
        List<R> rList = rService.queryAll();
        System.out.println(rList.toArray());
        for (R r1:rList) {
            System.out.println(r1.toString());
            String m = r1.getRName();
            System.out.println(m);
        }
        PageInfo page = new PageInfo(rList, 5);
        System.out.println(page.toString()+"5555555555");
        model.addAttribute("pages", page);
        httpSession.setAttribute("pages", page);
        model.addAttribute("rs",rList);
        httpSession.setAttribute("rs", rList);
        String username = httpServletRequest.getParameter("user_name");
        Manager manager = managerService.queryById(username);
        model.addAttribute(manager);
        model.addAttribute(rList);

        return "repair";
    }

    /**
     *
     * 中转跳转审批
     */
    @RequestMapping("toDealRepair.action")
    public String toDealRepair(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Model model, HttpSession session1){
        String orderId = httpServletRequest.getParameter("id");
        String username = httpServletRequest.getParameter("username");
        Manager manager = managerService.queryById(username);

        model.addAttribute("manager",manager);
        model.addAttribute("id",orderId);
        return "dealRepair";
    }

    /**
     * 编辑数据
     *
     * @param
     * @return 编辑结果
     */
    @PutMapping
    @RequestMapping("toUpdateRepair")
    public String edit(@RequestParam(value="pn",defaultValue="1")Integer pn,HttpSession httpSession, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Model model)  {
        //获取前端传回来的数据，并将其封装进行更新操作
        String repairId = httpServletRequest.getParameter("id");
        System.out.println(repairId);
        String pId = httpServletRequest.getParameter("pId");
        String cwId = httpServletRequest.getParameter("cwId");
        String rTime = httpServletRequest.getParameter("rTime");
        String rName = httpServletRequest.getParameter("rName");
        String rMoney = httpServletRequest.getParameter("rMoney");
        String rOpinion = httpServletRequest.getParameter("rOpinion");
        //封装实体类
        R r = new R();
        r.setRId(Integer.parseInt(repairId));
        r.setPId(Integer.parseInt(pId));
        r.setCwId(Integer.parseInt(cwId));
        SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd");
        Date date = null;
        try {
            date = formatter.parse(rTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        r.setRTime(date);
        r.setRName(rName);
        r.setRMoney(Integer.parseInt(rMoney));
        r.setROpinion(rOpinion);

        System.out.println(r.getRName());
        R rReturn = rService.update(r);

        System.out.println(rReturn.getRName());





        System.out.println("pn:--------"+pn);
        PageHelper.startPage(pn,5);
        List<R> rList = rService.queryAll();
        System.out.println(rList.toArray());
        for (R r1:rList) {
            System.out.println(r1.toString());
            String m = r1.getRName();
            System.out.println(m);
        }
        PageInfo page = new PageInfo(rList, 5);
        System.out.println(page.toString()+"5555555555");
        model.addAttribute("pages", page);
        httpSession.setAttribute("pages", page);
        model.addAttribute("rs",rList);
        httpSession.setAttribute("rs", rList);
        String username = httpServletRequest.getParameter("user_name");
        Manager manager = managerService.queryById(username);
        model.addAttribute(manager);
        model.addAttribute(rList);

        return "repair";
    }

    /**
     *
     * 中转跳转编辑
     */
    @RequestMapping("toUpdateRepair.action")
    public String toUpdateRepair(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Model model, HttpSession session1){
        String orderId = httpServletRequest.getParameter("id");
        String username = httpServletRequest.getParameter("username");
        Manager manager = managerService.queryById(username);

        model.addAttribute("manager",manager);
        model.addAttribute("id",orderId);
        return "updateRepair";
    }

    /**
     * 删除数据
     *
     *
     * @return 删除是否成功
     */
    @DeleteMapping
    @RequestMapping("toDeleteRepair.action")
    public String  deleteById(@RequestParam(value="pn",defaultValue="1")Integer pn,HttpSession httpSession, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Model model) {


        String repairId = httpServletRequest.getParameter("id");
        System.out.println(repairId);
        String username = httpServletRequest.getParameter("username");
        System.out.println(username);

        boolean s = rService.deleteById(Integer.valueOf(repairId));
        System.out.println(s);



        System.out.println("pn:--------"+pn);
        PageHelper.startPage(pn,5);
        List<R> rList = rService.queryAll();
        System.out.println(rList.toArray());
        for (R r:rList) {
            System.out.println(r.toString());
            String m = r.getRName();
            System.out.println(m);
        }
        PageInfo page = new PageInfo(rList, 5);
        System.out.println(page.toString()+"5555555555");
        model.addAttribute("pages", page);
        httpSession.setAttribute("pages", page);
        model.addAttribute("rs",rList);
        httpSession.setAttribute("rs", rList);

        Manager manager = managerService.queryById(username);
        model.addAttribute(manager);
        model.addAttribute(rList);

        return "repair";
    }
}

