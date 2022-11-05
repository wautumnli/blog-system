package com.ql.blog.application.user.impl;

import com.ql.blog.application.user.UserCommandService;
import com.ql.blog.application.user.factory.UserFactory;
import com.ql.blog.application.user.manager.UserManager;
import com.ql.blog.base.result.Result;
import com.ql.blog.base.security.JwtProperties;
import com.ql.blog.base.security.JwtTokenUtils;
import com.ql.blog.base.validate.Asserts;
import com.ql.blog.domain.user.model.User;
import com.ql.blog.domain.user.repository.UserRepository;
import com.ql.blog.interaction.web.user.model.LoginCommand;
import com.ql.blog.interaction.web.user.model.LoginResultDto;
import com.ql.blog.interaction.web.user.model.RegisterCommand;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 用户命令服务impl
 *
 * @author wanqiuli
 * @date 2022/11/04
 */
@Service
public class UserCommandServiceImpl implements UserCommandService {

    @Resource
    private UserRepository userRepository;
    @Resource
    private UserManager userManager;
    @Resource
    private JwtTokenUtils jwtTokenUtils;
    @Resource
    private JwtProperties jwtProperties;

    @Override
    public Result<LoginResultDto> login(LoginCommand command) {
        // 查询用户
        User user = userRepository.getUserByUsername(command.getUsername());
        Asserts.notNull(user, "用户不存在");

        // 用户登录
        String token = user.login(command.getPassword());

        // 存储
        userManager.save(user);

        // 返回结果
        return Result.suc(new LoginResultDto()
                .setToken(token)
                .setHead(jwtProperties.getTokenHead()));
    }

    @Override
    public Result<Void> register(RegisterCommand command) {
        // 查询用户
        User existUser = userRepository.getUserByUsername(command.getUsername());
        Asserts.isNull(existUser, "用户名已存在");

        // 注册
        User user = UserFactory.createUser(command);
        user.register();

        // 存储
        userManager.save(user);
        return Result.suc();
    }
}
