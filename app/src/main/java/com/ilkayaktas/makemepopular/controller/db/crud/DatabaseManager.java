package com.ilkayaktas.makemepopular.controller.db.crud;

import io.realm.RealmQuery;

import java.util.List;


public interface DatabaseManager<E>{
	void saveOrUpdate(Object obj);
	void saveOrUpdate(Iterable<E> objects);
	void saveOrUpdateAsync(Object object);
	List<Object> getAll(Class clss);
	List<Object> getAll(Class clss, String field, boolean isDescending);
	List<Object> get(Class clss, String fieldName, int equalValue);
	List<Object> get(Class clss, String fieldName, boolean equalValue);
	List<Object> get(Class clss, String fieldName, String equalValue);
	List<Object> get(RealmQuery query);
	void close();
	void delete(Class clss, String fieldName, String equalValue);
	void delete(Class clss, String fieldName, int equalValue);
	void deleteAll(Class clss);
}
