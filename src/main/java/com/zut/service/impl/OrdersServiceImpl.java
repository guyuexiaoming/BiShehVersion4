package com.zut.service.impl;

import com.zut.entity.Manager;
import com.zut.entity.Orders;
import com.zut.dao.OrdersDao;
import com.zut.service.OrdersService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * (Orders)表服务实现类
 *
 * @author 古月小白
 * @since 2022-03-11 17:40:59
 */
@Service("ordersService")
public class OrdersServiceImpl implements OrdersService {
    @Resource
    private OrdersDao ordersDao;

    /**
     * 通过ID查询单条数据
     *
     * @param ordersId 主键
     * @return 实例对象
     */
    @Override
    public Orders queryById(Integer ordersId) {
        return this.ordersDao.queryById(ordersId);
    }

    @Override
    public Integer querySumMoney(String bTime, String eTime) {
        Integer sumMoney = ordersDao.querySumMoney(bTime,eTime);
        System.out.println(sumMoney);
        if (sumMoney==null){
            sumMoney=0;
        }
        return sumMoney;
    }

    @Override
    public List<Orders> queryAll() {
        List<Orders> ordersList = ordersDao.queryAll();
        return ordersList;
    }

    /**
     * 分页查询
     *
     * @param orders 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Orders> queryByPage(Orders orders, PageRequest pageRequest) {
        long total = this.ordersDao.count(orders);
        return new PageImpl<>(this.ordersDao.queryAllByLimit(orders, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param orders 实例对象
     * @return 实例对象
     */
    @Override
    public Orders insert(Orders orders) {
        this.ordersDao.insert(orders);
        return orders;
    }

    /**
     * 修改数据
     *
     * @param orders 实例对象
     * @return 实例对象
     */
    @Override
    public Orders update(Orders orders) {
        this.ordersDao.update(orders);
        return this.queryById(orders.getOrdersId());
    }

    /**
     * 通过主键删除数据
     *
     * @param ordersId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer ordersId) {
        return this.ordersDao.deleteById(ordersId) > 0;
    }
}
