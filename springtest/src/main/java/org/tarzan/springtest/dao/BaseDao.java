package org.tarzan.springtest.dao;

import java.io.Serializable;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface BaseDao<T, K extends Serializable> extends PagingAndSortingRepository<T, K> {

}
