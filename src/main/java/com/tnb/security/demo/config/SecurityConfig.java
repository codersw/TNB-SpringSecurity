package com.tnb.security.demo.config;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.tnb.security.demo.entity.common.ResultGenerator;
import com.tnb.security.demo.enums.ResultCodeEnum;
import com.tnb.security.demo.handler.MyAuthenticationFailureHandler;
import com.tnb.security.demo.handler.MyAuthenticationSucessHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.Resource;
import java.io.PrintWriter;

/**
 * SpringSecurity 配置
 * @author swen
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Value("${web.anon-url}")
    private String[] anonUrl;

    @Resource
    private MyAuthenticationSucessHandler authenticationSucessHandler;

    @Resource
    private MyAuthenticationFailureHandler authenticationFailureHandler;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers(anonUrl);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin() // 表单登录
                .loginPage("/login") // 登录跳转 URL
                .loginProcessingUrl("/form/login") // 处理表单登录 URL
                .successHandler(authenticationSucessHandler) // 处理登录成功
                .failureHandler(authenticationFailureHandler) // 处理登录失败
                .and()
                .logout() // 配置登出
                .logoutUrl("/logout") // 处理登出 url
                .logoutSuccessUrl("/login") // 登出后跳转到 /
                .deleteCookies("JSESSIONID") // 删除 JSESSIONID
                .and()
                .authorizeRequests() // 授权配置
                .anyRequest()  // 所有请求
                .authenticated() // 都需要认证
                .and().csrf().disable().exceptionHandling()
                .authenticationEntryPoint((request, response, e) -> {// 重写认证失败
                    response.setContentType("application/json;charset=utf-8");
                    PrintWriter out = response.getWriter();
                    out.write(new ObjectMapper().writeValueAsString(ResultGenerator.genResult(ResultCodeEnum.UNAUTHORIZED)));
                    out.flush();
                    out.close();
                });
    }
}
