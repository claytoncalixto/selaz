package br.com.claytoncalixto.todolist.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.claytoncalixto.todolist.dto.TaskDTO;
import br.com.claytoncalixto.todolist.entities.Task;
import br.com.claytoncalixto.todolist.repositories.TaskRepository;
import br.com.claytoncalixto.todolist.services.exceptions.DatabaseException;
import br.com.claytoncalixto.todolist.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;

@Service
public class TaskService {
	
	@Autowired
	private TaskRepository taskRepository;
	
	@Transactional(readOnly = true)
	public List<TaskDTO> findAll() {
		List<Task> list = taskRepository.findAll();		
		return list.stream().map(x -> new TaskDTO(x)).collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public TaskDTO findById(Long id) {
		Optional<Task> obj = taskRepository.findById(id);
		Task entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		return new TaskDTO(entity);
	}

	@Transactional
	public TaskDTO insert(TaskDTO dto) {
		Task entity = new Task();
		entity.setCreatedAT(dto.getCreatedAT());
		entity.setDueDate(dto.getDueDate());
		entity.setDescription(dto.getDescription());
		entity.setStatus(dto.getStatus());
		entity.setTitle(dto.getTitle());
		entity = taskRepository.save(entity);
		return new TaskDTO(entity);
	}

	@Transactional
	public TaskDTO update(Long id, TaskDTO dto) {
		try {
			Task entity = taskRepository.getReferenceById(id);
			entity.setCreatedAT(dto.getCreatedAT());
			entity.setDueDate(dto.getDueDate());
			entity.setDescription(dto.getDescription());
			entity.setStatus(dto.getStatus());
			entity.setTitle(dto.getTitle());
			entity = taskRepository.save(entity);
			return new TaskDTO(entity);
		}catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id not found:"+ id); 
		}
	}

	public void delete(Long id) {
		try {
		taskRepository.deleteById(id);
		}
		catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Id not found:" + id); 
		}
		catch (DataIntegrityViolationException e) {
			throw new DatabaseException("Integrety violation");
		}
		
	}
}
