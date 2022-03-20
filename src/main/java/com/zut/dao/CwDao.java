package com.zut.dao;

import com.zut.entity.Cw;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (Cw)表数据库访问层
 *
 * @author 古月小白
 * @since 2022-03-06 21:17:20
 */
public interface CwDao {

    /**
     * 通过ID查询单条数据
     *
     * @param cwId 主键
     * @return 实例对象
     */
    Cw queryById(Integer cwId);

    /**
     * 查询指定行数据
     *
     * @param cw 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<Cw> queryAllByLimit(Cw cw, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param cw 查询条件
     * @return 总行数
     */
    long count(Cw cw);

    /**
     * 新增数据
     *
     * @param cw 实例对象
     * @return 影响行数
     */
    int insert(Cw cw);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Cw> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Cw> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Cw> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Cw> entities);

    /**
     * 修改数据
     *
     * @param cw 实例对象
     * @return 影响行数
     */
    int update(Cw cw);

    /**
     * 通过主键删除数据
     *
     * @param cwId 主键
     * @return 影响行数
     */
    int deleteById(Integer cwId);

}

