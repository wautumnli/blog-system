package com.ql.blog.interaction.web.user.model;

import com.ql.blog.base.mark.Command;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * 登录命令
 *
 * @author wanqiuli
 * @date 2022/11/04
 */
@Data
@ApiModel(value = "登录命令")
public class LoginCommand implements Command {

    @ApiModelProperty(value = "用户名")
    @NotEmpty(message = "用户名为空")
    private String username;
    @ApiModelProperty(value = "密码")
    @NotEmpty(message = "密码为空")
    private String password;
}
