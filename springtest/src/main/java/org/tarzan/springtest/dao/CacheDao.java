package org.tarzan.springtest.dao;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.redis.core.RedisTemplate;

public abstract class CacheDao<T, K extends Serializable> implements BaseDao<T, K> {
	@Autowired
	BaseDao<T, K> baseDao;

	// @Autowired
	// CacheManager cacheManager;

	@Autowired
	RedisTemplate<K, T> redisTemplate;

	@Override
	public Iterable<T> findAll(Sort arg0) {
		return (Iterable<T>) baseDao.findAll(arg0);
	}

	@Override
	public Page<T> findAll(Pageable arg0) {
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(Serializable arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(T arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Iterable<? extends T> arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean exists(Serializable arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<T> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<T> findAll(Iterable<K> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T findOne(Serializable arg0) {
		T t = redisTemplate.opsForValue().get(arg0);
		if (t != null) {
			return t;
		}
		return baseDao.findOne((K) arg0);
	}

	@Override
	@Cacheable(value = "save", key = "'USER_NAME_'+#args[0]")
	public <S extends T> S save(S arg0) {
		return baseDao.save(arg0);
	}

	@Override
	public <S extends T> Iterable<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

}
