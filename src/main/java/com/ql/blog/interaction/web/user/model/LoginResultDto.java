package com.ql.blog.interaction.web.user.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 登录结果dto
 *
 * @author wanqiuli
 * @date 2022/11/05
 */
@Data
@ApiModel(value = "登录结果")
@Accessors(chain = true)
public class LoginResultDto {
    @ApiModelProperty(value = "头部")
    private String head;
    @ApiModelProperty(value = "token")
    private String token;
}
