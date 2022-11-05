package com.ql.blog.application.user.respository;

import com.ql.blog.interaction.web.user.model.UserDto;

import java.util.List;

/**
 * 用户查询库
 *
 * @author wanqiuli
 * @date 2022/11/05
 */
public interface UserQueryRepository {
    /**
     * 找到用户id列表
     *
     * @param userIdList 用户id列表
     * @return {@link List}<{@link UserDto}>
     */
    List<UserDto> findUserByIdList(List<Long> userIdList);
}
