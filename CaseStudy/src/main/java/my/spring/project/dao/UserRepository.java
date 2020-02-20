package my.spring.project.dao;

import org.springframework.data.repository.CrudRepository;

import my.spring.project.pojos.User;

public interface UserRepository extends CrudRepository<User, Integer> {

	

}
