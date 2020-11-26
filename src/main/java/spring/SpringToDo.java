package spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import spring.entity.ToDo;
import spring.repository.ToDoRepository;

@SpringBootApplication
public class SpringToDo {
    @Autowired
    private ToDoRepository toDoRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringToDo.class, args);


    }

    @Bean
    public CommandLineRunner init() {
        return args -> {
//            ToDo feed_cat = ToDo.create("Feed cat");
//            toDoRepository.save(feed_cat);
        };
    }
}
