package com.zut.controller;

import com.zut.entity.Carmate;
import com.zut.service.CarmateService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Carmate)表控制层
 *
 * @author 古月小白
 * @since 2022-03-06 21:17:20
 */
@RestController
@RequestMapping("carmate")
public class CarmateController {
    /**
     * 服务对象
     */
    @Resource
    private CarmateService carmateService;

    /**
     * 分页查询
     *
     * @param carmate 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Carmate>> queryByPage(Carmate carmate, PageRequest pageRequest) {
        return ResponseEntity.ok(this.carmateService.queryByPage(carmate, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Carmate> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.carmateService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param carmate 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Carmate> add(Carmate carmate) {
        return ResponseEntity.ok(this.carmateService.insert(carmate));
    }

    /**
     * 编辑数据
     *
     * @param carmate 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Carmate> edit(Carmate carmate) {
        return ResponseEntity.ok(this.carmateService.update(carmate));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.carmateService.deleteById(id));
    }

}

