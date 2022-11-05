package com.ql.blog.application.user.manager.impl;

import com.ql.blog.application.user.manager.UserManager;
import com.ql.blog.base.validate.Asserts;
import com.ql.blog.domain.user.model.User;
import com.ql.blog.domain.user.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 用户管理器impl
 *
 * @author wanqiuli
 * @date 2022/11/04
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserManagerImpl implements UserManager {

    @Resource
    private UserRepository userRepository;

    @Override
    public void save(User user) {
        int save = userRepository.save(user);
        if (save == 0) {
            Asserts.of("服务器处理异常");
        }
    }

    @Override
    public void update(User user) {
        int update = userRepository.update(user);
        if (update == 0) {
            Asserts.of("服务器处理异常");
        }
    }
}
