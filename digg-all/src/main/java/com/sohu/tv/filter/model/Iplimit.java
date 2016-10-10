/**
 * Copyright (c) 2012 Sohu. All Rights Reserved
 */
/**
 * @title: Iplimit.java
 * @package com.sohu.tv.filter
 * @description: TODO(用一句话描述该文件做什么)
 * @author anzengli (anzengli@sohu-inc.com)
 * @date 2016-9-23 上午10:38:49
 * @version V1.0
 *
 */
package com.sohu.tv.filter.model;

import java.io.Serializable;

/**
 * @className: Iplimit
 * @description: TODO(这里用一句话描述这个类的作用)
 * @author anzengli (anzengli@sohu-inc.com)
 * @date 2016-9-23 上午10:38:49
 * @version V1.0
 *
 */
public class Iplimit implements Serializable {

    private static final long serialVersionUID = -6113126712235490005L;

    private String model;
    private Long count;
    private String pattern;

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
