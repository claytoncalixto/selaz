package br.com.claytoncalixto.todolist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.claytoncalixto.todolist.entities.User;
import br.com.claytoncalixto.todolist.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Transactional(readOnly = true)
	public List<User> findAll(){
		return userRepository.findAll();
	}

}
