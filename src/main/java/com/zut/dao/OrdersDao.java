package com.zut.dao;

import com.zut.entity.Orders;
import com.zut.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Map;

/**
 * (Orders)表数据库访问层
 *
 * @author 古月小白
 * @since 2022-03-11 17:40:59
 */
public interface OrdersDao {

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
    Integer querySumMoney(@Param("bTime") String bTime, @Param("eTime") String eTime);

    /**
     * 查询表内所有数据
     *
     * @return 实例对象表
     */
    List<Orders> queryAll();

    /**
     * 查询指定行数据
     *
     * @param orders 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<Orders> queryAllByLimit(Orders orders, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param orders 查询条件
     * @return 总行数
     */
    long count(Orders orders);

    /**
     * 新增数据
     *
     * @param orders 实例对象
     * @return 影响行数
     */
    int insert(Orders orders);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Orders> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Orders> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Orders> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Orders> entities);

    /**
     * 修改数据
     *
     * @param orders 实例对象
     * @return 影响行数
     */
    int update(Orders orders);

    /**
     * 通过主键删除数据
     *
     * @param ordersId 主键
     * @return 影响行数
     */
    int deleteById(Integer ordersId);

}

