package com.zut.service.impl;

import com.zut.entity.Carmate;
import com.zut.dao.CarmateDao;
import com.zut.service.CarmateService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Carmate)表服务实现类
 *
 * @author 古月小白
 * @since 2022-03-06 21:17:20
 */
@Service("carmateService")
public class CarmateServiceImpl implements CarmateService {
    @Resource
    private CarmateDao carmateDao;

    /**
     * 通过ID查询单条数据
     *
     * @param carId 主键
     * @return 实例对象
     */
    @Override
    public Carmate queryById(Integer carId) {
        return this.carmateDao.queryById(carId);
    }

    @Override
    public List<Carmate> queryAll() {
        return this.carmateDao.queryAll();
    }

    /**
     * 分页查询
     *
     * @param carmate 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Carmate> queryByPage(Carmate carmate, PageRequest pageRequest) {
        long total = this.carmateDao.count(carmate);
        return new PageImpl<>(this.carmateDao.queryAllByLimit(carmate, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param carmate 实例对象
     * @return 实例对象
     */
    @Override
    public Carmate insert(Carmate carmate) {
        this.carmateDao.insert(carmate);
        return carmate;
    }

    /**
     * 修改数据
     *
     * @param carmate 实例对象
     * @return 实例对象
     */
    @Override
    public Carmate update(Carmate carmate) {
        this.carmateDao.update(carmate);
        return this.queryById(carmate.getCarId());
    }

    /**
     * 通过主键删除数据
     *
     * @param carId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer carId) {
        return this.carmateDao.deleteById(carId) > 0;
    }
}
