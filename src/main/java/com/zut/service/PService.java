package com.zut.service;

import com.zut.entity.P;
import com.zut.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * (P)表服务接口
 *
 * @author 古月小白
 * @since 2022-03-06 21:17:20
 */
public interface PService {

    /**
     * 通过ID查询单条数据
     *
     * @param pId 主键
     * @return 实例对象
     */
    P queryById(Integer pId);

    /**
     * 查询表内所有数据
     *
     * @return 实例对象表
     */
    List<P> queryAll();

    /**
     * 分页查询
     *
     * @param p 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<P> queryByPage(P p, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param p 实例对象
     * @return 实例对象
     */
    P insert(P p);

    /**
     * 修改数据
     *
     * @param p 实例对象
     * @return 实例对象
     */
    P update(P p);

    /**
     * 通过主键删除数据
     *
     * @param pId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer pId);

}
