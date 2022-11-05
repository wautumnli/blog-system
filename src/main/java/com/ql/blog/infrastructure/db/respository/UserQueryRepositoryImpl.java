package com.ql.blog.infrastructure.db.respository;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.ql.blog.application.user.respository.UserQueryRepository;
import com.ql.blog.infrastructure.db.dao.UserDao;
import com.ql.blog.infrastructure.db.mapper.UserMapper;
import com.ql.blog.infrastructure.db.model.UserPo;
import com.ql.blog.interaction.web.user.model.UserDto;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户查询库impl
 *
 * @author wanqiuli
 * @date 2022/11/05
 */
@Repository
public class UserQueryRepositoryImpl implements UserQueryRepository {

    @Resource
    private UserDao userDao;

    @Override
    public List<UserDto> findUserByIdList(List<Long> userIdList) {
        List<UserPo> userPoList = userDao.selectList(Wrappers.<UserPo>lambdaQuery()
                .in(UserPo::getId, userIdList));
        return UserMapper.MAPPER.poToDto(userPoList);
    }
}
