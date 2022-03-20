package com.zut.service.impl;

import com.zut.entity.Cw;
import com.zut.dao.CwDao;
import com.zut.service.CwService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (Cw)表服务实现类
 *
 * @author 古月小白
 * @since 2022-03-06 21:17:20
 */
@Service("cwService")
public class CwServiceImpl implements CwService {
    @Resource
    private CwDao cwDao;

    /**
     * 通过ID查询单条数据
     *
     * @param cwId 主键
     * @return 实例对象
     */
    @Override
    public Cw queryById(Integer cwId) {
        return this.cwDao.queryById(cwId);
    }

    /**
     * 分页查询
     *
     * @param cw 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Cw> queryByPage(Cw cw, PageRequest pageRequest) {
        long total = this.cwDao.count(cw);
        return new PageImpl<>(this.cwDao.queryAllByLimit(cw, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param cw 实例对象
     * @return 实例对象
     */
    @Override
    public Cw insert(Cw cw) {
        this.cwDao.insert(cw);
        return cw;
    }

    /**
     * 修改数据
     *
     * @param cw 实例对象
     * @return 实例对象
     */
    @Override
    public Cw update(Cw cw) {
        this.cwDao.update(cw);
        return this.queryById(cw.getCwId());
    }

    /**
     * 通过主键删除数据
     *
     * @param cwId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer cwId) {
        return this.cwDao.deleteById(cwId) > 0;
    }
}
