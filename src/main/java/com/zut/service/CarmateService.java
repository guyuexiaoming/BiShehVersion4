package com.zut.service;

import com.zut.entity.Carmate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * (Carmate)表服务接口
 *
 * @author 古月小白
 * @since 2022-03-06 21:17:20
 */
public interface CarmateService {

    /**
     * 通过ID查询单条数据
     *
     * @param carId 主键
     * @return 实例对象
     */
    Carmate queryById(Integer carId);

    /**
     * 查询表内所有数据
     *
     * @return 实例对象表
     */
    List<Carmate> queryAll();

    /**
     * 分页查询
     *
     * @param carmate 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Carmate> queryByPage(Carmate carmate, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param carmate 实例对象
     * @return 实例对象
     */
    Carmate insert(Carmate carmate);

    /**
     * 修改数据
     *
     * @param carmate 实例对象
     * @return 实例对象
     */
    Carmate update(Carmate carmate);

    /**
     * 通过主键删除数据
     *
     * @param carId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer carId);

}
