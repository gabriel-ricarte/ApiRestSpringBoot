package br.com.spring.registration;

import java.util.function.Predicate;

import org.springframework.stereotype.Service;

@Service
public class LoginValidator implements Predicate<String>{

    @Override
    public boolean test(String s) {
        return true;
    }
}