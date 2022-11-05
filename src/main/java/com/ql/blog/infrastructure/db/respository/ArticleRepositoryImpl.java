package com.ql.blog.infrastructure.db.respository;

import com.ql.blog.base.validate.Asserts;
import com.ql.blog.domain.article.model.Article;
import com.ql.blog.domain.article.model.ArticleContent;
import com.ql.blog.domain.article.repository.ArticleRepository;
import com.ql.blog.infrastructure.db.dao.ArticleContentDao;
import com.ql.blog.infrastructure.db.dao.ArticleDao;
import com.ql.blog.infrastructure.db.mapper.ArticleMapper;
import com.ql.blog.infrastructure.db.model.ArticleContentPo;
import com.ql.blog.infrastructure.db.model.ArticlePo;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.nio.charset.StandardCharsets;

/**
 * 文章库impl
 *
 * @author wanqiuli
 * @date 2022/11/04
 */
@Repository
public class ArticleRepositoryImpl implements ArticleRepository {
    @Resource
    private ArticleDao articleDao;
    @Resource
    private ArticleContentDao articleContentDao;

    @Override
    public void save(Article article) {
        ArticleContent articleContent = article.getArticleContent();
        ArticleContentPo articleContentPo = ArticleMapper.MAPPER.toPo(articleContent);
        articleContentPo.setContent(articleContent.getContent().getBytes(StandardCharsets.UTF_8));
        int save = articleContentDao.insert(articleContentPo);
        if (save == 0) {
            Asserts.of();
        }

        article.setContentId(articleContentPo.getId());
        saveArticle(article);
    }

    @Override
    public Article findArticleById(Long id) {
        ArticlePo articlePo = articleDao.selectById(id);
        if (articlePo == null) {
            return null;
        }
        Article article = ArticleMapper.MAPPER.toEntity(articlePo);
        ArticleContentPo articleContentPo = articleContentDao.selectById(article.getContentId());
        ArticleContent articleContent = ArticleMapper.MAPPER.toEntity(articleContentPo);
        articleContent.setContent(new String(articleContentPo.getContent()));
        return article.setArticleContent(articleContent);
    }

    @Override
    public void update(Article article) {
        ArticleContentPo articleContentPo = ArticleMapper.MAPPER.toPo(article.getArticleContent());
        articleContentPo.setContent(article.getArticleContent().getContent().getBytes(StandardCharsets.UTF_8));
        int update = articleContentDao.updateById(articleContentPo);
        if (update == 0) {
            Asserts.of();
        }

        ArticlePo articlePo = ArticleMapper.MAPPER.toPo(article);
        update = articleDao.updateById(articlePo);
        if (update == 0) {
            Asserts.of();
        }
    }

    @Override
    public void del(Article article) {
        articleDao.deleteById(article.getId());
        articleContentDao.deleteById(article.getContentId());
    }

    private void saveArticle(Article article) {
        ArticlePo articlePo = ArticleMapper.MAPPER.toPo(article);
        int insert = articleDao.insert(articlePo);
        if (insert == 0) {
            Asserts.of();
        }
    }
}
