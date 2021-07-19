package br.com.spring.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.spring.model.User;

@Repository
@Transactional(readOnly = true)
public interface UserRepository extends JpaRepository<User , Long> {
    
    public Optional<User> findByLogin(String login);

}
