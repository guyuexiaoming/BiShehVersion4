package com.zut.service.impl;

import com.zut.entity.Announ;
import com.zut.dao.AnnounDao;
import com.zut.service.AnnounService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Announ)表服务实现类
 *
 * @author 古月小白
 * @since 2022-03-06 21:17:19
 */
@Service("announService")
public class AnnounServiceImpl implements AnnounService {
    @Resource
    private AnnounDao announDao;

    /**
     * 通过ID查询单条数据
     *
     * @param anId 主键
     * @return 实例对象
     */
    @Override
    public Announ queryById(Integer anId) {
        return this.announDao.queryById(anId);
    }

    @Override
    public List<Announ> queryAll() {
        List<Announ> announList = announDao.queryAll();
        return announList;
    }

    /**
     * 分页查询
     *
     * @param announ 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Announ> queryByPage(Announ announ, PageRequest pageRequest) {
        long total = this.announDao.count(announ);
        return new PageImpl<>(this.announDao.queryAllByLimit(announ, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param announ 实例对象
     * @return 实例对象
     */
    @Override
    public Announ insert(Announ announ) {
        this.announDao.insert(announ);
        return announ;
    }

    /**
     * 修改数据
     *
     * @param announ 实例对象
     * @return 实例对象
     */
    @Override
    public Announ update(Announ announ) {
        this.announDao.update(announ);
        return this.queryById(announ.getAnId());
    }

    /**
     * 通过主键删除数据
     *
     * @param anId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer anId) {
        return this.announDao.deleteById(anId) > 0;
    }
}
