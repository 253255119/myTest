package com.example.demo.utils;

import io.lettuce.core.RedisURI;
import io.lettuce.core.cluster.RedisClusterClient;
import io.lettuce.core.cluster.api.sync.RedisAdvancedClusterCommands;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author: 25325
 * @Description: redis连接工具
 * @DateTime: 2021-09-12 16:31
 **/
public class RedisUtil {
    public static RedisClusterClient getRedisClusterClient(){
        List<RedisURI> list=new ArrayList<>();
        list.add(RedisURI.create("redis://192.168.188.134:7000"));
        list.add(RedisURI.create("redis://192.168.188.134:7001"));
        list.add(RedisURI.create("redis://192.168.188.134:7002"));
        list.add(RedisURI.create("redis://192.168.188.134:7003"));
        list.add(RedisURI.create("redis://192.168.188.134:7004"));
        list.add(RedisURI.create("redis://192.168.188.134:7005"));
        RedisClusterClient redisClusterClient=  RedisClusterClient.create(list);
        return redisClusterClient;
    }
   public static Object redisGet(String key){
       RedisAdvancedClusterCommands s=getRedisClusterClient().connect().sync();
       Object res=s.get(key);
       getRedisClusterClient().shutdown();
       return  res;
   }
    public static Object redisHget(String key,Object field){
        RedisAdvancedClusterCommands s=getRedisClusterClient().connect().sync();
        Object res=s.hget(key,field);
        getRedisClusterClient().shutdown();
        return  res;
    }
    public static Object redisHset(String key,Object field,Object value){
        RedisAdvancedClusterCommands s=getRedisClusterClient().connect().sync();
        Object res=s.hset(key,field,value);
        getRedisClusterClient().shutdown();
        return  res;
    }
    public static Object redisHgetall(String key){
        RedisAdvancedClusterCommands s=getRedisClusterClient().connect().sync();
        Object res=s.hgetall(key);
        getRedisClusterClient().shutdown();
        return  res;
    }
    public static Object redisH(String key, Map map){
        RedisAdvancedClusterCommands s=getRedisClusterClient().connect().sync();
        Object res=s.hmset(key,map);
        getRedisClusterClient().shutdown();
        return  res;
    }
    public static void main(String[] args) {
        System.out.println(redisGet("aaa"));
    }
}
