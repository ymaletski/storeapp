package ru.mail.yura.dao;

import java.util.List;

import ru.mail.yura.model.Goods;

public interface GoodsDao extends GenericDao<Goods, Long> {
	List<Goods> findAll();
	Goods findById(Long id);
	Goods save(Goods goods);
	void softDelete(Goods goods);
}
