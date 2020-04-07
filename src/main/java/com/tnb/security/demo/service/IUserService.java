package com.tnb.security.demo.service;

import com.tnb.security.demo.entity.common.CurrentUser;
import com.tnb.security.demo.entity.pojo.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户信息 服务类
 * </p>
 *
 * @author swen
 * @since 2020-04-07
 */
public interface IUserService extends IService<User> {

    CurrentUser findByUserName(String userName);
}
