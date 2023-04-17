package mochegov.service;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import mochegov.enums.Faculty;
import mochegov.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class StudentService {

    private final R2dbcEntityTemplate template;

    @Autowired
    public StudentService(R2dbcEntityTemplate template) {
        this.template = template;
    }

    private static Long STUDENT_ID = 0L;
    private static Long getId() {
        return STUDENT_ID++;
    }
    private List<Student> students = new ArrayList<>();

    @Transactional
    public Mono<Student> addStudent(Student student) {
        return template.insert(student);
    }

    public void loadStudents() {
        log.info("Загрузка студентов...");

        students.add(Student.builder().id(getId()).firstName("Забиваев").lastName("Иван").age(18).faculty(Faculty.LAZY).build());
        students.add(Student.builder().id(getId()).firstName("Пинаев").lastName("Константин").age(19).faculty(Faculty.LAZY).build());
        students.add(Student.builder().id(getId()).firstName("Дурнев").lastName("Егор").age(18).faculty(Faculty.BOODY).build());
        students.add(Student.builder().id(getId()).firstName("Чудило").lastName("Семен").age(20).faculty(Faculty.BOODY).build());
        students.add(Student.builder().id(getId()).firstName("Додик").lastName("Василий").age(20).faculty(Faculty.BOODY).build());
        students.add(Student.builder().id(getId()).firstName("Разбиваев").lastName("Михаил").age(19).faculty(Faculty.HOOLIGANS).build());
        students.add(Student.builder().id(getId()).firstName("Поджигаев").lastName("Сергей").age(20).faculty(Faculty.HOOLIGANS).build());
        students.add(Student.builder().id(getId()).firstName("Отметелин").lastName("Виктор").age(19).faculty(Faculty.HOOLIGANS).build());
        students.add(Student.builder().id(getId()).firstName("Отжимайко").lastName("Дмитрий").age(20).faculty(Faculty.HOOLIGANS).build());
        students.add(Student.builder().id(getId()).firstName("Гопнинский").lastName("Антон").age(18).faculty(Faculty.HOOLIGANS).build());

        log.info("Количество студентов: " + students.size());

        students.forEach(student -> {
            Mono<Student> studentMono = addStudent(student);
            log.info(studentMono.toString());
        });
    }

    /*
    public Mono<Student> findStudentById(Long id) {
        Student student = students.stream().filter(s -> s.getId().equals(id)).findFirst().orElse(null);
        return Mono.just(student);
    }
    */





}
