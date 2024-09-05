package br.com.claytoncalixto.todolist.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.claytoncalixto.todolist.entities.Task;

@Repository
public interface TaskRepository  extends JpaRepository<Task, Long>{
	
	@Query(value = "SELECT * FROM TB_TASK T1 WHERE T1.STATUS = :statusCode", nativeQuery = true )
	List<Task> listTaskByStatus(Long statusCode);
	
	@Query(value = "SELECT * FROM TB_TASK T1 ORDER BY DUE_DATE ASC;", nativeQuery = true)
	List<Task> listTaskByDueDate(Long statusCode);	
}
