package com.ql.blog.interaction.web.article.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 文章内容dto
 *
 * @author wanqiuli
 * @date 2022/11/05
 */
@Data
@ApiModel(value = "文章内容")
public class ArticleContentDto {
    @ApiModelProperty(value = "文章内容id")
    private Long id;
    @ApiModelProperty(value = "文章内容")
    private String content;
}
