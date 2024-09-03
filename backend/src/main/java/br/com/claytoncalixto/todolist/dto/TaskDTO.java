package br.com.claytoncalixto.todolist.dto;

import java.io.Serializable;
import java.util.Date;

import br.com.claytoncalixto.todolist.entities.Status;
import br.com.claytoncalixto.todolist.entities.Task;

public class TaskDTO implements Serializable {
	private static final long serialVersionUID = 1L; 
	
	private Long id;
	private String title;
	private String description;
	private Date createdAT;
	private Date dueDate;
	private Status status;
	
	public TaskDTO() {
	}

	public TaskDTO(Long id, String title, String description, Date createdAT, Date dueDate, Status status) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.createdAT = createdAT;
		this.dueDate = dueDate;
		this.status = status;
	}
	
	public TaskDTO(Task entity) {
		this.id = entity.getId();
		this.title = entity.getTitle();
		this.description = entity.getDescription();
		this.createdAT = entity.getCreatedAT();
		this.dueDate = entity.getDueDate();
		this.status = entity.getStatus();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreatedAT() {
		return createdAT;
	}

	public void setCreatedAT(Date createdAT) {
		this.createdAT = createdAT;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
}
