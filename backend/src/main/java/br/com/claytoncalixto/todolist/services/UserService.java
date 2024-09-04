package br.com.claytoncalixto.todolist.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.claytoncalixto.todolist.dto.UserDTO;
import br.com.claytoncalixto.todolist.entities.User;
import br.com.claytoncalixto.todolist.repositories.UserRepository;
import br.com.claytoncalixto.todolist.services.exceptions.DatabaseException;
import br.com.claytoncalixto.todolist.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Transactional(readOnly = true)
	public List<User> findAll(){
		return userRepository.findAll();
	}
	
	@Transactional(readOnly = true)
	public UserDTO findById(Long id) {
		Optional<User> obj = userRepository.findById(id);
		User entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		return new UserDTO(entity);
	}

	@Transactional
	public UserDTO insert(UserDTO dto) {
		User entity = new User();
		entity.setUsername(dto.getUsername());
		entity.setNivel(dto.getNivel());
		//entity.setTasks(dto.getTasks());
		entity = userRepository.save(entity);
		return new UserDTO(entity);
	}

	@Transactional
	public UserDTO update(Long id, UserDTO dto) {
		try {
			User entity = userRepository.getReferenceById(id);
			entity.setUsername(dto.getUsername());
			entity.setNivel(dto.getNivel());
			//entity.setTasks(dto.getTasks());
			entity = userRepository.save(entity);
			return new UserDTO(entity);
		}catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id not found:"+ id); 
		}
	}

	public void delete(Long id) {
		try {
		userRepository.deleteById(id);
		}
		catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Id not found:" + id); 
		}
		catch (DataIntegrityViolationException e) {
			throw new DatabaseException("Integrety violation");
		}
		
	}

}
