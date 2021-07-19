package br.com.spring.registration;

import org.springframework.stereotype.Service;

import br.com.spring.model.Role;
import br.com.spring.model.User;
import br.com.spring.service.UserService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RegistrationService {

    private final UserService userService;
    private final EmailValidator emailValidator;
    private final LoginValidator loginValidator;
    private final GithubValidator githubValidator;


    public String register(RegistrationRequest request){
        boolean isValidEmail = emailValidator.test(request.getEmail());
        boolean isValidLogin = loginValidator.test(request.getLogin());
        boolean isValidGitHub = githubValidator.test(request.getGithub());

        if(!isValidEmail){
            throw new IllegalStateException("Email é invalido");    
        }
        if(!isValidLogin){
            throw new IllegalStateException("Login é invalido");    
        }
        if(!isValidGitHub){
            throw new IllegalStateException("GitHub é invalido");    
        }
        return userService.signUpUser(
            new User(
            request.getName()
            ,request.getLogin()
            ,request.getPassword()
            ,request.getEmail()
            ,request.getGithub()
            ,Role.USER)
        );
    }
}
