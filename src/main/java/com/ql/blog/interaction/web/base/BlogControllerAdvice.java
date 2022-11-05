package com.ql.blog.interaction.web.base;

import com.ql.blog.base.exception.BlogException;
import com.ql.blog.base.result.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 博客控制器建议
 *
 * @author wanqiuli
 * @date 2022/11/05
 */
@RestControllerAdvice
public class BlogControllerAdvice {

    @ExceptionHandler(value = BlogException.class)
    public Result handleBlogException(BlogException exception) {
        return Result.fail(exception.getMessage());
    }

    @ExceptionHandler(value = RuntimeException.class)
    public Result handleRuntimeException(RuntimeException exception) {
        return Result.fail("服务器处理异常");
    }
}
