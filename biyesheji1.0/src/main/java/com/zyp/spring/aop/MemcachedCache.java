package com.zyp.spring.aop;

import net.rubyeye.xmemcached.MemcachedClient;

import org.springframework.cache.Cache;
import org.springframework.cache.support.SimpleValueWrapper;

public class MemcachedCache implements Cache {
	  private final String name;  
	    private final MemcachedClient memcachedClient;  
	    private final MemCache memCache;  
	      
	    public MemcachedCache(String name, int expire, MemcachedClient memcachedClient)  
	    {  
	        this.name = name;  
	        this.memcachedClient = memcachedClient;   
	        this.memCache = new MemCache(name, expire, memcachedClient);  
	    }  
	  
	    @Override  
	    public void clear()  
	    {  
	        memCache.clear();  
	    }  
	  
	    @Override  
	    public void evict(Object key)  
	    {  
	        memCache.delete(key.toString());  
	    }  
	  
	    @Override  
	    public ValueWrapper get(Object key)  
	    {  
	        ValueWrapper wrapper = null;  
	        Object value = memCache.get(key.toString());  
	        if (value != null)  
	        {  
	            wrapper = new SimpleValueWrapper(value);  
	        }  
	        return wrapper;  
	    }  
	  
	    @Override  
	    public String getName()  
	    {  
	        return this.name;  
	    }  
	  
	    @Override  
	    public MemcachedClient getNativeCache()  
	    {  
	        return this.memcachedClient;  
	    }  
	  
	    @Override  
	    public void put(Object key, Object value)  
	    {  
	        memCache.put(key.toString(), value);  
	    } 
}
