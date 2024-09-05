package br.com.claytoncalixto.todolist.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.claytoncalixto.todolist.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	@Query(value = "SELECT * FROM TB_USER_TASK T1" + 
			"        INNER JOIN TB_USER T2 ON T1.USER_ID = T2.ID" + 
			"        INNER JOIN TB_TASK T3 ON T1.TASK_ID = T3.ID" + 
			"        WHERE T2.ID = :userCode ", nativeQuery = true)
	List<User> listAllTasksByUser(Long userCode);

}
