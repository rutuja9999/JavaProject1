package com.employee.ifaces;

import java.util.List;

public interface CrudRespository<T> {
	public boolean add(T obj);
	public List<T> findAll() throws Exception;
}
