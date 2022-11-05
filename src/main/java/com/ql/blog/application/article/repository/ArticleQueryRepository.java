package com.ql.blog.application.article.repository;

import com.github.pagehelper.PageInfo;
import com.ql.blog.interaction.web.article.model.ArticleDto;
import com.ql.blog.interaction.web.article.model.ArticlePageCondition;
import com.ql.blog.interaction.web.article.model.ArticlePageDto;

/**
 * 文章查询库
 *
 * @author wanqiuli
 * @date 2022/11/05
 */
public interface ArticleQueryRepository {
     /**
      * 找到页面列表
      *
      * @param condition 条件
      * @return {@link PageInfo}
      */
     @SuppressWarnings({"rawtypes"})
     PageInfo findPageList(ArticlePageCondition condition);

     /**
      * 找到文章id
      *
      * @param id id
      * @return {@link ArticleDto}
      */
     ArticleDto findArticleById(Long id);
}
