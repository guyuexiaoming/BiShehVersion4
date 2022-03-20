package com.zut.dao;

import com.zut.entity.Announ;
import com.zut.entity.P;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (Announ)表数据库访问层
 *
 * @author 古月小白
 * @since 2022-03-06 21:17:17
 */
public interface AnnounDao {

    /**
     * 通过ID查询单条数据
     *
     * @param anId 主键
     * @return 实例对象
     */
    Announ queryById(Integer anId);

    /**
     * 查询表内所有数据
     *
     * @return 实例对象表
     */
    List<Announ> queryAll();

    /**
     * 查询指定行数据
     *
     * @param announ 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<Announ> queryAllByLimit(Announ announ, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param announ 查询条件
     * @return 总行数
     */
    long count(Announ announ);

    /**
     * 新增数据
     *
     * @param announ 实例对象
     * @return 影响行数
     */
    int insert(Announ announ);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Announ> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Announ> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Announ> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Announ> entities);

    /**
     * 修改数据
     *
     * @param announ 实例对象
     * @return 影响行数
     */
    int update(Announ announ);

    /**
     * 通过主键删除数据
     *
     * @param anId 主键
     * @return 影响行数
     */
    int deleteById(Integer anId);

}

