package com.ql.blog.infrastructure.db.respository;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ql.blog.application.article.repository.ArticleQueryRepository;
import com.ql.blog.infrastructure.db.dao.ArticleContentDao;
import com.ql.blog.infrastructure.db.dao.ArticleDao;
import com.ql.blog.infrastructure.db.mapper.ArticleMapper;
import com.ql.blog.infrastructure.db.model.ArticleContentPo;
import com.ql.blog.infrastructure.db.model.ArticlePo;
import com.ql.blog.interaction.web.article.model.ArticleContentDto;
import com.ql.blog.interaction.web.article.model.ArticleDto;
import com.ql.blog.interaction.web.article.model.ArticlePageCondition;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * 文章查询库impl
 *
 * @author wanqiuli
 * @date 2022/11/05
 */
@Repository
public class ArticleQueryRepositoryImpl implements ArticleQueryRepository {

    @Resource
    private ArticleDao articleDao;
    @Resource
    private ArticleContentDao articleContentDao;

    @Override
    @SuppressWarnings({"unchecked", "rawtypes"})
    public PageInfo findPageList(ArticlePageCondition condition) {
        // 开启分页
        PageHelper.startPage(condition.getPageIndex(), condition.getPageSize());

        // 查询
        List<ArticlePo> articlePoList = articleDao.selectList(Wrappers.<ArticlePo>lambdaQuery()
                .eq(StrUtil.isNotBlank(condition.getArticleName()), ArticlePo::getArticleName, condition.getArticleName()));
        PageInfo pageInfo = new PageInfo<>(articlePoList);
        pageInfo.setList(ArticleMapper.MAPPER.toPageDto(articlePoList));
        return pageInfo;
    }

    @Override
    public ArticleDto findArticleById(Long id) {
        ArticlePo articlePo = articleDao.selectById(id);
        if (articlePo == null) {
            return null;
        }
        ArticleDto articleDto = ArticleMapper.MAPPER.toDto(articlePo);

        ArticleContentPo articleContentPo = articleContentDao.selectById(articleDto.getContentId());
        if (articleContentPo == null) {
            return articleDto;
        }
        ArticleContentDto articleContentDto = ArticleMapper.MAPPER.toDto(articleContentPo);
        articleContentDto.setContent(new String(articleContentPo.getContent()));
        articleDto.setArticleContentDto(articleContentDto);
        return articleDto;
    }
}
