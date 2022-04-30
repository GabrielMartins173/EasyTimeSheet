package com.ufrgs.EasyTimesheet.components.classroom;

import com.ufrgs.EasyTimesheet.models.User;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity(name = "CLASSROOM")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Classroom {

    @Id
    @Column(name = "CLASSID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "CLASSNAME")
    private String className;

    @NotNull
    @Column(name = "NUMBEROFLESSONS")
    private Integer numberOfLessons;

    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "TEACHER_ID", referencedColumnName = "id")
    private User teacher;

    @ManyToMany
    @JoinTable(
            name = "CLASSROOM_STUDENTS",
            joinColumns = @JoinColumn(name = "CLASSROOM_ID"),
            inverseJoinColumns = @JoinColumn(name = "STUDENT_ID"))
    Set<User> students;
}
