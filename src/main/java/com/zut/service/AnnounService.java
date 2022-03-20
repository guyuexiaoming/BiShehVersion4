package com.zut.service;

import com.zut.entity.Announ;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * (Announ)表服务接口
 *
 * @author 古月小白
 * @since 2022-03-06 21:17:19
 */
public interface AnnounService {

    /**
     * 通过ID查询单条数据
     *
     * @param anId 主键
     * @return 实例对象
     */
    Announ queryById(Integer anId);

    /**
     * 查询表内所有数据
     *
     * @return 实例对象表
     */
    List<Announ> queryAll();

    /**
     * 分页查询
     *
     * @param announ 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Announ> queryByPage(Announ announ, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param announ 实例对象
     * @return 实例对象
     */
    Announ insert(Announ announ);

    /**
     * 修改数据
     *
     * @param announ 实例对象
     * @return 实例对象
     */
    Announ update(Announ announ);

    /**
     * 通过主键删除数据
     *
     * @param anId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer anId);

}
