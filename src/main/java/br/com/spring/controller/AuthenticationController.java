package br.com.spring.controller;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
    
    // private UserAuthenticationService userAuthenticationService;    

    // @Autowired
    // public AuthenticationController(UserAuthenticationService userAuthenticationService){
    //     this.userAuthenticationService = userAuthenticationService;
    // }

    // public AuthenticationController(){

    // }


    // @PostMapping("/login")
    // public ResponseEntity<UserAutheticatedDTO> autenticar(@RequestBody DadosLogin dadosLogin, @RequestHeader String Authorization){
    //     User user = userAuthenticationService.authenticate(dadosLogin, Authorization);
    //     return new ResponseEntity<UserAutheticatedDTO>(UserAutheticatedDTO.toDTO(user, "Bearer "), HttpStatus.ACCEPTED);
    // }
}
