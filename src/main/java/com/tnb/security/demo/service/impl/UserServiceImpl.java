package com.tnb.security.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tnb.security.demo.entity.common.CurrentUser;
import com.tnb.security.demo.entity.pojo.Dept;
import com.tnb.security.demo.entity.pojo.Menu;
import com.tnb.security.demo.entity.pojo.User;
import com.tnb.security.demo.mapper.DeptMapper;
import com.tnb.security.demo.mapper.MenuMapper;
import com.tnb.security.demo.mapper.UserMapper;
import com.tnb.security.demo.service.IUserService;
import com.tnb.security.demo.utils.MapperUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 用户信息 服务实现类
 * </p>
 *
 * @author swen
 * @since 2020-04-07
 */
@Service
@Transactional
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Resource
    private DeptMapper deptMapper;

    @Resource
    private MenuMapper menuMapper;

    @Override
    public CurrentUser findByUserName(String userName) {
        User user = baseMapper.selectByUserName(userName);
        CurrentUser currentUser = null;
        if(user != null) {
            currentUser = MapperUtils.mapperBean(user, CurrentUser.class);
            Dept dept = deptMapper.selectById(currentUser.getDeptId());
            String deptName = "";
            if (dept != null) {
                deptName = dept.getDeptName();
            }
            currentUser.setDeptName(deptName);
            List<Menu> menus = menuMapper.getMenus(user.getUserId());
            currentUser.setPermissions(menus.stream().map(Menu::getPerms).collect(Collectors.joining(",")));
        }
        return currentUser;
    }
}
