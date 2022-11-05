package com.ql.blog.base.repository;

import com.ql.blog.base.entity.BaseAggregateRoot;

/**
 * 基础库
 *
 * @author wanqiuli
 * @date 2022/11/05
 */
public interface BaseRepository {

    /**
     * 保存
     *
     * @param baseAggregateRoot 基地总根
     */
    void save(BaseAggregateRoot baseAggregateRoot);
}
