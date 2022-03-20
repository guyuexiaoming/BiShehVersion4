package com.zut.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zut.entity.Manager;
import com.zut.entity.Orders;
import com.zut.entity.User;
import com.zut.service.ManagerService;
import com.zut.service.OrdersService;
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
 * (Order)表控制层
 *
 * @author 古月小白
 * @since 2022-03-06 21:17:20
 */
@Controller
@RequestMapping("order")
public class OrderController {
    /**
     * 服务对象
     */
    @Resource
    private OrdersService orderService;
    @Resource
    private ManagerService managerService;

    /**
     * 查询所有对象
     */

    @RequestMapping("toListOrders")
    public String toListUser(@RequestParam(value="pn",defaultValue="1")Integer pn, HttpSession httpSession, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Model model){

        System.out.println("pn:--------"+pn);
        PageHelper.startPage(pn,5);
        List<Orders> ordersList = orderService.queryAll();
        System.out.println(ordersList.toArray());
        for (Orders orders:ordersList) {
            System.out.println(orders.toString());
            int m = orders.getOrdersId();
            System.out.println(m);
        }
        PageInfo page = new PageInfo(ordersList, 5);
        System.out.println(page.toString()+"5555555555");
        model.addAttribute("orders1", page);
        httpSession.setAttribute("orders1", page);
        model.addAttribute("orders",ordersList);
        httpSession.setAttribute("orders", ordersList);
        String username = httpServletRequest.getParameter("username");
        Manager manager = managerService.queryById(username);
        model.addAttribute(manager);
        model.addAttribute(ordersList);
        return "orders";
    }



    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Orders> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.orderService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param order 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Orders> add(Orders order) {
        return ResponseEntity.ok(this.orderService.insert(order));
    }

    /**
     * 新增数据
     *
     * @param
     * @return 新增结果
     */

    @RequestMapping("addOrder")
    public String addUser(@RequestParam(value="pn",defaultValue="1")Integer pn,HttpSession httpSession, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Model model) {

        //获取前端传回来的数据，并将其封装进行更新操作


        String userId = httpServletRequest.getParameter("userId");
        String carNumber = httpServletRequest.getParameter("carNumber");
        String money = httpServletRequest.getParameter("money");
        String castTime = httpServletRequest.getParameter("castTime");
        String eval = httpServletRequest.getParameter("eval");
        //封装实体类
        Orders orders = new Orders();

        orders.setUserId(Integer.valueOf(userId));
        orders.setCwId(carNumber);
        orders.setOrdersMoney(Integer.valueOf(money));
        orders.setOrdersTime(castTime);
        orders.setOrdersEval(eval);

        System.out.println(orders.getOrdersId());
        Orders orderReturn = orderService.insert(orders);

        System.out.println(orderReturn.getOrdersId());





        System.out.println("pn:--------"+pn);
        PageHelper.startPage(pn,5);
        List<Orders> ordersList = orderService.queryAll();
        System.out.println(ordersList.toArray());
        for (Orders order1s:ordersList) {
            System.out.println(order1s.toString());
            Integer m = order1s.getUserId();
            System.out.println(m);
        }
        PageInfo page = new PageInfo(ordersList, 5);
        System.out.println(page.toString()+"5555555555");
        model.addAttribute("orders1", page);
        httpSession.setAttribute("orders1", page);
        model.addAttribute("orders",ordersList);
        httpSession.setAttribute("orders", ordersList);
        String username = httpServletRequest.getParameter("user_name");
        Manager manager = managerService.queryById(username);
        model.addAttribute(manager);
        model.addAttribute(ordersList);
        return "orders";


    }
    /**
     * 中转添加用户
     */
    @RequestMapping("toAddOrder.action")
    public String toAddUser(@RequestParam(value="pn",defaultValue="1")Integer pn,HttpSession httpSession, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Model model){

        String username = httpServletRequest.getParameter("username");
        Manager manager = managerService.queryById(username);

        model.addAttribute("manager",manager);

        return "addOrders";
    }

