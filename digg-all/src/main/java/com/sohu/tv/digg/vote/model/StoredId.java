/**
 * Copyright (c) 2012 Sohu. All Rights Reserved
 */
/**
 * @title: StoredId.java
 * @package com.sohu.tv.digg.vote.model
 * @description: TODO(用一句话描述该文件做什么)
 * @author anzengli (anzengli@sohu-inc.com)
 * @date 2016-9-22 下午3:32:23
 * @version V1.0
 *
 */
package com.sohu.tv.digg.vote.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @className: StoredId
 * @description: TODO(这里用一句话描述这个类的作用)
 * @author anzengli (anzengli@sohu-inc.com)
 * @date 2016-9-22 下午3:32:23
 * @version V1.0
 *
 */
@Document(collection = "ids")
public class StoredId implements Serializable {

    private static final long serialVersionUID = 7085290604080612075L;
    @Id
    private  String className = "";
    private  Long seq = 0L;

    public StoredId(String className, Long seq) {
        this.className = className;
        this.seq = seq;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Long getSeq() {
        return seq;
    }

    public void setSeq(Long seq) {
        this.seq = seq;
    }

    @Override
    public String toString() {
        return "StoredId [className=" + className + ", seq=" + seq + "]";
    }
}
