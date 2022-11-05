package com.ql.blog.infrastructure.db.respository;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.ql.blog.domain.user.model.User;
import com.ql.blog.domain.user.repository.UserRepository;
import com.ql.blog.infrastructure.db.dao.UserDao;
import com.ql.blog.infrastructure.db.mapper.UserMapper;
import com.ql.blog.infrastructure.db.model.UserPo;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * 用户存储库实现类
 *
 * @author wanqiuli
 * @date 2022/11/04
 */
@Repository
public class UserRepositoryImpl implements UserRepository {

    @Resource
    private UserDao userDao;

    @Override
    public User getUserByUsername(String username) {
        UserPo userPo = userDao.selectOne(Wrappers.<UserPo>lambdaQuery()
                .eq(UserPo::getUsername, username));
        return UserMapper.MAPPER.toEntity(userPo);
    }

    @Override
    public int update(User user) {
        UserPo userPo = UserMapper.MAPPER.toPo(user);
        return userDao.updateById(userPo);
    }

    @Override
    public int save(User user) {
        UserPo userPo = UserMapper.MAPPER.toPo(user);
        return userDao.insert(userPo);
    }
}
