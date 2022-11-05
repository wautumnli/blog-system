package com.ql.blog.application.article.manager.impl;

import com.ql.blog.application.article.manager.ArticleManager;
import com.ql.blog.domain.article.model.Article;
import com.ql.blog.domain.article.repository.ArticleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 文章管理实现
 *
 * @author wanqiuli
 * @date 2022/11/04
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ArticleManagerImpl implements ArticleManager {

    @Resource
    private ArticleRepository articleRepository;

    @Override
    public void save(Article article) {
        articleRepository.save(article);
    }

    @Override
    public void update(Article article) {
        articleRepository.update(article);
    }

    @Override
    public void del(Article article) {
        articleRepository.del(article);
    }
}
