package br.com.claytoncalixto.todolist.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import br.com.claytoncalixto.todolist.entities.Task;
import br.com.claytoncalixto.todolist.entities.User;

public class UserDTO implements Serializable {
	private static final long serialVersionUID = 1L;  
	
	private Long id;
	
	private String username;
	
	private String nivel;
	
	List<TaskDTO>tasks = new ArrayList<>();

	public UserDTO() {
	}

	public UserDTO(Long id, String username, String nivel) {
		this.id = id;
		this.username = username;
		this.nivel = nivel;
	}
	
	public UserDTO(User entity) {
		this.id = entity.getId();
		this.username = entity.getUsername();
		this.nivel = entity.getNivel();
	}
	
	public UserDTO(User entity, Set<Task> task) {
		this(entity);
		task.forEach(tas -> this.tasks.add(new TaskDTO(tas)));
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	public List<TaskDTO> getTasks() {
		return tasks;
	}

	public void setTasks(List<TaskDTO> tasks) {
		this.tasks = tasks;
	}
}
