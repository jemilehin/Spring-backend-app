package temi.dev.demobackend.user;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {
    private List<UserModel> users = new ArrayList<>();

    List<UserModel> findAll(){
        return  users;
    }

    void createUser(UserModel user){
        users.add(user);
    }

    @PostConstruct
    private void init(){
        users.add(new UserModel(1,"dayo","jemilehin", "jemiilehin@gmail.com", "dayo",
                LocalDateTime.now(), LocalDateTime.now()));
        users.add(new UserModel(2,"tosin","jemilehin", "tosin@gmail.com", "tosin",
                LocalDateTime.now(), LocalDateTime.now()));
        users.add(new UserModel(3,"dare","jemilehin", "dare@gmail.com", "dare",
                LocalDateTime.now(), LocalDateTime.now()));
    }

    Optional<UserModel> findById(Integer id){
        return users.stream()
                .filter(userModel -> userModel.id() == id)
                .findFirst();
    }

    void updateUser(UserModel user, Integer id){
        Optional<UserModel> isUser = findById(id);
        if(isUser.isPresent()){
            users.set(users.indexOf(isUser.get()), user);
        }
    }

    void deleteUser(Integer id){
        users.removeIf(userModel -> userModel.id() == id);
    }
}
