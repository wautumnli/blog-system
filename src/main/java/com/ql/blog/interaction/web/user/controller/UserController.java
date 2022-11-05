package com.ql.blog.interaction.web.user.controller;

import com.ql.blog.application.user.UserCommandService;
import com.ql.blog.base.result.Result;
import com.ql.blog.interaction.web.user.model.LoginCommand;
import com.ql.blog.interaction.web.user.model.RegisterCommand;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * 用户控制器
 *
 * @author wanqiuli
 * @date 2022/11/04
 */
@Api(value = "用户控制器")
@RestController("/user")
public class UserController {

    @Resource
    private UserCommandService userCommandService;

    /**
     * 登录
     *
     * @param command 命令
     * @return {@link Result}
     */
    @ApiOperation(value = "登录")
    @PostMapping("/login")
    public Result login(@RequestBody @Valid LoginCommand command) {
        return userCommandService.login(command);
    }

    /**
     * 注册
     *
     * @param command 命令
     * @return {@link Result}
     */
    @ApiOperation(value = "注册")
    @PostMapping("/register")
    public Result register(@RequestBody @Valid RegisterCommand command) {
        return userCommandService.register(command);
    }
}
