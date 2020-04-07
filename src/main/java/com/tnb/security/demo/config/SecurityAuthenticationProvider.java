package com.tnb.security.demo.config;

import com.tnb.security.demo.entity.common.CurrentUser;
import com.tnb.security.demo.config.UserDetailService;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;

import javax.annotation.Resource;

//@Component
public class SecurityAuthenticationProvider implements AuthenticationProvider {

    @Resource
    private UserDetailService userDetailService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        // 获取前端表单中输入后返回的用户名、密码
        String userName = (String) authentication.getPrincipal();
        String password = (String) authentication.getCredentials();
        CurrentUser currentUser = (CurrentUser) userDetailService.loadUserByUsername(userName);
        boolean isValid = currentUser.getPassword().equals(password);
        // 验证密码
        if (!isValid) {
            throw new BadCredentialsException("密码错误！");
        }
        PreAuthenticatedAuthenticationToken preAuthenticatedAuthenticationToken =
                new PreAuthenticatedAuthenticationToken(currentUser, currentUser.getPassword(),
                        AuthorityUtils.commaSeparatedStringToAuthorityList(currentUser.getPermissions()));
        preAuthenticatedAuthenticationToken.setDetails(currentUser);
        return preAuthenticatedAuthenticationToken;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
