package com.tnb.security.demo.service.impl;

import com.tnb.security.demo.entity.pojo.Role;
import com.tnb.security.demo.mapper.RoleMapper;
import com.tnb.security.demo.service.IRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 角色信息 服务实现类
 * </p>
 *
 * @author swen
 * @since 2020-04-07
 */
@Service
@Transactional
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

}
