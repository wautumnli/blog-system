package com.ql.blog.application.user.factory;

import com.ql.blog.domain.user.model.User;
import com.ql.blog.interaction.web.user.model.RegisterCommand;

/**
 * 用户工厂
 *
 * @author wanqiuli
 * @date 2022/11/04
 */
public class UserFactory {
    /**
     * 创建用户
     *
     * @param command 命令
     * @return {@link User}
     */
    public static User createUser(RegisterCommand command) {
        return new User()
                .setUsername(command.getUsername())
                .setPassword(command.getPassword());
    }
}
