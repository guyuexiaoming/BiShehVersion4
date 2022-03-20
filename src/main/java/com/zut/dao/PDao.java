package com.zut.dao;

import com.zut.entity.P;
import com.zut.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (P)表数据库访问层
 *
 * @author 古月小白
 * @since 2022-03-06 21:17:20
 */
public interface PDao {

    /**
     * 通过ID查询单条数据
     *
     * @param pId 主键
     * @return 实例对象
     */
    P queryById(Integer pId);

    /**
     * 查询表内所有数据
     *
     * @return 实例对象表
     */
    List<P> queryAll();

    /**
     * 查询指定行数据
     *
     * @param p 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<P> queryAllByLimit(P p, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param p 查询条件
     * @return 总行数
     */
    long count(P p);

    /**
     * 新增数据
     *
     * @param p 实例对象
     * @return 影响行数
     */
    int insert(P p);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<P> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<P> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<P> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<P> entities);

    /**
     * 修改数据
     *
     * @param p 实例对象
     * @return 影响行数
     */
    int update(P p);

    /**
     * 通过主键删除数据
     *
     * @param pId 主键
     * @return 影响行数
     */
    int deleteById(Integer pId);

}

