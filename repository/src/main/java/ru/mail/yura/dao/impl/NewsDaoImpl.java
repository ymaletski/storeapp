package ru.mail.yura.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ru.mail.yura.dao.NewsDao;
import ru.mail.yura.model.News;

@Repository("newsDao")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class NewsDaoImpl implements NewsDao {

	@PersistenceContext
	private EntityManager em;
	
	@Transactional(readOnly = true)
	@Override
	public List<News> findAll() {
		List<News> news = em.createNamedQuery("News.findAll", News.class).getResultList();
		return news;
	}
	
	@Transactional(readOnly = true)
	@Override
	public List<News> findAllWithDetails() {
		List<News> news = em.createNamedQuery("News.findAllWithDetails", News.class).getResultList();
		return news;
	}
	
	@Transactional(readOnly = true)
	@Override
	public News findById(Long id) {
		TypedQuery<News> query = em.createNamedQuery("News.findById", News.class);
		query.setParameter("id", id);
		return query.getSingleResult();
	}
	
	@Transactional(readOnly = true)
	@Override
	public News findByIdWithDetails(Long id) {
		TypedQuery<News> query = em.createNamedQuery("News.findByIdWithDetails", News.class);
		query.setParameter("id", id);
		return query.getSingleResult();
	}

	@Override
	public News save(News news) {
		if(news.getId() == null) {
			em.persist(news);
		} else {
			em.merge(news);
		}
		return news;
	}

	@Override
	public void delete(News news) {
		News mergedNews = em.merge(news);
		em.remove(mergedNews);		
	}

}
