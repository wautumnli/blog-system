package com.ql.blog.application.user.manager;

import com.ql.blog.domain.user.model.User;

/**
 * 用户管理器
 *
 * @author wanqiuli
 * @date 2022/11/04
 */
public interface UserManager {
    /**
     * 保存
     *
     * @param user 用户
     */
    void save(User user);
}
