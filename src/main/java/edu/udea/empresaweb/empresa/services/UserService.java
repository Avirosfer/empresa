package edu.udea.empresaweb.empresa.services;

import edu.udea.empresaweb.empresa.entities.User;
import edu.udea.empresaweb.empresa.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Objects;

@Service

public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUser(User user){
        return this.userRepository.save(user);
    }

    public User findUserByEmail(String email){

        return this.userRepository.findByEmail(email);
    }

    public User getUser(Map<String, Object> userData){
        String email = (String)userData.get("email");
        User user = findUserByEmail(email);
        if (user==null){
            String nickname=(String) userData.get("nickname");
            String image=(String) userData.get("picture");
            String email1=(String)  userData.get("email");

            User user1 = new User(email1, image, nickname);

            return saveUser(user1);
        }

        System.out.print(user.getEmail());
        return user;
    }
}
