/**
 * Copyright (c) 2012 Sohu. All Rights Reserved
 */
/**
 * @title: TimestampConverter.java
 * @package com.sohu.tv.digg.converter
 * @description: TODO(用一句话描述该文件做什么)
 * @author anzengli (anzengli@sohu-inc.com)
 * @date 2016-9-23 下午2:29:20
 * @version V1.0
 *
 */
package com.sohu.tv.digg.converter;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

/**
 * @className: TimestampConverter
 * @description: TODO(这里用一句话描述这个类的作用)
 * @author anzengli (anzengli@sohu-inc.com)
 * @date 2016-9-23 下午2:29:20
 * @version V1.0
 *
 */
public class TimestampConverter implements Converter<Date, Timestamp>{

    @Override
    public Timestamp convert(Date date) {
        if(date != null){
            return new Timestamp(date.getTime());
        }
        return null;
    }

}