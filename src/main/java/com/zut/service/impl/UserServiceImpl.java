package com.zut.service.impl;

import com.zut.entity.User;
import com.zut.dao.UserDao;
import com.zut.service.UserService;
import org.junit.Test;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.List;

/**
 * (User)表服务实现类
 *
 * @author 古月小白
 * @since 2022-03-06 21:17:20
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    /**
     * 通过ID查询单条数据
     *
     * @param userId 主键
     * @return 实例对象
     */
    @Override
    public User queryById(double userId) {
        return this.userDao.selectById(userId);
    }


    @Override
    @Test
    public List<User> queryAll() {

        List<User> userList = userDao.queryAll();

        return userList;
    }





    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public User insert(User user) {
        this.userDao.insert(user);
        return user;
    }

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public User update(User user) {
        this.userDao.update(user);
        return this.queryById(user.getUserId());
    }

    /**
     * 通过主键删除数据
     *
     * @param userId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(double userId) {
        return this.userDao.deleteById(userId) > 0;
    }

    @Override
    public boolean insertUser(User user) {
        return this.userDao.insert(user) >0;
    }
}
