package project.HiberNateDemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project.HiberNateDemo.entites.User;
import project.HiberNateDemo.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	public  UserService UsSer;

	@GetMapping("/users")
	List<User> getAllUser() {
		return UsSer.getAllUser();
	}
	
	@GetMapping("/users/{id}")
	public User getEmployeeById(@PathVariable int id) {
		return UsSer.getEmployeeById(id);
	}
	
	

	@PostMapping("/users")
	public User addNewEmployee(@RequestBody User us) {
		return UsSer.addUser(us);
	}

	@PutMapping("/users/{id}")
	public ResponseEntity<Object> updateExistingEmployee(@PathVariable(value = "id") int id,@RequestBody User us) {
		return ResponseEntity.ok(UsSer.modifyUser(us, id));
	}

	@DeleteMapping("/{id}")
	public String DeleteExistingEmployee(@PathVariable(value = "id") int id) {
		UsSer.deleteUser(id);
		return "Employee Deleted";
	}
}


