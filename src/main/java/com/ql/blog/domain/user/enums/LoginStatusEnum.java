package com.ql.blog.domain.user.enums;

/**
 * 登录状态枚举
 *
 * @author wanqiuli
 * @date 2022/11/04
 */
public enum LoginStatusEnum {

    /**
     * 登录状态
     */
    LOGGED_IN(1, "已登录"),
    NOT_LOGGED_IN(0, "未登录");
    private final int val;

    private final String desc;

    LoginStatusEnum(int val, String desc) {
        this.val = val;
        this.desc = desc;
    }

    public int getVal() {
        return val;
    }

    public String getDesc() {
        return desc;
    }
}
