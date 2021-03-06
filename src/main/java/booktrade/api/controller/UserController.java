package booktrade.api.controller;

import booktrade.api.entites.User;
import booktrade.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping(value = "/api/register")
    public void registerUser(@RequestBody User user){
        service.addUser(user);
    }

    //TODO : only for testing purposes
    /*@GetMapping(value = "/api/users")
    public Iterable<User> getAllUsers(){
        return service.getAllUsers();
    }*/

    @GetMapping(value = "/api/users/{email}")
    public User getUserDetails(@PathVariable String email){

        return service.findUserByEmail(email);
    }

    @PutMapping(value = "/api/users/{email}")
    public void updateUserInformation(@RequestBody User user,
                                      @PathVariable String email){
        service.updateUser(user,email);
    }
}
