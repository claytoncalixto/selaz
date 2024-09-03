package br.com.claytoncalixto.todolist.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.claytoncalixto.todolist.entities.Task;

@RestController
@RequestMapping(value = "/tasks")
public class TaskResource {
	
	@GetMapping
	public ResponseEntity<List<Task>> findAll() {
		List<Task> list = new ArrayList<>();
		list.add(new Task(1L, "Correr", null, null, null, null, null));
		list.add(new Task(1L, "Estudar", null, null, null, null, null));
		list.add(new Task(1L, "Trabalhar", null, null, null, null, null));
		return ResponseEntity.ok().body(list);
	}

}
