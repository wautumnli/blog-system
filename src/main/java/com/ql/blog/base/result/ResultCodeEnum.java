package com.ql.blog.base.result;

/**
 * 枚举结果代码
 *
 * @author wanqiuli
 * @date 2022/11/04
 */
public enum ResultCodeEnum {

    /**
     * code枚举
     */
    SUCCESS(200, "请求处理成功"),
    FAIL(500, "服务处理失败"),
    ;

    ResultCodeEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    private final int code;

    private final String desc;

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
