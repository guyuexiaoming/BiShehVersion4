package com.zut.service.impl;

import com.zut.entity.P;
import com.zut.dao.PDao;
import com.zut.entity.User;
import com.zut.service.PService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.List;

/**
 * (P)表服务实现类
 *
 * @author 古月小白
 * @since 2022-03-06 21:17:20
 */
@Service("pService")
public class PServiceImpl implements PService {
    @Resource
    private PDao pDao;

    /**
     * 通过ID查询单条数据
     *
     * @param pId 主键
     * @return 实例对象
     */
    @Override
    public P queryById(Integer pId) {
        return this.pDao.queryById(pId);
    }

    @Override
    public List<P> queryAll() {
       List<P> pList = pDao.queryAll();
        return pList;
    }

    /**
     * 分页查询
     *
     * @param p 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<P> queryByPage(P p, PageRequest pageRequest) {
        long total = this.pDao.count(p);
        return new PageImpl<>(this.pDao.queryAllByLimit(p, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param p 实例对象
     * @return 实例对象
     */
    @Override
    public P insert(P p) {
        this.pDao.insert(p);
        return p;
    }

    /**
     * 修改数据
     *
     * @param p 实例对象
     * @return 实例对象
     */
    @Override
    public P update(P p) {
        this.pDao.update(p);
        return this.queryById(p.getPId());
    }

    /**
     * 通过主键删除数据
     *
     * @param pId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer pId) {
        return this.pDao.deleteById(pId) > 0;
    }
}
