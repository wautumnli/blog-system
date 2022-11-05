package com.ql.blog.base.exception;

/**
 * 博客异常
 *
 * @author wanqiuli
 * @date 2022/11/04
 */
public class BlogException extends RuntimeException {

    public BlogException() {
        super();
    }

    public BlogException(String message) {
        super(message);
    }

    /**
     * 生成异常
     *
     * @param message 消息
     * @return {@link BlogException}
     */
    public static BlogException of(String message) {
        return new BlogException(message);
    }
}
