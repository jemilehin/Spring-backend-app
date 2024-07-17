package temi.dev.demobackend.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping()
    List<UserModel> findAll(){
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    UserModel findById(@PathVariable Integer id){
        Optional<UserModel> user = userRepository.findById(id);
        if(user.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "user not found");
        }
        return user.get();
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    void create(@RequestBody UserModel user){
        userRepository.createUser(user);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping("/update/{id}")
    void updateUser(@RequestBody UserModel body, @PathVariable Integer id){
        userRepository.updateUser(body, id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @DeleteMapping("/delete/{id}")
    void deleteUser(@PathVariable Integer id){
        userRepository.deleteUser(id);
    }
}