    /**
     * 编辑数据
     *
     * @param order 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Orders> edit(Orders order) {
        return ResponseEntity.ok(this.orderService.update(order));
    }

    /**
     * 编辑数据
     *
     * @param
     * @return 编辑结果
     */
    @PutMapping
    @RequestMapping("toUpdateOrders")
    public String edit(@RequestParam(value="pn",defaultValue="1")Integer pn,HttpSession httpSession, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Model model) {
        //获取前端传回来的数据，并将其封装进行更新操作
        String orderId = httpServletRequest.getParameter("id");
        System.out.println(orderId);
        String userId = httpServletRequest.getParameter("userId");
        String carNumber = httpServletRequest.getParameter("carNumber");
        String money = httpServletRequest.getParameter("money");
        String castTime = httpServletRequest.getParameter("castTime");
        String eval = httpServletRequest.getParameter("eval");
        //封装实体类
        Orders orders = new Orders();
        orders.setOrdersId(Integer.parseInt(orderId));
        orders.setUserId(Integer.valueOf(userId));
        orders.setCwId(carNumber);
        orders.setOrdersMoney(Integer.valueOf(money));
        orders.setOrdersTime(castTime);
        orders.setOrdersEval(eval);

        System.out.println(orders.getOrdersId());
        Orders orderReturn = orderService.update(orders);

        System.out.println(orderReturn.getOrdersId());





        System.out.println("pn:--------"+pn);
        PageHelper.startPage(pn,5);
        List<Orders> ordersList = orderService.queryAll();
        System.out.println(ordersList.toArray());
        for (Orders order1s:ordersList) {
            System.out.println(order1s.toString());
            Integer m = order1s.getUserId();
            System.out.println(m);
        }
        PageInfo page = new PageInfo(ordersList, 5);
        System.out.println(page.toString()+"5555555555");
        model.addAttribute("orders1", page);
        httpSession.setAttribute("orders1", page);
        model.addAttribute("orders",ordersList);
        httpSession.setAttribute("orders", ordersList);
        String username = httpServletRequest.getParameter("user_name");
        Manager manager = managerService.queryById(username);
        model.addAttribute(manager);
        model.addAttribute(ordersList);
        return "orders";
    }

    /**
     *
     * 中转跳转编辑
     */
    @RequestMapping("toUpdateOrders.action")
    public String toUpdateUser(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Model model, HttpSession session1){
        String orderId = httpServletRequest.getParameter("id");
        String username = httpServletRequest.getParameter("username");
        Manager manager = managerService.queryById(username);

        model.addAttribute("manager",manager);
        model.addAttribute("id",orderId);
        return "updateOrder";
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.orderService.deleteById(id));
    }
    /**
     * 删除数据
     *
     *
     * @return 删除是否成功
     */
    @DeleteMapping
    @RequestMapping("toDeleteOrders.action")
    public String  deleteById(@RequestParam(value="pn",defaultValue="1")Integer pn,HttpSession httpSession, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Model model) {


        String orderId = httpServletRequest.getParameter("id");
        System.out.println(orderId);
        String username = httpServletRequest.getParameter("username");
        System.out.println(username);

        boolean s = orderService.deleteById(Integer.valueOf(orderId));
        System.out.println(s);



        System.out.println("pn:--------"+pn);
        PageHelper.startPage(pn,5);
        List<Orders> ordersList = orderService.queryAll();
        System.out.println(ordersList.toArray());
        for (Orders orders:ordersList) {
            System.out.println(orders.toString());
            Integer m = orders.getUserId();
            System.out.println(m);
        }
        PageInfo page = new PageInfo(ordersList, 5);
        System.out.println(page.toString()+"5555555555");
        model.addAttribute("orders1", page);
        httpSession.setAttribute("orders1", page);
        model.addAttribute("orders",ordersList);
        httpSession.setAttribute("orders", ordersList);
        Manager manager = managerService.queryById(username);
        model.addAttribute(manager);
        model.addAttribute(ordersList);
        return "orders";
    }

}

