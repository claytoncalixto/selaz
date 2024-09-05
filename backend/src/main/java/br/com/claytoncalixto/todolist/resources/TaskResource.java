package br.com.claytoncalixto.todolist.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.claytoncalixto.todolist.dto.TaskDTO;
import br.com.claytoncalixto.todolist.services.TaskService;

@RestController
@RequestMapping(value = "/tasks")
public class TaskResource {

	@Autowired
	private TaskService taskService;

	@GetMapping
	public ResponseEntity<List<TaskDTO>> findAll() {
		List<TaskDTO> list = taskService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<TaskDTO> findById(@PathVariable Long id) {
		TaskDTO idDTO = taskService.findById(id);
		return ResponseEntity.ok().body(idDTO);
	}
	
	@PostMapping
	public ResponseEntity<TaskDTO> insert(@RequestBody TaskDTO dto) {
		dto = taskService.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<TaskDTO> update(@PathVariable Long id, @RequestBody TaskDTO dto) {
		dto = taskService.update(id, dto);
		return ResponseEntity.ok().body(dto);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		taskService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping(value = "?status={statusCode}")
	public ResponseEntity<List<TaskDTO>> listStatusTask(@PathVariable Long statusCode){
		List<TaskDTO> codeStatus = taskService.findListTaskByStatus(statusCode);
		return ResponseEntity.ok().body(codeStatus);
	}
	
	@GetMapping(value = "?sort=dueDate")
	public ResponseEntity<List<TaskDTO>> listStatusDueDate(@PathVariable Long statusCode){
		List<TaskDTO> codeStatus = taskService.findListTaskByDueDate(statusCode);
		return ResponseEntity.ok().body(codeStatus);
	}
}
