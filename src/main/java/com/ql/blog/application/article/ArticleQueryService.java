package com.ql.blog.application.article;

import com.github.pagehelper.PageInfo;
import com.ql.blog.base.result.Result;
import com.ql.blog.interaction.web.article.model.ArticleContentCondition;
import com.ql.blog.interaction.web.article.model.ArticleDto;
import com.ql.blog.interaction.web.article.model.ArticlePageCondition;
import com.ql.blog.interaction.web.article.model.ArticlePageDto;

/**
 * 文章查询服务
 *
 * @author wanqiuli
 * @date 2022/11/05
 */
public interface ArticleQueryService {
    /**
     * 找到页面列表
     *
     * @param condition 条件
     * @return {@link Result}
     */
    Result<PageInfo<ArticlePageDto>> findPageList(ArticlePageCondition condition);

    /**
     * 文章内容
     *
     * @param condition 条件
     * @return {@link Result}
     */
    Result<ArticleDto> articleContent(ArticleContentCondition condition);
}
