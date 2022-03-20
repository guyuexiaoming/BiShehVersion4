package com.zut.service;

import com.zut.entity.Cw;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (Cw)表服务接口
 *
 * @author 古月小白
 * @since 2022-03-06 21:17:20
 */
public interface CwService {

    /**
     * 通过ID查询单条数据
     *
     * @param cwId 主键
     * @return 实例对象
     */
    Cw queryById(Integer cwId);

    /**
     * 分页查询
     *
     * @param cw 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Cw> queryByPage(Cw cw, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param cw 实例对象
     * @return 实例对象
     */
    Cw insert(Cw cw);

    /**
     * 修改数据
     *
     * @param cw 实例对象
     * @return 实例对象
     */
    Cw update(Cw cw);

    /**
     * 通过主键删除数据
     *
     * @param cwId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer cwId);

}
