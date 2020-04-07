package com.tnb.security.demo.entity.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;

/**
 * <p>
 * 用户信息
 * </p>
 *
 * @author swen
 * @since 2020-04-07
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName("t_user")
@ApiModel(value="User对象", description="用户信息")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户id")
    @TableId(value = "user_id", type = IdType.AUTO)
    private Integer userId;

    @ApiModelProperty(value = "登录名")
    @TableField("user_name")
    private String userName;

    @ApiModelProperty(value = "用户密码")
    @TableField("password")
    private String password;

    @ApiModelProperty(value = "手机号")
    @TableField("mobile")
    private String mobile;

    @ApiModelProperty(value = "头像图片")
    @TableField("user_photo")
    private String userPhoto;

    @ApiModelProperty(value = "性别 0 男 1 女")
    @TableField("sex")
    private Integer sex;

    @ApiModelProperty(value = "部门id")
    @TableField("dept_id")
    private Integer deptId;

    @ApiModelProperty(value = "创建时间")
    @TableField("create_time")
    private Date createTime;

    @ApiModelProperty(value = "修改时间")
    @TableField("modify_time")
    private Date modifyTime;

    @ApiModelProperty(value = "状态 0有效 1锁定")
    @TableField("status")
    private Integer status;

    @ApiModelProperty(value = "是否删除 0 未删除 1 已删除")
    @TableField("is_del")
    @TableLogic
    private Integer isDel;


}
