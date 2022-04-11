package com.ufrgs.EasyTimesheet.classroom;

import com.ufrgs.EasyTimesheet.user.User;
import com.ufrgs.EasyTimesheet.user.UserRepository;
import com.ufrgs.EasyTimesheet.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ClassroomService {
    @Autowired
    private ClassroomRepository classroomRepository;

    @Autowired
    private UserService userService;


    public List<Classroom> findAllClassroom() {
        List<Classroom> classroomList = new ArrayList<>();
        classroomRepository.findAll().forEach(classroom -> classroomList.add(classroom));
        return classroomList;
    }


    public Classroom saveClassroom(Classroom classroom) {
        classroomRepository.save(classroom);
        return classroom;
    }

    public Classroom addStudent(Long id, Long studentId) {

        Classroom classroom = classroomRepository.findById(id).orElseThrow();
        Set<User> studentList = classroom.getStudents();
        if (studentList == null) {
            studentList = new HashSet<>();
        }

        User student = userService.findById(studentId);
        studentList.add(student);
        classroom.setStudents(studentList);
        classroomRepository.save(classroom);

        return classroom;
    }
}
