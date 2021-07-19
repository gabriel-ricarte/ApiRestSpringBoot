package br.com.spring.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.spring.model.User;
import br.com.spring.repository.UserRepository;
import br.com.spring.service.UserService;
import br.com.spring.util.UserCreator;

@DataJpaTest
@ExtendWith(SpringExtension.class)
public class UserControllerTest {

    @InjectMocks
    private UserController userController;
    @Mock
    private UserService userService;
    @Mock
    private UserRepository userRepository;
    @Test 
    @DisplayName("Delete remove usuario com sucesso")
    void testDeleteUser() {
    }

    @Test
    @DisplayName("FindGitInfo busca info do usuario com sucesso")
    void testFindGitInfo() {

    }

    @Test
    @DisplayName("FindUserById busca info do usuario com sucesso")

    void testFindUserById() {

    }

    @Test
    @DisplayName("GetAllUsers busca info dos usuarios com sucesso")
    void testGetAllUsers() {

    }

    @Test
    @DisplayName("ListUsers busca info dos usuarios com sucesso")
    void testListUsers() {

    }

    @Test
    @DisplayName("SaveUser persiste os dados do usuario com sucesso")
    void testSaveUser() {
        User userToBeSaved = UserCreator.userToBeSaved();

        User userSaved = this.userRepository.save(userToBeSaved);

        Assertions.assertNotNull(userSaved);
        Assertions.assertNotNull(userSaved.getId());
        Assertions.assertEquals(userToBeSaved.getName(), userSaved.getName());
    }

    @Test
    @DisplayName("UpdateUser persiste os dados do usuario com sucesso")
    void testUpdateUser() {

    }
}
