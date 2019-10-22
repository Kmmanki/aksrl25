package org.kakarrot.dao;

import java.util.List;

import org.kakarrot.dto.Paging;

public interface CrudDAO<V, K> {
	
	public boolean insert(V vo);
	public V selectOne(K key);
	public boolean update(V vo);
	public boolean delete(K key);
	
	public List<V> getList(Paging dto);
	
}
