package com.ql.blog.base.entity;

import java.util.HashMap;
import java.util.Map;

/**
 * 基地总根
 *
 * @author wanqiuli
 * @date 2022/11/04
 */
public abstract class BaseAggregateRoot extends BaseEntity {

    private Map<Integer, BaseEntity> insertMap;
    private Map<Integer, BaseEntity> updateMap;
    private Map<Integer, BaseEntity> deleteMap;


    public void save(BaseEntity baseEntity) {
        if (insertMap == null) {
            insertMap = new HashMap<>();
        }
        insertMap.put(System.identityHashCode(baseEntity), baseEntity);
    }

    public void update(BaseEntity baseEntity) {
        if (updateMap == null) {
            updateMap = new HashMap<>();
        }
        updateMap.put(System.identityHashCode(baseEntity), baseEntity);
    }

    public void delete(BaseEntity baseEntity) {
        if (deleteMap == null) {
            deleteMap = new HashMap<>();
        }
        deleteMap.put(System.identityHashCode(baseEntity), baseEntity);
    }

    public Map<Integer, BaseEntity> getInsertMap() {
        return this.insertMap;
    }

    public Map<Integer, BaseEntity> getUpdateMap() {
        return this.updateMap;
    }

    public Map<Integer, BaseEntity> getDeleteMap() {
        return this.deleteMap;
    }
}
