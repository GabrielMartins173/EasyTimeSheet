package com.ufrgs.EasyTimesheet.components.classroom;

import com.ufrgs.EasyTimesheet.models.User;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.Set;

@Getter
@Setter
public class ClassRoomRequest {

    @NotBlank
    private String className;
    @NotBlank
    private int numberOfLessons;
    @NotBlank
    private User teacher;

    Set<User> students;
}
