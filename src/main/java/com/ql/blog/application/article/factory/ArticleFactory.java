package com.ql.blog.application.article.factory;

import com.ql.blog.domain.article.model.Article;
import com.ql.blog.domain.article.model.ArticleContent;
import com.ql.blog.interaction.web.article.model.ArticleCreateCommand;
import com.ql.blog.interaction.web.article.model.ArticleUpdateCommand;

/**
 * 文章工厂
 *
 * @author wanqiuli
 * @date 2022/11/04
 */
public class ArticleFactory {
    /**
     * 创建文章
     *
     * @param command 命令
     * @return {@link Article}
     */
    public static Article createArticle(ArticleCreateCommand command) {
        // 文章内容
        ArticleContent articleContent = new ArticleContent()
                .setContent(command.getContent());

        // 文章
        return new Article()
                .setArticleName(command.getArticleName())
                .setUserId(command.getUserId())
                .setArticleContent(articleContent);
    }

    public static Article createArticle(ArticleUpdateCommand command) {
        ArticleContent articleContent = new ArticleContent()
                .setContent(command.getContent());
        articleContent.setUpdateUser(command.getSysCode());

        Article article = new Article();
        article.setUpdateUser(command.getSysCode());
        return article
                .setArticleName(command.getArticleName())
                .setArticleContent(articleContent);
    }
}
