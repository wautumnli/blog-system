package com.ql.blog.interaction.web.article.model;

import com.ql.blog.base.mark.Condition;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 文章分页查询
 *
 * @author wanqiuli
 * @date 2022/11/05
 */
@Data
@ApiModel(value = "文章分页查询条件")
public class ArticlePageCondition implements Condition {

    @ApiModelProperty(value = "文章名")
    private String articleName;
    @ApiModelProperty(value = "页数")
    private int pageIndex;
    @ApiModelProperty(value = "分页大小")
    private int pageSize;
}
