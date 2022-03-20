package com.zut.service;

import com.github.pagehelper.PageInfo;
import com.zut.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * (User)表服务接口
 *
 * @author 古月小白
 * @since 2022-03-06 21:17:20
 */
public interface UserService {

    /**
     * 通过ID查询单条数据
     *
     * @param userId 主键
     * @return 实例对象
     */
    User queryById(double userId);

    /**
     * 查询表内所有数据
     *
     * @return 实例对象表
     */
    List<User> queryAll();





    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    User insert(User user);

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    User update(User user);

    /**
     * 通过主键删除数据
     *
     * @param userId 主键
     * @return 是否成功
     */
    boolean deleteById(double userId);

    /**
     *
     * 增加数据
     */
    boolean insertUser(User user);

}
