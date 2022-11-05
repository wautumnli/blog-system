package com.ql.blog.infrastructure.db.respository;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.ql.blog.base.repository.AbstractRepository;
import com.ql.blog.base.validate.Asserts;
import com.ql.blog.domain.user.model.User;
import com.ql.blog.domain.user.repository.UserRepository;
import com.ql.blog.infrastructure.db.dao.UserDao;
import com.ql.blog.infrastructure.db.mapper.UserMapper;
import com.ql.blog.infrastructure.db.model.UserPo;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.function.Function;

/**
 * 用户存储库实现类
 *
 * @author wanqiuli
 * @date 2022/11/04
 */
@Repository
public class UserRepositoryImpl extends AbstractRepository implements UserRepository {

    @Resource
    private UserDao userDao;


    @PostConstruct
    public void init() {
        register(User.class.getName(),
                (Function<User, Boolean>) this::insert,
                (Function<User, Boolean>) this::update,
                (Function<User, Boolean>) this::delete);
    }

    public Boolean insert(User user) {
        UserPo userPo = UserMapper.MAPPER.toPo(user);
        if (userDao.insert(userPo) == 0) {
            Asserts.of();
        }
        return true;
    }

    public Boolean update(User user) {
        UserPo userPo = UserMapper.MAPPER.toPo(user);
        if (userDao.updateById(userPo) == 0) {
            Asserts.of();
        }
        return true;
    }

    public Boolean delete(User user) {
        UserPo userPo = UserMapper.MAPPER.toPo(user);
        if (userDao.deleteById(userPo) == 0) {
            Asserts.of();
        }
        return true;
    }

    @Override
    public User getUserByUsername(String username) {
        UserPo userPo = userDao.selectOne(Wrappers.<UserPo>lambdaQuery()
                .eq(UserPo::getUsername, username));
        return UserMapper.MAPPER.toEntity(userPo);
    }
}
