package project.HiberNateDemo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import project.HiberNateDemo.entites.User;

@Service
public interface UserService {

	List<User> getAllUser();

	User addUser(User us);

	Object modifyUser(User us , int id);

	void deleteUser(int id);

	User getEmployeeById(int id);

}
