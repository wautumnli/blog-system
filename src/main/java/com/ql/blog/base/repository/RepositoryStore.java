package com.ql.blog.base.repository;


import java.lang.annotation.*;

/**
 * 存储库存储
 *
 * @author wanqiuli
 * @date 2022/11/04
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Documented
public @interface RepositoryStore {
    /**
     * 类型
     *
     * @return {@link String}
     */
    String type() default "";

    /**
     * 优先级
     *
     * @return int
     */
    int order() default 99;
}
