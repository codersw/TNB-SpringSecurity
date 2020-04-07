package com.tnb.security.demo.entity.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
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
 * 部门信息
 * </p>
 *
 * @author swen
 * @since 2020-04-07
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName("t_dept")
@ApiModel(value="Dept对象", description="部门信息")
public class Dept implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "部门id")
    @TableId("dept_id")
    private Integer deptId;

    @ApiModelProperty(value = "部门名字")
    @TableField("dept_name")
    private String deptName;

    @ApiModelProperty(value = "父级id")
    @TableField("parent_id")
    private Integer parentId;

    @ApiModelProperty(value = "排序")
    @TableField("order_num")
    private Integer orderNum;

    @ApiModelProperty(value = "创建时间")
    @TableField("create_time")
    private Date createTime;

    @ApiModelProperty(value = "修改时间")
    @TableField("modify_time")
    private Date modifyTime;

    @ApiModelProperty(value = "是否删除 0未删除 1已删除")
    @TableField("is_del")
    @TableLogic
    private Integer isDel;


}
