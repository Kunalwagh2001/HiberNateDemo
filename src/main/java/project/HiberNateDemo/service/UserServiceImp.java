package project.HiberNateDemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import project.HiberNateDemo.entites.User;
import project.HiberNateDemo.repository.UserRepository;

@Service
public class UserServiceImp implements UserService{

	@Autowired
	UserRepository UsSer;
	
	@Override
	public List<User> getAllUser() {
		return UsSer.findAll();
	}
	
	@Override
	public User getEmployeeById(int id) {
		 return UsSer.findById(id).orElseThrow(() -> new NullPointerException("No User found with ID "+id));
	}

	@Override
	public User addUser(User us) {
		return UsSer.save(us);
	}

	@Override
	public Object modifyUser(User us , int id) {
		User Existingemp = UsSer.findById(id)
				.orElseThrow(() -> new NullPointerException("No Employee with This" + id + " Id"));
		Existingemp.setCity(us.getCity());
		Existingemp.setName(us.getName());
		return UsSer.save(Existingemp);

	}

	@Override
	public void deleteUser(int id) {
		// TODO Auto-generated method stub
		User Existingemp = UsSer.findById(id)
				.orElseThrow(() -> new NullPointerException("No Employee with This" + id + " Id"));
		UsSer.delete(Existingemp);

	}

	

}
