package com.zut.dao;

import com.zut.entity.R;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (R)表数据库访问层
 *
 * @author 古月小白
 * @since 2022-03-13 08:06:32
 */
public interface RDao {

    /**
     * 通过ID查询单条数据
     *
     * @param rId 主键
     * @return 实例对象
     */
    R queryById(Integer rId);

    /**
     * 通过时间段查询金额总数
     *
     * @return 金额数
     */
    Integer querySumMoney(@Param("bTime") String bTime, @Param("eTime") String eTime);


    /**
     * 查询指定行数据
     *
     * @param r 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<R> queryAllByLimit(R r, @Param("pageable") Pageable pageable);

    /**
     * 查询所有数据
     *
     * @return 返回List实例表
     */
    List<R> queryAll();

    /**
     * 统计总行数
     *
     * @param r 查询条件
     * @return 总行数
     */
    long count(R r);

    /**
     * 新增数据
     *
     * @param r 实例对象
     * @return 影响行数
     */
    int insert(R r);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<R> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<R> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<R> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<R> entities);

    /**
     * 修改数据
     *
     * @param r 实例对象
     * @return 影响行数
     */
    int update(R r);

    /**
     * 通过主键删除数据
     *
     * @param rId 主键
     * @return 影响行数
     */
    int deleteById(Integer rId);

}

