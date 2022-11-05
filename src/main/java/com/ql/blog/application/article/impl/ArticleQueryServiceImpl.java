package com.ql.blog.application.article.impl;

import cn.hutool.core.collection.CollUtil;
import com.github.pagehelper.PageInfo;
import com.ql.blog.application.article.ArticleQueryService;
import com.ql.blog.application.article.repository.ArticleQueryRepository;
import com.ql.blog.application.user.respository.UserQueryRepository;
import com.ql.blog.base.result.Result;
import com.ql.blog.interaction.web.article.model.ArticleContentCondition;
import com.ql.blog.interaction.web.article.model.ArticleDto;
import com.ql.blog.interaction.web.article.model.ArticlePageCondition;
import com.ql.blog.interaction.web.article.model.ArticlePageDto;
import com.ql.blog.interaction.web.user.model.UserDto;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 文章查询服务impl
 *
 * @author wanqiuli
 * @date 2022/11/05
 */
@Service
public class ArticleQueryServiceImpl implements ArticleQueryService {

    @Resource
    private ArticleQueryRepository articleQueryRepository;
    @Resource
    private UserQueryRepository userQueryRepository;

    @Override
    @SuppressWarnings({"rawtypes", "unchecked"})
    public Result<PageInfo<ArticlePageDto>> findPageList(ArticlePageCondition condition) {
        // 分页查询
        PageInfo pageInfo = articleQueryRepository.findPageList(condition);
        List<ArticlePageDto> result = (List<ArticlePageDto>) pageInfo.getList();
        if (CollUtil.isEmpty(result)) {
            return Result.suc(pageInfo);
        }

        // 用户id集合
        List<Long> userIdList = result
                .stream()
                .map(ArticlePageDto::getUserId)
                .distinct()
                .collect(Collectors.toList());
        // 填充用户名
        List<UserDto> userDtoList = userQueryRepository.findUserByIdList(userIdList);
        Map<Long, String> userMap = userDtoList
                .stream()
                .collect(Collectors.toMap(UserDto::getId, UserDto::getUsername, (o, n) -> o));
        result.forEach(item -> item.setUsername(userMap.get(item.getUserId())));
        return Result.suc(pageInfo);
    }

    @Override
    public Result<ArticleDto> articleContent(ArticleContentCondition condition) {
        ArticleDto articleDto = articleQueryRepository.findArticleById(condition.getId());
        return Result.suc(articleDto);
    }
}
