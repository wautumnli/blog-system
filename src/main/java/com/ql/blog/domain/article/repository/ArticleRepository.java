package com.ql.blog.domain.article.repository;

import com.ql.blog.domain.article.model.Article;

/**
 * 文章库
 *
 * @author wanqiuli
 * @date 2022/11/04
 */
public interface ArticleRepository {
    /**
     * 保存
     *
     * @param article 文章
     */
    void save(Article article);

    /**
     * 找到文章id
     *
     * @param id id
     * @return {@link Article}
     */
    Article findArticleById(Long id);

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
