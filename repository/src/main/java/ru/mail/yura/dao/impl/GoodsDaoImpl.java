package ru.mail.yura.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ru.mail.yura.dao.GoodsDao;
import ru.mail.yura.model.Goods;

@Repository("goodsDao")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
@Service
public class GoodsDaoImpl implements GoodsDao {

	@PersistenceContext
	private EntityManager em;
	
	@Transactional(readOnly = true)
	@Override
	public List<Goods> findAll() {
		List<Goods> goods = em.createNamedQuery("Goods.findAll", Goods.class).getResultList();
		return goods;
	}

	@Transactional(readOnly = true)
	@Override
	public Goods findById(Long id) {
		TypedQuery<Goods> query = em.createNamedQuery("Goods.findById", Goods.class);
		query.setParameter("id", id);
		return query.getSingleResult();
	}

	@Override
	public Goods save(Goods goods) {
		if(goods.getId() == null) {
			em.persist(goods);
		} else {
			em.merge(goods);
		}
		return goods;
	}

	@Override
	public void softDelete(Goods goods) {
		Query query = em.createNamedQuery("Goods.softDelete");
		query.setParameter("id", goods.getId());
		query.executeUpdate();
	}

}
