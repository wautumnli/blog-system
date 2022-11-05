package com.ql.blog.interaction.web.article.model;

import com.ql.blog.base.mark.Command;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * 文章删除命令条
 *
 * @author wanqiuli
 * @date 2022/11/04
 */
@Data
public class ArticleDelCommand implements Command {

    /**
     * id
     */
    @NotNull(message = "文章号为空")
    private Long id;
}
