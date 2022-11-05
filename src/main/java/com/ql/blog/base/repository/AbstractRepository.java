package com.ql.blog.base.repository;

import cn.hutool.core.util.StrUtil;
import com.ql.blog.base.entity.BaseAggregateRoot;
import com.ql.blog.base.entity.BaseEntity;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

/**
 * 抽象库
 *
 * @author wanqiuli
 * @date 2022/11/05
 */
@SuppressWarnings({"rawtypes"})
public abstract class AbstractRepository implements BaseRepository {

    private static final Map<String, Function> INSERT_MAP = new HashMap<>();
    private static final Map<String, Function> UPDATE_MAP = new HashMap<>();
    private static final Map<String, Function> DELETE_MAP = new HashMap<>();


    protected void register(String className, Function insert, Function update, Function delete) {
        if (StrUtil.isBlank(className)) {
            return;
        }

        // 添加方法
        Optional.ofNullable(insert)
                .ifPresent(function -> INSERT_MAP.putIfAbsent(className, function));
        Optional.ofNullable(update)
                .ifPresent(function -> UPDATE_MAP.putIfAbsent(className, function));
        Optional.ofNullable(delete)
                .ifPresent(function -> DELETE_MAP.putIfAbsent(className, function));
    }

    @Override
    @SuppressWarnings({"unchecked"})
    public void save(BaseAggregateRoot baseAggregateRoot) {
        Map<Integer, BaseEntity> operationMap = baseAggregateRoot.getInsertMap();

        // 新增
        Optional.ofNullable(operationMap)
                .ifPresent(map -> map.values().forEach(entity -> {
                    Function function = INSERT_MAP.get(entity.getClass().getName());
                    if (function != null) {
                        function.apply(entity);
                    }
                }));

        operationMap = baseAggregateRoot.getUpdateMap();
        // 更新
        Optional.ofNullable(operationMap)
                .ifPresent(map -> map.values().forEach(entity -> {
                    Function function = UPDATE_MAP.get(entity.getClass().getName());
                    if (function != null) {
                        function.apply(entity);
                    }
                }));

        operationMap = baseAggregateRoot.getDeleteMap();
        // 删除
        Optional.ofNullable(operationMap)
                .ifPresent(map -> map.values().forEach(entity -> {
                    Function function = DELETE_MAP.get(entity.getClass().getName());
                    if (function != null) {
                        function.apply(entity);
                    }
                }));
    }
}
