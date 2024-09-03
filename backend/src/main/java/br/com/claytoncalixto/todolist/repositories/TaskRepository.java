package br.com.claytoncalixto.todolist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.claytoncalixto.todolist.entities.Task;

@Repository
public interface TaskRepository  extends JpaRepository<Task, Long>{

}
