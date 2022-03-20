package com.zut.service;

import com.zut.entity.Orders;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Map;

/**
 * (Orders)表服务接口
 *
 * @author 古月小白
 * @since 2022-03-11 17:40:59
 */
public interface OrdersService {

    /**
     * 通过ID查询单条数据
     *
     * @param ordersId 主键
     * @return 实例对象
     */
    Orders queryById(Integer ordersId);

    /**
     * 通过时间段查询金额总数
     *
     * @return 金额数
     */
    Integer querySumMoney(String BTime, String ETime);

    /**
     * 查询表内所有数据
     *
     * @return 实例对象表
     */
    List<Orders> queryAll();

    /**
     * 分页查询
     *
     * @param orders 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Orders> queryByPage(Orders orders, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param orders 实例对象
     * @return 实例对象
     */
    Orders insert(Orders orders);

    /**
     * 修改数据
     *
     * @param orders 实例对象
     * @return 实例对象
     */
    Orders update(Orders orders);

    /**
     * 通过主键删除数据
     *
     * @param ordersId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer ordersId);

}
