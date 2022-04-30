package com.ufrgs.EasyTimesheet.components.classroom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ClassroomController {

    @Autowired
    private ClassroomService classroomService;

    @GetMapping("/classroom")
    public ResponseEntity<List<Classroom>> findAll()
    {
        List<Classroom> classroomList = classroomService.findAllClassroom();
        return ResponseEntity.ok().body(classroomList);
    }

    @PostMapping("/createclassroom")
    public ResponseEntity<Classroom> createClassroom()
    {
        Classroom classroom = new Classroom();
        classroom.setClassName("TURMA1");
        classroom = classroomService.saveClassroom(classroom);

        classroomService.addStudent(1L, 1L);
        classroomService.addStudent(1L, 2L);
        classroomService.addStudent(1L, 3L);

        return ResponseEntity.ok().body(classroom);
    }
}
