package com.ql.blog.infrastructure.db.mapper;

import com.ql.blog.domain.article.model.Article;
import com.ql.blog.domain.article.model.ArticleContent;
import com.ql.blog.infrastructure.db.model.ArticleContentPo;
import com.ql.blog.infrastructure.db.model.ArticlePo;
import com.ql.blog.interaction.web.article.model.ArticleContentDto;
import com.ql.blog.interaction.web.article.model.ArticleDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 文章映射器
 *
 * @author wanqiuli
 * @date 2022/11/04
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ArticleMapper {

    ArticleMapper MAPPER = Mappers.getMapper(ArticleMapper.class);

    /**
     * 持久化对象
     *
     * @param article 文章
     * @return {@link ArticlePo}
     */
    ArticlePo toPo(Article article);

    /**
     * 持久化对象
     *
     * @param articleContent 文章内容
     * @return {@link ArticleContentPo}
     */
    @Mapping(target = "content", ignore = true)
    ArticleContentPo toPo(ArticleContent articleContent);

    /**
     * 实体
     *
     * @param articlePo 持久化对象
     * @return {@link Article}
     */
    Article toEntity(ArticlePo articlePo);

    /**
     * 实体
     *
     * @param articleContentPo 文章内容持久化对象
     * @return {@link Article}
     */
    @Mapping(target = "content", ignore = true)
    ArticleContent toEntity(ArticleContentPo articleContentPo);

    /**
     * 文章持久化对象集合
     *
     * @param articlePoList 条订单列表
     * @return {@link List}<{@link ArticlePo}>
     */
    List<ArticlePo> poToDto(List<ArticlePo> articlePoList);

    /**
     * 转dto
     *
     * @param articlePo 持久化对象
     * @return {@link ArticleDto}
     */
    ArticleDto toDto(ArticlePo articlePo);

    /**
     * 为dto
     *
     * @param articleContentPo 文章内容持久化对象
     * @return {@link ArticleDto}
     */
    @Mapping(target = "content", ignore = true)
    ArticleContentDto toDto(ArticleContentPo articleContentPo);
}
