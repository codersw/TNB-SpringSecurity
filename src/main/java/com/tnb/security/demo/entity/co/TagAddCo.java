package com.tnb.security.demo.entity.co;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value="标签新增信息", description="标签新增信息")
public class TagAddCo {

    @ApiModelProperty(value = "标签名字", example = "标签名字")
    private String tagName;

    @ApiModelProperty(value = "标签描述", example = "标签描述")
    private String tagDesc;
}
