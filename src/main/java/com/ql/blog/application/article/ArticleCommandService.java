package com.ql.blog.application.article;

import com.ql.blog.base.result.Result;
import com.ql.blog.interaction.web.article.model.ArticleCreateCommand;
import com.ql.blog.interaction.web.article.model.ArticleDelCommand;
import com.ql.blog.interaction.web.article.model.ArticleUpdateCommand;

public interface ArticleCommandService {
    /**
     * 创建文章
     *
     * @param command 命令
     * @return {@link Result}
     */
    Result<Void> createArticle(ArticleCreateCommand command);

    /**
     * 更新文章
     *
     * @param command 命令
     * @return {@link Result}
     */
    Result<Void> updateArticle(ArticleUpdateCommand command);

    /**
     * 删除文章
     *
     * @param command 命令
     * @return {@link Result}
     */
    Result<Void> delArticle(ArticleDelCommand command);
}
