/*
 * Copyright (c) 2012 Sohu. All Rights Reserved
 */
package com.sohu.tv.digg.common;

import com.sohu.cache.service.Cache;

/**
 * <p>
 * Description:
 * </p>
 *
 * @author Tony Wei
 * @version 1.0
 * @Date Aug 26, 2013
 */
public class ReflectService {

    private Cache localCache;

    public void cleanLocalcahe(byte[] message) {
        String msg = new String(message);
        localCache.remove(msg);
    }

    public void setLocalCache(Cache localCache) {
        this.localCache = localCache;
    }

    public Cache getLocalCache() {
        return localCache;
    }

}
