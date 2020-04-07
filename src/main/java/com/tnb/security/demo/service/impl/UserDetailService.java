package com.tnb.security.demo.service.impl;

import com.tnb.security.demo.entity.common.CurrentUser;
import com.tnb.security.demo.service.IUserService;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserDetailService implements UserDetailsService {

    @Resource
    private IUserService userService;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        CurrentUser currentUser = userService.findByUserName(userName);
        return new User(userName, currentUser.getPassword(), true,
                true, true,
                true, AuthorityUtils.commaSeparatedStringToAuthorityList(currentUser.getPermissions()));
    }
}
