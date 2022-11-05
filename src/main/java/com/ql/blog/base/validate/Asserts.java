package com.ql.blog.base.validate;

import com.ql.blog.base.exception.BlogException;

/**
 * 断言
 *
 * @author wanqiuli
 * @date 2022/11/04
 */
public class Asserts {

    /**
     * 非空
     *
     * @param obj     obj
     * @param message 消息
     */
    public static void notNull(Object obj, String message) {
        if (obj == null) {
            throw BlogException.of(message);
        }
    }

    /**
     * @param message 消息
     */
    public static void of(String message) {
        throw new BlogException(message);
    }

    public static void of() {
        throw new BlogException("服务器处理失败");
    }

    /**
     * 为空
     *
     * @param obj     obj
     * @param message 消息
     */
    public static void isNull(Object obj, String message) {
        if (obj != null) {
            throw BlogException.of(message);
        }
    }
}
