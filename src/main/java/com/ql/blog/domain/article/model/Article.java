package com.ql.blog.domain.article.model;

import com.ql.blog.base.entity.BaseAggregateRoot;
import com.ql.blog.base.mark.AggregateRoot;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 博客
 *
 * @author wanqiuli
 * @date 2022/11/04
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class Article extends BaseAggregateRoot implements AggregateRoot {
    /**
     * id
     */
    private Long id;
    /**
     * 用户id
     */
    private Long userId;
    /**
     * 内容id
     */
    private Long contentId;
    /**
     * 文章名字
     */
    private String articleName;
    /**
     * 文章内容
     */
    private ArticleContent articleContent;
    private int ver;

    /**
     * 初始化
     *
     * @param sysCode 系统代码
     */
    public void init(String sysCode) {
        setCreateUser(sysCode);
        setUpdateUser(sysCode);

        // 内容初始化
        articleContent.init(sysCode);
    }

    /**
     * 更新文章
     *
     * @param update 更新
     */
    public void updateArticle(Article update) {
        // 更新文章
        setArticleName(update.getArticleName());
        setUpdateUser(update.getUpdateUser());

        // 更新内容
        getArticleContent().updateContent(update.getArticleContent());
    }
}
