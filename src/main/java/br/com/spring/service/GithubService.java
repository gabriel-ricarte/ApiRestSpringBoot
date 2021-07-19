package br.com.spring.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.spring.model.Github;
import br.com.spring.model.RepoGit;

@Service
public class GithubService {

   
    RestTemplate restTemplate = new RestTemplate();

    public <Optional>Github getInfoGit(String username){
        //"https://api.github.com/users/"
        UriComponents uri  = UriComponentsBuilder.newInstance()
        .scheme("https")
        .host("api.github.com/users")
        .path(username)
        .build();

        //restTemplate.getForEntity(uri.toUriString(), responseType, uriVariables)
        ResponseEntity<Github> entity = restTemplate.getForEntity(uri.toUriString(), Github.class);

        UriComponents url  = UriComponentsBuilder.newInstance()
        .scheme("https")
        .host("api.github.com/users")
        .path(username+"/repos")
        .build();

        //restTemplate.getForEntity(uri.toUriString(), responseType, uriVariables)
        ResponseEntity<RepoGit[]> entityl = restTemplate.getForEntity(url.toUriString(), RepoGit[].class);
        
        RepoGit[] repoGit = entityl.getBody();
        Github github = new Github(entity.getBody().getId(),entity.getBody().getAvatar_url(),repoGit);

        return github;
    }
    
}
