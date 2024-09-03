package br.com.claytoncalixto.todolist.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.claytoncalixto.todolist.dto.TaskDTO;
import br.com.claytoncalixto.todolist.entities.Task;
import br.com.claytoncalixto.todolist.repositories.TaskRepository;
import br.com.claytoncalixto.todolist.services.exceptions.EntityNotFounException;

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
		Task entity = obj.orElseThrow(() -> new EntityNotFounException("Entity not found"));
		return new TaskDTO(entity);
	}

}
