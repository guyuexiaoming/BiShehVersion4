package com.zut.service;

import com.zut.entity.Manager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

/**
 * (Manager)表服务接口
 *
 * @author 古月小白
 * @since 2022-03-06 21:17:20
 */

public interface ManagerService {



    /**
     * 通过ID查询单条数据
     *
     * @param username 主键
     * @return 实例对象
     */
    Manager queryById(String username);

    /**
     * 分页查询
     *
     * @param manager 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Manager> queryByPage(Manager manager, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param manager 实例对象
     * @return 实例对象
     */
    Manager insert(Manager manager);

    /**
     * 修改数据
     *
     * @param manager 实例对象
     * @return 实例对象
     */
    Manager update(Manager manager);

    /**
     * 通过主键删除数据
     *
     * @param username 主键
     * @return 是否成功
     */
    boolean deleteById(String username);

    /**
     * 比对账号和密码进行身份验证
     *
     * @param manager 实体类
     * @return 核验结果
     */
    Boolean loginByManager(Manager manager);

}
