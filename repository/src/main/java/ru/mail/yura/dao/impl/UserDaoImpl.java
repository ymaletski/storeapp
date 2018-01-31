package ru.mail.yura.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ru.mail.yura.dao.UserDao;
import ru.mail.yura.model.User;

@Repository("userDao")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class UserDaoImpl implements UserDao {

	@PersistenceContext
	private EntityManager em;
	
	@Transactional(readOnly = true)
	@Override
	public List<User> findAll() {
		List<User> users = em.createNamedQuery("User.findAll", User.class).getResultList();
		return users;
	}

	@Transactional(readOnly = true)
	@Override
	public List<User> findAllWithDetails() {
		List<User> users = em.createNamedQuery("User.findAllWithDetails", User.class).getResultList();
		return users;
	}

	@Transactional(readOnly = true)
	@Override
	public User findById(Long id) {
		TypedQuery<User> query = em.createNamedQuery("User.findById", User.class);
		query.setParameter("id", id);
		return query.getSingleResult();
	}

	@Transactional(readOnly = true)
	@Override
	public User findByIdWithDetails(Long id) {
		TypedQuery<User> query = em.createNamedQuery("User.findByIdWithDetails", User.class);
		query.setParameter("id", id);
		return query.getSingleResult();
	}
	
	@Override
	public User save(User user) {
		if(user.getId() == null) {
			em.persist(user);
		} else {
			em.merge(user);
		}
		return user;
	}

	@Override
	public void softDelete(User user) {
		Query query = em.createNamedQuery("User.softDelete");
		query.setParameter("id", user.getId());
		query.executeUpdate();
	}
	
}
