package br.com.spring.registration;

import java.util.function.Predicate;

import org.springframework.stereotype.Service;

@Service
public class GithubValidator  implements Predicate<String>{

    @Override
    public boolean test(String t) {
        return true;
    }
}
