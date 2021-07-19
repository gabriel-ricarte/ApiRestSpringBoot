package br.com.spring.util;

import br.com.spring.model.Role;
import br.com.spring.model.User;

public class UserCreator {
    public static User userToBeSaved(){
        return new User("Gabriel", "bielricarte", "123", "email", "git", Role.USER);
    }

    public static User userValid(){
        return new User(1L,"Gabriel", "bielricarte", "123", "email", "git", Role.USER,null,null,false,false,false);       
    }

    public static User userValidToUpdate(){
        return new User(1L,"Gabriel DOIS", "bielricarte", "123", "email", "git", Role.USER,null,null,false,false,false);       
    }
}
