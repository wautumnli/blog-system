package com.ql.blog.interaction.web.article.model;

import com.ql.blog.base.mark.Command;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 文章更新命令
 *
 * @author wanqiuli
 * @date 2022/11/04
 */
@Data
public class ArticleUpdateCommand implements Command {


    /**
     * id
     */
    @NotNull(message = "文章idb")
    private Long id;
    /**
     * 用户id
     */
    @NotNull(message = "用户id不能为空")
    private String userId;
    /**
     * 文章名字
     */
    @NotBlank(message = "文章名不能为空")
    private String articleName;
    /**
     * 文章内容
     */
    @NotBlank(message = "文章内容不能为空")
    private String content;
    /**
     * 操作用户
     */
    @NotBlank(message = "用户名不能为空")
    private String sysCode;
}
