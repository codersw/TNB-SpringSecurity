package com.tnb.security.demo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.access.prepost.PreAuthorize;
import com.tnb.security.demo.service.ITagService;
import com.tnb.security.demo.entity.pojo.Tag;
import com.tnb.security.demo.entity.common.PageRequest;
import com.tnb.security.demo.entity.common.Result;
import com.tnb.security.demo.entity.common.ResultGenerator;
import com.tnb.security.demo.entity.common.PageResponse;
import javax.annotation.Resource;
import java.util.Arrays;
/**
 * <p>
 * 标签信息 前端控制器
 * </p>
 *
 * @author swen
 * @since 2020-04-07
 */
@Api(value = "标签信息接口", tags = {"标签信息接口"})
@Slf4j
@RestController
@RequestMapping("/tag")
public class TagController {

     @Resource
     private ITagService tagService;

     /**
      * 标签信息列表
      * @param tag 标签信息
      * @param pageRequest 分页参数
      * @return Result
      */
     @ApiOperation(value = "标签信息列表", notes = "标签信息列表")
     @PreAuthorize("hasAuthority('tag:view')")
     @GetMapping
     public Result list(Tag tag, PageRequest pageRequest) {
         QueryWrapper<Tag> queryWrapper = new QueryWrapper<>();
         //TODO 设置查询条件

         Page<Tag> page = new Page<>(pageRequest.getPageIndex(), pageRequest.getPageSize());
         IPage<Tag> tagPage = tagService.page(page, queryWrapper);
         return ResultGenerator.genSuccessResult(PageResponse.<Tag>builder().list(tagPage.getRecords()).total(tagPage.getTotal()).build());
     }

     /**
      * 标签信息新增
      * @param tag 标签信息
      * @return Result
      */
     @ApiOperation(value = "标签信息新增", notes = "标签信息新增")
     @PreAuthorize("hasAuthority('tag:add')")
     @PostMapping
     public Result add(Tag tag) {
         return ResultGenerator.genSuccessResult(tagService.save(tag));
     }

     /**
      * 标签信息删除
      * @param ids 标签信息主键
      * @return Result
      */
     @ApiOperation(value = "标签信息删除", notes = "标签信息删除")
     @PreAuthorize("hasAuthority('tag:delete')")
     @DeleteMapping("/{ids}")
     public Result delete(@PathVariable String ids) {
         return ResultGenerator.genSuccessResult(tagService.removeByIds(Arrays.asList(ids.split(StringPool.COMMA))));
     }

     /**
      * 标签信息修改
      * @param tag 标签信息
      * @return Result
      */
     @ApiOperation(value = "标签信息修改", notes = "标签信息修改")
     @PreAuthorize("hasAuthority('tag:update')")
     @PutMapping
     public Result update(Tag tag) {
         return ResultGenerator.genSuccessResult(tagService.updateById(tag));
     }

     /**
      * 标签信息详情
      * @param id 标签信息主键
      * @return Result
      */
     @ApiOperation(value = "标签信息详情", notes = "标签信息详情")
     @PreAuthorize("hasAuthority('tag:view')")
     @GetMapping("/{id:\\d+}")
     public Result detail(@PathVariable Integer id) {
         return ResultGenerator.genSuccessResult(tagService.getById(id));
     }
}
