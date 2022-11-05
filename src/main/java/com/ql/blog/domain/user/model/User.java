package com.ql.blog.domain.user.model;

import com.ql.blog.base.entity.BaseAggregateRoot;
import com.ql.blog.base.mark.AggregateRoot;
import com.ql.blog.base.utils.BlogPasswordEncoder;
import com.ql.blog.base.validate.Asserts;
import com.ql.blog.domain.user.enums.LoginStatusEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * 用户
 *
 * @author wanqiuli
 * @date 2022/11/04
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class User extends BaseAggregateRoot implements AggregateRoot, UserDetails {
    /**
     * id
     */
    private Long id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 登录状态
     */
    private Integer loginStatus;

    /**
     * 得到权限
     *
     * @return {@link Collection}<{@link ?} {@link extends} {@link GrantedAuthority}>
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    /**
     * 是账户非过期
     *
     * @return boolean
     */
    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    /**
     * 是账户非锁定
     *
     * @return boolean
     */
    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    /**
     * 是凭证不过期
     *
     * @return boolean
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    /**
     * 启用了
     *
     * @return boolean
     */
    @Override
    public boolean isEnabled() {
        return false;
    }

    /**
     * 登录
     *
     * @param password 密码
     */
    public void login(String password) {
        // 判断密码
        judgePasswordCorrect(password);

        // 设置登录状态
        setLoginStatus(LoginStatusEnum.LOGGED_IN.getVal());
        setUpdateUser(this.username);
    }

    /**
     * 判断密码正确
     *
     * @param password 密码
     */
    private void judgePasswordCorrect(String password) {
        // 密码是否相同
        if (!BlogPasswordEncoder.passwordEncoder.matches(password, this.password)) {
            Asserts.of("密码不正确，情检测");
        }
    }

    /**
     * 注册
     */
    public void register() {
        // 修改登录状态
        setLoginStatus(LoginStatusEnum.NOT_LOGGED_IN.getVal());
        setCreateUser(this.username);
        setUpdateUser(this.password);
    }
}
