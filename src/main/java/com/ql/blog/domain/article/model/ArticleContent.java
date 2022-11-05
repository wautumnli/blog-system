package com.ql.blog.domain.article.model;

import com.ql.blog.base.entity.BaseEntity;
import com.ql.blog.base.mark.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 文章内容
 *
 * @author wanqiuli
 * @date 2022/11/04
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class ArticleContent extends BaseEntity implements Entity {

    private Long id;
    private String content;

    /**
     * 初始化
     *
     * @param sysCode 系统代码
     */
    public void init(String sysCode) {
        setCreateUser(sysCode);
        setUpdateUser(sysCode);
    }

    /**
     * 更新内容
     *
     * @param articleContent 文章内容
     */
    public void updateContent(ArticleContent articleContent) {
        setUpdateUser(articleContent.getUpdateUser());
        setContent(articleContent.getContent());
    }
}
