package booktrade.api.service;

import booktrade.api.entites.MyUserPrincipal;
import booktrade.api.entites.User;
import booktrade.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;


    public void addUser(User user){
        userRepository.save(user);
    }

    //TODO : only for testing purposes
    // Production code would not expose user details like this
    public Iterable<User> getAllUsers(){
        return userRepository.findAll();

    }

    public User findUserByEmail(String email){
        Optional<User> user = userRepository.findById(email);


        if(!user.isPresent()){
            throw new UsernameNotFoundException(email);
        }

        return user.get();
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findById(s);

        if(!user.isPresent())
            throw new UsernameNotFoundException(s);


        return new MyUserPrincipal(user.get());

    }
}
