package ru.mail.yura.dao;

import java.util.List;

import ru.mail.yura.model.News;

public interface NewsDao extends GenericDao<News, Long> {
	List<News> findAll();
	List<News> findAllWithDetails();
	News findById(Long id);
	News findByIdWithDetails(Long id);
	News save(News news);
	void delete(News news);	
}
