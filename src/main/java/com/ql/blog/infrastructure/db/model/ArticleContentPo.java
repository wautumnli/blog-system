package com.ql.blog.infrastructure.db.model;

import com.baomidou.mybatisplus.annotation.*;
import com.ql.blog.base.mark.PersistenceObject;
import lombok.Data;

import java.util.Date;

/**
 * 文章内容持久化对象
 *
 * @author wanqiuli
 * @date 2022/11/04
 */
@Data
@TableName("a_article_content")
public class ArticleContentPo implements PersistenceObject {

    /**
     * id
     */
    @TableId(type = IdType.AUTO)
    private Long id;
    /**
     * 内容
     */
    @TableField(value = "content", typeHandler = org.apache.ibatis.type.BlobTypeHandler.class)
    private byte[] content;
    /**
     * 创建时间
     */
    @TableField(value = "createTime", fill = FieldFill.INSERT)
    private Date createTime;
    /**
     * 创建用户
     */
    @TableField(value = "createUser")
    private String createUser;
    /**
     * 更新时间
     */
    @TableField(value = "updateTime", fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
    /**
     * 更新用户
     */
    @TableField(value = "updateUser")
    private Date updateUser;
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
