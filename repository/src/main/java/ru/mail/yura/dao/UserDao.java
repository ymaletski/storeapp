package ru.mail.yura.dao;

import java.util.List;
import ru.mail.yura.model.User;

public interface UserDao extends GenericDao<User, Long> {
	List<User> findAll();
	List<User> findAllWithDetails();
	User findById(Long id);
	User findByIdWithDetails(Long id);
	User save(User user);
	void softDelete(User user);
}
