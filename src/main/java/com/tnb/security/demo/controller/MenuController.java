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
import com.tnb.security.demo.service.IMenuService;
import com.tnb.security.demo.entity.pojo.Menu;
import com.tnb.security.demo.entity.common.PageRequest;
import com.tnb.security.demo.entity.common.Result;
import com.tnb.security.demo.entity.common.ResultGenerator;
import com.tnb.security.demo.entity.common.PageResponse;
import javax.annotation.Resource;
import java.util.Arrays;
/**
 * <p>
 * 菜单 前端控制器
 * </p>
 *
 * @author swen
 * @since 2020-04-07
 */
@Api(value = "菜单接口", tags = {"菜单接口"})
@Slf4j
@RestController
@RequestMapping("/menu")
public class MenuController {

     @Resource
     private IMenuService menuService;

     /**
      * 菜单列表
      * @param menu 菜单
      * @param pageRequest 分页参数
      * @return Result
      */
     @ApiOperation(value = "菜单列表", notes = "菜单列表")
     @PreAuthorize("hasAuthority('menu:view')")
     @GetMapping
     public Result list(Menu menu, PageRequest pageRequest) {
         QueryWrapper<Menu> queryWrapper = new QueryWrapper<>();
         //TODO 设置查询条件

         Page<Menu> page = new Page<>(pageRequest.getPageIndex(), pageRequest.getPageSize());
         IPage<Menu> menuPage = menuService.page(page, queryWrapper);
         return ResultGenerator.genSuccessResult(PageResponse.<Menu>builder().list(menuPage.getRecords()).total(menuPage.getTotal()).build());
     }

     /**
      * 菜单新增
      * @param menu 菜单
      * @return Result
      */
     @ApiOperation(value = "菜单新增", notes = "菜单新增")
     @PreAuthorize("hasAuthority('menu:add')")
     @PostMapping
     public Result add(Menu menu) {
         return ResultGenerator.genSuccessResult(menuService.save(menu));
     }

     /**
      * 菜单删除
      * @param ids 菜单主键
      * @return Result
      */
     @ApiOperation(value = "菜单删除", notes = "菜单删除")
     @PreAuthorize("hasAuthority('menu:delete')")
     @DeleteMapping("/{ids}")
     public Result delete(@PathVariable String ids) {
         return ResultGenerator.genSuccessResult(menuService.removeByIds(Arrays.asList(ids.split(StringPool.COMMA))));
     }

     /**
      * 菜单修改
      * @param menu 菜单
      * @return Result
      */
     @ApiOperation(value = "菜单修改", notes = "菜单修改")
     @PreAuthorize("hasAuthority('menu:update')")
     @PutMapping
     public Result update(Menu menu) {
         return ResultGenerator.genSuccessResult(menuService.updateById(menu));
     }

     /**
      * 菜单详情
      * @param id 菜单主键
      * @return Result
      */
     @ApiOperation(value = "菜单详情", notes = "菜单详情")
     @PreAuthorize("hasAuthority('menu:view')")
     @GetMapping("/{id:\\d+}")
     public Result detail(@PathVariable Integer id) {
         return ResultGenerator.genSuccessResult(menuService.getById(id));
     }
}
