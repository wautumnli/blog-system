package com.ql.blog.base.utils;

import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * 博客密码编码器
 *
 * @author wanqiuli
 * @date 2022/11/04
 */
public class BlogPasswordEncoder {

    public static PasswordEncoder passwordEncoder;


    public static void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        BlogPasswordEncoder.passwordEncoder = passwordEncoder;
    }
}
