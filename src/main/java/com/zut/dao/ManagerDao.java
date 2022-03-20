package com.zut.dao;

import com.zut.entity.Manager;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (Manager)表数据库访问层
 *
 * @author 古月小白
 * @since 2022-03-06 21:17:20
 */

public interface ManagerDao {

    /**
     * 通过ID查询单条数据
     *
     * @param username 主键
     * @return 实例对象
     */
    Manager queryById(String username);

    /**
     * 查询指定行数据
     *
     * @param manager 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<Manager> queryAllByLimit(Manager manager, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param manager 查询条件
     * @return 总行数
     */
    long count(Manager manager);

    /**
     * 新增数据
     *
     * @param manager 实例对象
     * @return 影响行数
     */
    int insert(Manager manager);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Manager> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Manager> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Manager> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Manager> entities);

    /**
     * 修改数据
     *
     * @param manager 实例对象
     * @return 影响行数
     */
    int update(Manager manager);

    /**
     * 通过主键删除数据
     *
     * @param username 主键
     * @return 影响行数
     */
    int deleteById(String username);

}
