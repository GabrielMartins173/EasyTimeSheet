package com.ufrgs.EasyTimesheet.classroom;

import com.sun.istack.NotNull;
import com.ufrgs.EasyTimesheet.user.User;
import lombok.*;

import javax.persistence.*;
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

    @Column(name = "CLASSNAME")
    private String className;

    @ManyToMany
    @JoinTable(
            name = "CLASSROOM_STUDENTS",
            joinColumns = @JoinColumn(name = "CLASSROOM_ID"),
            inverseJoinColumns = @JoinColumn(name = "STUDENT_ID"))
    Set<User> students;
}
