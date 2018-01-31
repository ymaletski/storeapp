package ru.mail.yura.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ru.mail.yura.dao.AddressDao;
import ru.mail.yura.model.Address;

@Repository("addressDao")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class AddressDaoImpl implements AddressDao {

	@PersistenceContext
	private EntityManager em;
	
	@Transactional(readOnly = true)
	@Override
	public List<Address> findAll() {
		List<Address> addresses = em.createNamedQuery("Address.findAll", Address.class).getResultList();
		return addresses;
	}
	
	@Transactional(readOnly = true)
	@Override
	public List<Address> findAllWithDetails() {
		List<Address> addresses = em.createNamedQuery("Address.findAllWithDetails", Address.class).getResultList();
		return addresses;
	}

	@Transactional(readOnly = true)
	@Override
	public Address findById(Long id) {
		TypedQuery<Address> query = em.createNamedQuery("Address.findById", Address.class);
		query.setParameter("id", id);
		return query.getSingleResult();
	}
	
	@Transactional(readOnly = true)
	@Override
	public Address findByIdWithDetails(Long id) {
		TypedQuery<Address> query = em.createNamedQuery("Address.findByIdWithDetails", Address.class);
		query.setParameter("id", id);
		return query.getSingleResult();
	}

	@Override
	public Address save(Address address) {
		if(address.getId() == null) {
			em.persist(address);
		} else {
			em.merge(address);
		}
		return address;
	}

}
