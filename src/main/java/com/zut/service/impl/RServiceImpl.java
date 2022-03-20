package com.zut.service.impl;

import com.zut.entity.R;
import com.zut.dao.RDao;
import com.zut.service.RService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.List;

/**
 * (R)表服务实现类
 *
 * @author 古月小白
 * @since 2022-03-13 08:06:32
 */
@Service("rService")
public class RServiceImpl implements RService {
    @Resource
    private RDao rDao;

    /**
     * 通过ID查询单条数据
     *
     * @param rId 主键
     * @return 实例对象
     */
    @Override
    public R queryById(Integer rId) {
        return this.rDao.queryById(rId);
    }

    @Override
    public Integer querySumMoney(String bTime, String eTime) {
        Integer money = rDao.querySumMoney(bTime,eTime);
        if(money==null){
            money=0;
        }
        System.out.println(money);
        return money;
    }

    @Override
    public List<R> queryAll() {
        List<R> rList = rDao.queryAll();
        return rList;
    }

    /**
     * 分页查询
     *
     * @param r 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<R> queryByPage(R r, PageRequest pageRequest) {
        long total = this.rDao.count(r);
        return new PageImpl<>(this.rDao.queryAllByLimit(r, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param r 实例对象
     * @return 实例对象
     */
    @Override
    public R insert(R r) {
        this.rDao.insert(r);
        return r;
    }

    /**
     * 修改数据
     *
     * @param r 实例对象
     * @return 实例对象
     */
    @Override
    public R update(R r) {
        this.rDao.update(r);
        return this.queryById(r.getRId());
    }

    /**
     * 通过主键删除数据
     *
     * @param rId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer rId) {
        return this.rDao.deleteById(rId) > 0;
    }
}
