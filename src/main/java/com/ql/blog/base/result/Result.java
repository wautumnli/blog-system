package com.ql.blog.base.result;

import lombok.Data;
import lombok.experimental.Accessors;

import static com.ql.blog.base.result.ResultCodeEnum.FAIL;
import static com.ql.blog.base.result.ResultCodeEnum.SUCCESS;

/**
 * 结果
 *
 * @author wanqiuli
 * @date 2022/11/04
 */
@Data
@Accessors(chain = true)
public class Result<T> {

    private int code;
    private boolean status;
    private T data;

    /**
     * 成功
     *
     * @return {@link Result}
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    public static <T> Result<T> suc() {
        return new Result()
                .setCode(SUCCESS.getCode())
                .setStatus(true);
    }

    /**
     * 失败
     *
     * @return {@link Result}
     */
    @SuppressWarnings({"rawtypes"})
    public static Result fail() {
        return new Result()
                .setCode(FAIL.getCode())
                .setStatus(false);
    }

    /**
     * 成功
     *
     * @param data 数据
     * @return {@link Result}
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    public static <T> Result<T> suc(T data) {
        return new Result()
                .setCode(SUCCESS.getCode())
                .setStatus(true)
                .setData(data);
    }

    /**
     * 失败
     *
     * @param data 数据
     * @return {@link Result}
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    public static <T> Result<T> fail(T data) {
        return new Result()
                .setCode(FAIL.getCode())
                .setStatus(false)
                .setData(data);
    }
}
