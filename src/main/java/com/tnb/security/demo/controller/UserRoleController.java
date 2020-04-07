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
import com.tnb.security.demo.service.IUserRoleService;
import com.tnb.security.demo.entity.pojo.UserRole;
import com.tnb.security.demo.entity.common.PageRequest;
import com.tnb.security.demo.entity.common.Result;
import com.tnb.security.demo.entity.common.ResultGenerator;
import com.tnb.security.demo.entity.common.PageResponse;
import javax.annotation.Resource;
import java.util.Arrays;
/**
 * <p>
 * 用户角色 前端控制器
 * </p>
 *
 * @author swen
 * @since 2020-04-07
 */
@Api(value = "用户角色接口", tags = {"用户角色接口"})
@Slf4j
@RestController
@RequestMapping("/user-role")
public class UserRoleController {

     @Resource
     private IUserRoleService userRoleService;

     /**
      * 用户角色列表
      * @param userRole 用户角色
      * @param pageRequest 分页参数
      * @return Result
      */
     @ApiOperation(value = "用户角色列表", notes = "用户角色列表")
     @PreAuthorize("hasAuthority('userRole:view')")
     @GetMapping
     public Result list(UserRole userRole, PageRequest pageRequest) {
         QueryWrapper<UserRole> queryWrapper = new QueryWrapper<>();
         //TODO 设置查询条件

         Page<UserRole> page = new Page<>(pageRequest.getPageIndex(), pageRequest.getPageSize());
         IPage<UserRole> userRolePage = userRoleService.page(page, queryWrapper);
         return ResultGenerator.genSuccessResult(PageResponse.<UserRole>builder().list(userRolePage.getRecords()).total(userRolePage.getTotal()).build());
     }

     /**
      * 用户角色新增
      * @param userRole 用户角色
      * @return Result
      */
     @ApiOperation(value = "用户角色新增", notes = "用户角色新增")
     @PreAuthorize("hasAuthority('userRole:add')")
     @PostMapping
     public Result add(UserRole userRole) {
         return ResultGenerator.genSuccessResult(userRoleService.save(userRole));
     }

     /**
      * 用户角色删除
      * @param ids 用户角色主键
      * @return Result
      */
     @ApiOperation(value = "用户角色删除", notes = "用户角色删除")
     @PreAuthorize("hasAuthority('userRole:delete')")
     @DeleteMapping("/{ids}")
     public Result delete(@PathVariable String ids) {
         return ResultGenerator.genSuccessResult(userRoleService.removeByIds(Arrays.asList(ids.split(StringPool.COMMA))));
     }

     /**
      * 用户角色修改
      * @param userRole 用户角色
      * @return Result
      */
     @ApiOperation(value = "用户角色修改", notes = "用户角色修改")
     @PreAuthorize("hasAuthority('userRole:update')")
     @PutMapping
     public Result update(UserRole userRole) {
         return ResultGenerator.genSuccessResult(userRoleService.updateById(userRole));
     }

     /**
      * 用户角色详情
      * @param id 用户角色主键
      * @return Result
      */
     @ApiOperation(value = "用户角色详情", notes = "用户角色详情")
     @PreAuthorize("hasAuthority('userRole:view')")
     @GetMapping("/{id:\\d+}")
     public Result detail(@PathVariable Integer id) {
         return ResultGenerator.genSuccessResult(userRoleService.getById(id));
     }
}
