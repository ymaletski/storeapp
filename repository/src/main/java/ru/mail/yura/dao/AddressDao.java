package ru.mail.yura.dao;

import java.util.List;
import ru.mail.yura.model.Address;

public interface AddressDao extends GenericDao<Address, Long> {
	List<Address> findAll();
	List<Address> findAllWithDetails();
	Address findById(Long id);
	Address findByIdWithDetails(Long id);
	Address save(Address address);
}
