package mochegov.config;

import mochegov.service.StudentService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public CommandLineRunner runner(StudentService studentService) {
        return args -> studentService.loadStudents();
    }
}
