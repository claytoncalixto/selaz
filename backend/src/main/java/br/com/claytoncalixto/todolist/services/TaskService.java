package br.com.claytoncalixto.todolist.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.claytoncalixto.todolist.dto.TaskDTO;
import br.com.claytoncalixto.todolist.entities.Task;
import br.com.claytoncalixto.todolist.repositories.TaskRepository;

@Service
public class TaskService {
	
	@Autowired
	private TaskRepository taskRepository;
	
	@Transactional(readOnly = true)
	public List<TaskDTO> findAll() {
		List<Task> list = taskRepository.findAll();		
		return list.stream().map(x -> new TaskDTO(x)).collect(Collectors.toList());
	}

}
