package com.ql.blog.base.entity;

import lombok.Data;

import java.util.Date;

/**
 * 基础实体
 *
 * @author wanqiuli
 * @date 2022/11/04
 */
@Data
public abstract class BaseEntity {

    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 创建用户
     */
    private String createUser;
    /**
     * 更新用户
     */
    private String updateUser;
}
