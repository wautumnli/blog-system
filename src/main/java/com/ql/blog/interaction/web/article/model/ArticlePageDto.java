package com.ql.blog.interaction.web.article.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 文章页面dto
 *
 * @author wanqiuli
 * @date 2022/11/05
 */
@Data
@ApiModel("文章分页对象")
public class ArticlePageDto {
    @ApiModelProperty("文章id")
    private Long id;
    @ApiModelProperty("文章名")
    private String articleName;
    @ApiModelProperty("用户名")
    private String username;
    @ApiModelProperty("用户id")
    private Long userId;
}
