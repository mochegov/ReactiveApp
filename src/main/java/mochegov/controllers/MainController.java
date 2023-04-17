package mochegov.controllers;

import lombok.extern.slf4j.Slf4j;
import mochegov.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/students")
public class MainController {

    private StudentService studentService;

    @Autowired
    public MainController(StudentService studentService) {
        this.studentService = studentService;
    }

    // Главная страница
    @GetMapping("/health")
    public String healthPage() {
        log.info("Проверка состояния приложения...");
        return "OK";
    }

}
