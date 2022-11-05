package com.ql.blog.interaction.web.article.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 文章dto
 *
 * @author wanqiuli
 * @date 2022/11/05
 */
@Data
@ApiModel("文章")
public class ArticleDto {
    @ApiModelProperty(value = "文章id")
    private Long id;
    @ApiModelProperty(value = "用户id")
    private Long userId;
    @ApiModelProperty(value = "内容id")
    private Long contentId;
    @ApiModelProperty(value = "文章名")
    private String articleName;
    @ApiModelProperty(value = "文章内容")
    private ArticleContentDto articleContentDto;
}
