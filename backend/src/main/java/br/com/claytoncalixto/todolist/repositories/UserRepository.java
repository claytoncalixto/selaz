package br.com.claytoncalixto.todolist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.claytoncalixto.todolist.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
