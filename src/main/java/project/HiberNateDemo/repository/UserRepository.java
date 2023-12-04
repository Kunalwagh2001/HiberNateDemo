package project.HiberNateDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project.HiberNateDemo.entites.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}
