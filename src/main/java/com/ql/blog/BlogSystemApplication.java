package com.ql.blog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 博客系统应用程序
 *
 * @author wanqiuli
 * @date 2022/11/04
 */
@MapperScan("com.ql.blog.infrastructure.db.dao")
@SpringBootApplication
public class BlogSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogSystemApplication.class, args);
    }
}
