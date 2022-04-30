package com.ufrgs.EasyTimesheet.components.classroom;

import com.ufrgs.EasyTimesheet.payload.request.LoginRequest;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/classroom")
public class ClassroomController {

    @Autowired
    private ClassroomService classroomService;

    @GetMapping("/")
    public ResponseEntity<List<Classroom>> findAll()
    {
        List<Classroom> classroomList = classroomService.findAllClassroom();
        return ResponseEntity.ok().body(classroomList);
    }

    @PostMapping("/createclassroom")
    public ResponseEntity<Classroom> createClassroom(@Valid @RequestBody @NotNull ClassRoomRequest classRoomRequest)
    {
        Classroom classroom = new Classroom();
        classroom.setClassName(classRoomRequest.getClassName());
        classroom.setNumberOfLessons(classRoomRequest.getNumberOfLessons());
        classroom.setStudents(classRoomRequest.getStudents());
        classroom.setTeacher(classRoomRequest.getTeacher());
        classroom = classroomService.saveClassroom(classroom);
        return ResponseEntity.ok().body(classroom);
    }
}
