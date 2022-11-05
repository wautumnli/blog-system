package com.ql.blog.interaction.web.base;

import com.ql.blog.base.exception.BlogException;
import com.ql.blog.base.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 博客控制器建议
 *
 * @author wanqiuli
 * @date 2022/11/05
 */
@Slf4j
@RestControllerAdvice
public class BlogControllerAdvice {

    @ExceptionHandler(value = BlogException.class)
    public Result<String> handleBlogException(BlogException exception) {
        exception.printStackTrace();
        return Result.fail(exception.getMessage());
    }

    @ExceptionHandler(value = RuntimeException.class)
    public Result<String> handleRuntimeException(RuntimeException exception) {
        exception.printStackTrace();
        return Result.fail("服务器处理异常");
    }
}
