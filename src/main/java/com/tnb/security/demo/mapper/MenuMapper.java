package com.tnb.security.demo.mapper;

import com.tnb.security.demo.entity.pojo.Menu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 菜单 Mapper 接口
 * </p>
 *
 * @author swen
 * @since 2020-04-07
 */
public interface MenuMapper extends BaseMapper<Menu> {

    List<Menu> getMenus(@Param("userId") Integer userId);
}
