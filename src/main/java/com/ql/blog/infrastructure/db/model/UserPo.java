package com.ql.blog.infrastructure.db.model;

import com.baomidou.mybatisplus.annotation.*;
import com.ql.blog.base.mark.PersistenceObject;
import lombok.Data;

import java.util.Date;

/**
 * 用户持久化对象
 *
 * @author wanqiuli
 * @date 2022/11/04
 */
@Data
@TableName("au_user")
public class UserPo implements PersistenceObject {

    /**
     * id
     */
    @TableId(type = IdType.AUTO)
    private Long id;
    /**
     * 用户名
     */
    @TableField(value = "username")
    private String username;
    /**
     * 密码
     */
    @TableField(value = "password")
    private String password;
    /**
     * 创建时间
     */
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;
    /**
     * 创建用户
     */
    @TableField(value = "create_user")
    private String createUser;
    /**
     * 更新时间
     */
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
    /**
     * 更新用户
     */
    @TableField(value = "update_user")
    private String updateUser;
    /**
     * 删除
     */
    @TableField(value = "deleted")
    @TableLogic
    private Integer deleted;
    /**
     * 版本
     */
    @TableField(value = "ver")
    @Version
    private Integer ver;
}
