package com.ufrgs.EasyTimesheet.components.lesson;

import com.ufrgs.EasyTimesheet.components.classroom.Classroom;
import com.ufrgs.EasyTimesheet.models.User;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

public class Lesson {
    @Id
    @Column(name = "LESSONID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CLASSROOMID", referencedColumnName = "CLASSID")
    private Classroom classRoom;

    @ManyToMany
    @JoinTable(
            name = "PRESENCE_LESSON",
            joinColumns = @JoinColumn(name = "PRESENCE_ID"),
            inverseJoinColumns = @JoinColumn(name = "LESSON_ID"))
    Set<Presence> studentPresence;
}
