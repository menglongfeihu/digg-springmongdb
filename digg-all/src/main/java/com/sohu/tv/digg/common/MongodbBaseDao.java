/**
 * Copyright (c) 2012 Sohu. All Rights Reserved
 */
/**
 * @title: MongodbBaseDao.java
 * @package com.sohu.tv.digg.common
 * @description: TODO(用一句话描述该文件做什么)
 * @author anzengli (anzengli@sohu-inc.com)
 * @date 2016-9-22 下午5:15:34
 * @version V1.0
 *
 */
package com.sohu.tv.digg.common;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.sohu.tv.digg.vote.model.StoredId;


/**
 * @className: MongodbBaseDao
 * @description: TODO(这里用一句话描述这个类的作用)
 * @author anzengli (anzengli@sohu-inc.com)
 * @date 2016-9-22 下午5:15:34
 * @version V1.0
 *
 */
public abstract class MongodbBaseDao<T> {

    private Class<T> clazz;

    /**
     * spring mongodb　集成操作类
     */
    @Resource
    protected MongoTemplate mongoTemplate;

    /**
     * 注入mongodbTemplate
     * @param mongoTemplate
     */
    public void setMongoTemplate(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }



    /**
     * 通过条件查询更新数据
     * @param query
     * @param update
     * @return
     */
    public void update(Query query, Update update) {
        mongoTemplate.findAndModify(query, update, this.getEntityClass());
    }

    /**
     * 保存一个对象到mongodb
     * @param entity
     * @return
     */
    public T save(T entity) {
        mongoTemplate.insert(entity);
        return entity;
    }

    /**
     * 通过条件删除数据
     * @param query
     * @return
     */
    public void remove(Query query) {
        mongoTemplate.remove(query, this.getEntityClass());
    }

    /**
     * 通过条件查询实体(集合)
     * @param query
     */
    public List<T> find(Query query) {
        return mongoTemplate.find(query, this.getEntityClass());
    }

    /**
     * 通过一定的条件查询一个实体
     * @param query
     * @return
     */
    public T findOne(Query query) {
        return mongoTemplate.findOne(query, this.getEntityClass());
    }

    /**
     * 通过ID获取记录
     * @param id
     * @return
     */
    public T findById(String id) {
        return mongoTemplate.findById(id, this.getEntityClass());
    }

    /**
     * 通过ID获取记录,并且指定了集合名(表的意思)
     * @param id
     * @param collectionName  集合名
     * @return
     */
    public T findById(String id, String collectionName) {
        return mongoTemplate.findById(id, this.getEntityClass(), collectionName);
    }

    public T findAndModify(Query query, Update update, FindAndModifyOptions options) {
        return mongoTemplate.findAndModify(query, update, options, this.getEntityClass());
    }

    /**
     * 求数据总和
     * @param query
     * @return
     */
    public long count(Query query){
        return mongoTemplate.count(query, this.getEntityClass());
    }


    /**
     * 获取需要操作的实体类class
     * @return
     */
    @SuppressWarnings("unchecked")
    protected  Class<T> getEntityClass(){
        if (clazz == null) {
            clazz = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        }
        return clazz;
    }

    public Long getClassId(String collName) {
        Query query = new Query(Criteria.where("_id").is(collName));
        Update update = new Update();
        update.inc("value", 1);
        FindAndModifyOptions options = new FindAndModifyOptions();
        options.returnNew(true);
        StoredId storedId = mongoTemplate.findAndModify(query, update, options, StoredId.class);
        if (storedId == null) {
            storedId = new StoredId(collName, 1L);
            this.mongoTemplate.save(storedId);
        }
        return storedId.getSeq();
    }


}
