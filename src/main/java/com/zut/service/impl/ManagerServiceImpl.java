package com.zut.service.impl;

import com.zut.entity.Manager;
import com.zut.dao.ManagerDao;
import com.zut.entity.User;
import com.zut.service.ManagerService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (Manager)表服务实现类
 *
 * @author 古月小白
 * @since 2022-03-06 21:17:20
 */
@Service("managerService")
public class ManagerServiceImpl implements ManagerService {
    @Resource
    private ManagerDao managerDao;

    /**
     * 通过ID查询单条数据
     *
     * @param username 主键
     * @return 实例对象
     */
    @Override
    public Manager queryById(String username) {
        System.out.println("**********");
        return this.managerDao.queryById(username);
    }

    /**
     * 分页查询
     *
     * @param manager 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Manager> queryByPage(Manager manager, PageRequest pageRequest) {
        long total = this.managerDao.count(manager);
        return new PageImpl<>(this.managerDao.queryAllByLimit(manager, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param manager 实例对象
     * @return 实例对象
     */
    @Override
    public Manager insert(Manager manager) {
        this.managerDao.insert(manager);
        return manager;
    }

    /**
     * 修改数据
     *
     * @param manager 实例对象
     * @return 实例对象
     */
    @Override
    public Manager update(Manager manager) {
        this.managerDao.update(manager);
        return this.queryById(manager.getUsername());
    }

    /**
     * 通过主键删除数据
     *
     * @param username 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String username) {
        return this.managerDao.deleteById(username) > 0;
    }

    @Override
    public Boolean loginByManager(Manager manager) {


        if(managerDao.queryById(manager.getUsername())==null){
            return false;
        }
        Manager manager1 =managerDao.queryById(manager.getUsername());
        System.out.println(manager1.getUsername());
        System.out.println(manager.getPassword()+"***************************************");
        String s = " ";
        String s1 = " ";
         s = managerDao.queryById(manager.getUsername()).getUsername();
         s1 = managerDao.queryById(manager.getUsername()).getPassword();

        if (s1.equals(manager.getPassword())) {
            return true;
        }
        return false;
    }
}
