package com.ql.blog.interaction.web.article.model;

import com.ql.blog.base.mark.Condition;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * 文章内容条件
 *
 * @author wanqiuli
 * @date 2022/11/05
 */
@Data
@ApiModel(value = "文章内容查询条件")
public class ArticleContentCondition implements Condition {

    @ApiModelProperty(value = "文章id")
    @NotNull(message = "文章id不能为空")
    private Long id;
}
