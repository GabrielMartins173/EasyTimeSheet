package com.ufrgs.EasyTimesheet.components.classroom;

import com.ufrgs.EasyTimesheet.models.User;
import com.ufrgs.EasyTimesheet.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ClassroomService {
    @Autowired
    private ClassroomRepository classroomRepository;

    @Autowired
    private UserRepository userRepository;

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

        User student = userRepository.findById(studentId).orElseThrow();
        studentList.add(student);
        classroom.setStudents(studentList);
        classroomRepository.save(classroom);

        return classroom;
    }

    public Set<User> findStudentsById(Set<Integer> studentsId) {

        Set<User> students = new HashSet<>();

        for (Integer student : studentsId){

            students.add(userRepository.findById(student));
        }
        return students;
    }

    public User findTeacherById(int teacherId) {

        User teacher = userRepository.findById(teacherId);

        return teacher;
    }
}
