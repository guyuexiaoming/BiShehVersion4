package com.zut.controller;

import com.zut.entity.Cw;
import com.zut.service.CwService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Cw)表控制层
 *
 * @author 古月小白
 * @since 2022-03-06 21:17:20
 */
@Controller
@RequestMapping("cw")
public class CwController {
    /**
     * 服务对象
     */
    @Resource
    private CwService cwService;

    /**
     * 分页查询
     *
     * @param cw 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Cw>> queryByPage(Cw cw, PageRequest pageRequest) {
        return ResponseEntity.ok(this.cwService.queryByPage(cw, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Cw> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.cwService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param cw 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Cw> add(Cw cw) {
        return ResponseEntity.ok(this.cwService.insert(cw));
    }

    /**
     * 编辑数据
     *
     * @param cw 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Cw> edit(Cw cw) {
        return ResponseEntity.ok(this.cwService.update(cw));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.cwService.deleteById(id));
    }

}

