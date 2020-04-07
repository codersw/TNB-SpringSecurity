package com.tnb.security.demo.mapper;

import com.tnb.security.demo.entity.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 用户信息 Mapper 接口
 * </p>
 *
 * @author swen
 * @since 2020-04-07
 */
public interface UserMapper extends BaseMapper<User> {

    User selectByUserName(@Param("userName") String userName);
}
