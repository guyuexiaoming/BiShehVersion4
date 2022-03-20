package com.zut.service;

import com.zut.entity.R;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * (R)表服务接口
 *
 * @author 古月小白
 * @since 2022-03-13 08:06:32
 */
public interface RService {

    /**
     * 通过ID查询单条数据
     *
     * @param rId 主键
     * @return 实例对象
     */
    R queryById(Integer rId);

    /**
     * 通过时间段查询金额总数
     *
     * @return 金额数
     */
    Integer querySumMoney(String BTime, String ETime);

    /**
     * 查询所有数据
     *
     * @return 返回List实例表
     */
    List<R> queryAll();

    /**
     * 分页查询
     *
     * @param r 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<R> queryByPage(R r, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param r 实例对象
     * @return 实例对象
     */
    R insert(R r);

    /**
     * 修改数据
     *
     * @param r 实例对象
     * @return 实例对象
     */
    R update(R r);

    /**
     * 通过主键删除数据
     *
     * @param rId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer rId);

}
