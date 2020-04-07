package com.tnb.security.demo.config;


import com.tnb.security.demo.handler.MyAuthenticationFailureHandler;
import com.tnb.security.demo.handler.MyAuthenticationSucessHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.annotation.Resource;

/**
 * SpringSecurity 配置
 * @author swen
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Value("${web.anon-url}")
    private String[] anonUrl;

    @Resource
    private MyAuthenticationSucessHandler authenticationSucessHandler;

    @Resource
    private MyAuthenticationFailureHandler authenticationFailureHandler;


//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) {
//        auth.authenticationProvider(null);
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin() // 表单登录
                .loginPage("/login") // 登录跳转 URL
                .loginProcessingUrl("/form/login") // 处理表单登录 URL
                .successHandler(authenticationSucessHandler) // 处理登录成功
                .failureHandler(authenticationFailureHandler) // 处理登录失败
                .and()
                .authorizeRequests() // 授权配置
                .antMatchers(anonUrl)// 免认证静态资源路径
                .permitAll()
                .anyRequest()  // 所有请求
                .authenticated() // 都需要认证
                .and().csrf().disable();
    }
}
