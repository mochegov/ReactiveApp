package mochegov.model;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import mochegov.enums.Faculty;

@Getter
@Setter
@Builder
@ToString
public class Student {
    private Long id;
    private String firstName;
    private String lastName;
    private Integer age;
    private Faculty faculty;
}
