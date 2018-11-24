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
		// TODO �Զ����ɵĹ��캯�����
		super(hashMap);
	}

	@Override
	public V put(K key, V value) {
		// TODO �Զ����ɵķ������
		synchronized (obj) {
			return super.put(key, value);
		}
	}
	
	
	@Override
	public V get(Object key) {
		// TODO �Զ����ɵķ������
		synchronized (obj){
			return super.get(key);
		}
	}
	
	@Override
	public V remove(Object key) {
		// TODO �Զ����ɵķ������
		synchronized (obj){
			return super.remove(key);
		}
	}
	
	@Override
	public int size() {
		// TODO �Զ����ɵķ������
		synchronized (obj){
			return super.size();
		}
	}
}
