package com.ql.blog.application.user;

import com.ql.blog.base.result.Result;
import com.ql.blog.interaction.web.user.model.LoginCommand;
import com.ql.blog.interaction.web.user.model.LoginResultDto;
import com.ql.blog.interaction.web.user.model.RegisterCommand;

/**
 * 用户命令服务
 *
 * @author wanqiuli
 * @date 2022/11/04
 */
public interface UserCommandService {
    /**
     * 登录
     *
     * @param command 命令
     * @return {@link Result}<{@link LoginResultDto}>
     */
    Result<LoginResultDto> login(LoginCommand command);

    /**
     * 注册
     *
     * @param command 命令
     * @return {@link Result}
     */
    Result<Void> register(RegisterCommand command);
}
