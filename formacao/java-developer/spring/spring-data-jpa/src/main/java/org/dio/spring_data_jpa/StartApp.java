package org.dio.spring_data_jpa;

import org.dio.spring_data_jpa.model.User;
import org.dio.spring_data_jpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StartApp implements CommandLineRunner {

    @Autowired
    private UserRepository repository;

    @Override
    public void run(String... args) throws Exception {

        //List<User> users = repository.filtrarPorNome("Evandro");
        List<User> users = repository.findByNameContaining("Evandro");
        for (User u : users) {
            System.out.println(u);
        }
    }

    private void insertUser() {
        User user = new User();
        user.setName("Evandro Machado");
        user.setUsername("emach");
        user.setPassword("dio111");

        repository.save(user);

        for(User u: repository.findAll()) {
            System.out.println(u);
        }
    }
}
