package com.ql.blog.infrastructure.db.mapper;

import com.ql.blog.domain.user.model.User;
import com.ql.blog.infrastructure.db.model.UserPo;
import com.ql.blog.interaction.web.user.model.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 用户映射器
 *
 * @author wanqiuli
 * @date 2022/11/04
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    UserMapper MAPPER = Mappers.getMapper(UserMapper.class);

    /**
     * 实体
     *
     * @param userPo 用户Po
     * @return {@link User}
     */
    User toEntity(UserPo userPo);

    /**
     * 持久化对象
     *
     * @param user 用户
     * @return {@link UserPo}
     */
    UserPo toPo(User user);

    /**
     * 转dto
     *
     * @param userPoList 用户订单列表
     * @return {@link List}<{@link UserDto}>
     */
    List<UserDto> poToDto(List<UserPo> userPoList);
}
