package com.tnb.security.demo.config;

import com.tnb.security.demo.entity.common.CurrentUser;
import com.tnb.security.demo.service.IUserService;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserDetailService implements UserDetailsService {

    @Resource
    private IUserService userService;

    @Resource
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        CurrentUser currentUser = userService.findByUserName(userName);
        // 判断用户是否存在
        if(currentUser == null) { throw new UsernameNotFoundException("用户名不存在"); }
        return currentUser;
    }
}
