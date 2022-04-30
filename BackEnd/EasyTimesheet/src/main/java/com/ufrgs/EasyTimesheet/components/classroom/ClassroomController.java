package com.ufrgs.EasyTimesheet.components.classroom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/components")
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
    public ResponseEntity<Classroom> createClassroom(@Valid @RequestBody @NotNull ClassRoomRequest classRoomRequest)
    {
        Classroom classroom = new Classroom();
        classroom.setClassName(classRoomRequest.getClassName());
        classroom.setNumberOfLessons(classRoomRequest.getNumberOfLessons());
        classroom.setStudents(classroomService.findStudentsById(classRoomRequest.getStudentsId()));
        classroom.setTeacher(classroomService.findTeacherById(classRoomRequest.getTeacherId()));
        classroom = classroomService.saveClassroom(classroom);
        return ResponseEntity.ok().body(classroom);
    }
}
