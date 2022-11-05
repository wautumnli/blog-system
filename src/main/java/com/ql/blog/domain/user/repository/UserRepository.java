package com.ql.blog.domain.user.repository;

import com.ql.blog.domain.user.model.User;

/**
 * 用户存储库
 *
 * @author wanqiuli
 * @date 2022/11/04
 */
public interface UserRepository {
    /**
     * 获取用户用户名
     *
     * @param username 用户名
     * @return {@link User}
     */
    User getUserByUsername(String username);

    /**
     * 更新
     *
     * @param user 用户
     * @return int
     */
    int update(User user);

    /**
     * 保存
     *
     * @param user 用户
     * @return int
     */
    int save(User user);
}
