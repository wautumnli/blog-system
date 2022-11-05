package com.ql.blog.application.article.impl;

import com.ql.blog.application.article.ArticleCommandService;
import com.ql.blog.application.article.factory.ArticleFactory;
import com.ql.blog.application.article.manager.ArticleManager;
import com.ql.blog.base.result.Result;
import com.ql.blog.base.validate.Asserts;
import com.ql.blog.domain.article.model.Article;
import com.ql.blog.domain.article.repository.ArticleRepository;
import com.ql.blog.interaction.web.article.model.ArticleCreateCommand;
import com.ql.blog.interaction.web.article.model.ArticleDelCommand;
import com.ql.blog.interaction.web.article.model.ArticleUpdateCommand;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 文章命令服务impl
 *
 * @author wanqiuli
 * @date 2022/11/04
 */
@Service
public class ArticleCommandServiceImpl implements ArticleCommandService {

    @Resource
    private ArticleManager articleManager;
    @Resource
    private ArticleRepository articleRepository;

    @Override
    public Result<Void> createArticle(ArticleCreateCommand command) {
        // 创建文章
        Article article = ArticleFactory.createArticle(command);

        // 初始化
        article.init(command.getSysCode());

        // 持久化
        articleManager.save(article);
        return Result.suc();
    }

    @Override
    public Result<Void> updateArticle(ArticleUpdateCommand command) {
        // 查询文章
        Article article = articleRepository.findArticleById(command.getId());
        Asserts.notNull(article, "文章丢失了，无法更新");

        // 更新
        Article update = ArticleFactory.createArticle(command);
        article.updateArticle(update);

        // 持久化
        articleManager.update(article);
        return Result.suc();
    }

    @Override
    public Result<Void> delArticle(ArticleDelCommand command) {
        // 查询
        Article article = articleRepository.findArticleById(command.getId());
        Asserts.notNull(article, "文章已删除");

        // 删除
        articleManager.del(article);
        return Result.suc();
    }
}
