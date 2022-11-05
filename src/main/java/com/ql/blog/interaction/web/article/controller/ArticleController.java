package com.ql.blog.interaction.web.article.controller;

import com.github.pagehelper.PageInfo;
import com.ql.blog.application.article.ArticleCommandService;
import com.ql.blog.application.article.ArticleQueryService;
import com.ql.blog.base.result.Result;
import com.ql.blog.interaction.web.article.model.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * 文章控制器
 *
 * @author wanqiuli
 * @date 2022/11/04
 */
@Api("文章控制器")
@RestController("/article")
public class ArticleController {

    @Resource
    private ArticleCommandService articleCommandService;
    @Resource
    private ArticleQueryService articleQueryService;

    /**
     * 创建文章
     *
     * @param command 命令
     * @return {@link Result}
     */
    @PostMapping("/createArticle")
    @ApiOperation(value = "创建文章")
    public Result<Void> createArticle(@RequestBody @Valid ArticleCreateCommand command) {
        return articleCommandService.createArticle(command);
    }

    /**
     * 更新文章
     *
     * @param command 命令
     * @return {@link Result}
     */
    @PostMapping("/updateArticle")
    @ApiOperation(value = "更新文章")
    public Result<Void> updateArticle(@RequestBody @Valid ArticleUpdateCommand command) {
        return articleCommandService.updateArticle(command);
    }

    /**
     * 删除文章
     *
     * @param command 命令
     * @return {@link Result}
     */
    @PostMapping("/delArticle")
    @ApiOperation(value = "删除文章")
    public Result<Void> delArticle(@RequestBody @Valid ArticleDelCommand command) {
        return articleCommandService.delArticle(command);
    }

    /**
     * 找到页面列表
     *
     * @param condition 条件
     * @return {@link Result}
     */
    @PostMapping("/findPageList")
    @ApiOperation(value = "文章分页查询")
    public Result<PageInfo<ArticlePageDto>> findPageList(@RequestBody @Valid ArticlePageCondition condition) {
        return articleQueryService.findPageList(condition);
    }

    /**
     * 文章内容
     *
     * @param condition 条件
     * @return {@link Result}
     */
    @PostMapping("/articleContent")
    @ApiOperation(value = "查询文章内容")
    public Result<ArticleDto> articleContent(@RequestBody @Valid ArticleContentCondition condition){
        return articleQueryService.articleContent(condition);
    }
}
