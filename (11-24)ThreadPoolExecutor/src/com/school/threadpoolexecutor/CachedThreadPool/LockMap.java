package com.school.threadpoolexecutor.CachedThreadPool;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
 * 
 */
public class LockMap<K, V> extends HashMap<K, V>{
	private volatile Object obj = new Object();
	
	public LockMap(HashMap<K, V> hashMap) {
		// TODO 自动生成的构造函数存根
		super(hashMap);
	}

	@Override
	public V put(K key, V value) {
		// TODO 自动生成的方法存根
		synchronized (obj) {
			return super.put(key, value);
		}
	}
	
	
	@Override
	public V get(Object key) {
		// TODO 自动生成的方法存根
		synchronized (obj){
			return super.get(key);
		}
	}
	
	@Override
	public V remove(Object key) {
		// TODO 自动生成的方法存根
		synchronized (obj){
			return super.remove(key);
		}
	}
	
	@Override
	public int size() {
		// TODO 自动生成的方法存根
		synchronized (obj){
			return super.size();
		}
	}
}
