package com.ql.blog.application.article.manager;

import com.ql.blog.domain.article.model.Article;

/**
 * 文章管理
 *
 * @author wanqiuli
 * @date 2022/11/04
 */
public interface ArticleManager {
    /**
     * 保存
     *
     * @param article 文章
     */
    void save(Article article);

    /**
     * 更新
     *
     * @param article 文章
     */
    void update(Article article);

    /**
     * 删除
     *
     * @param article 文章
     */
    void del(Article article);
}
