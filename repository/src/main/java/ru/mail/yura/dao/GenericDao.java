package ru.mail.yura.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDao<T extends Serializable, ID extends Number> {
	List<T> findAll();
	T findById(ID id);
	T save(T o);
}
