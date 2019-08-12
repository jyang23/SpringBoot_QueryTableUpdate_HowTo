package com.jy.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    @Autowired
    UserRepository userRepository;

    @Override
    public void run(String... strings) throws Exception {
        userRepository.deleteAll();

        User user = new User();
        user.setFirstName("Justin");
        user.setLastName("Yang");
        userRepository.save(user);

        user = new User();
        user.setFirstName("Hello");
        user.setLastName("Bye");
        userRepository.save(user);
    }
}
