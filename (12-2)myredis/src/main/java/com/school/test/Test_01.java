package com.school.test;

import redis.clients.jedis.Jedis;

import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.Set;

public class Test_01 {
    public static void main(String[] args) throws UnsupportedEncodingException {
        Jedis jedis = new Jedis("localhost");
        System.out.println("连接成功");
        // 查看服务是否运行
        System.out.println("服务正在运行: " + jedis.ping());

        jedis.set("name","cai");
        Map<String, String> map = jedis.hgetAll("books");
        System.out.println(map.size());
        for(Map.Entry e:map.entrySet()){
            String str = e.toString();
            byte[] b = str.getBytes("gb2312");
            System.out.println("健:"+new String(b,"gb2312")+" "+"值:"+map.get(e));
        }
    }
}
