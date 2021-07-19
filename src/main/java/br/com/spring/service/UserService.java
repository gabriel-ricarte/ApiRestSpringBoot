package br.com.spring.service;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.spring.model.User;
import br.com.spring.repository.UserRepository;
import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class UserService implements UserDetailsService{

    private final static String USER_NOT_FOUND_MSG = "Usuario com login %s não encontrado !";
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException{
        return userRepository.findByLogin(login).orElseThrow(() -> new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG, login)));
    };

    public String signUpUser(User user){

       boolean userExists = userRepository.findByLogin(user.getLogin()).isPresent();
       
       if(userExists){
           throw new IllegalStateException("Login ja existe !");
       }
       
       String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());

       user.setPassword(encodedPassword);

       userRepository.save(user);

       return "Usuário Registrado com sucesso !";
    }

}
