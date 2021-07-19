package br.com.spring.controller;


import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import br.com.spring.model.Github;
import br.com.spring.model.User;
import br.com.spring.repository.UserRepository;
import br.com.spring.service.GithubService;
import org.springframework.data.domain.Sort;
/**
 * UserController
 */
@RestController
@RequestMapping("/users")

public class UserController {

@Autowired
private UserRepository userRepository;
@Autowired
private GithubService githubService;

    @GetMapping
    public List<User> listUsers(){
        return this.userRepository.findAll();       
    }

    @GetMapping("/pagination")
    public ResponseEntity<Page<User>> getAllUsers(@PageableDefault(page = 0, size = 5, sort = "id", direction = Sort.Direction.ASC) org.springframework.data.domain.Pageable pageable){
        Page<User> usersList = userRepository.findAll(pageable);
        if (usersList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            
            return new ResponseEntity<>(usersList,HttpStatus.OK);
        }
       // return this.userRepository.findAll(pageable);       
    }

    @GetMapping("/{id}")
    public User findUserById(@PathVariable("id") Long id){

        Optional<User> UserFind = this.userRepository.findById(id);
        if(UserFind.isPresent()){
            return UserFind.get();
        }
        return null;
    }  

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User saveUser(@RequestBody User user){
        return this.userRepository.save(user);
    }

    @PostMapping("/salveAll")
    @ResponseStatus(HttpStatus.CREATED)
    public List<User> saveAllUsers(@RequestBody Iterable<User> users){
        return this.userRepository.saveAll(users);
    }

    @DeleteMapping
    public Void deleteUser(@RequestBody User user){
        this.userRepository.delete(user);
        return null;
    }

    @PreAuthorize("hasRole('USER')")   
    @PutMapping
    public User updateUser(@RequestBody User user){       
        return this.userRepository.save(user);
    }

    @GetMapping("/{id}/github")
    public Github findGitInfo(@PathVariable("id") Long id) throws Exception{

        Optional<User> UserFind = this.userRepository.findById(id);
        if(UserFind.isPresent()){
            //User user = UserFind.get().;

            return githubService.getInfoGit(UserFind.get().getGithub());
            
        }
        return null;
    }  

    
    
}