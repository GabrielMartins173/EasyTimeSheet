package com.ufrgs.EasyTimesheet.components.classroom;

import com.ufrgs.EasyTimesheet.models.User;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Getter
@Setter
public class ClassRoomRequest {

    @NotBlank
    private String className;
    @NotNull
    private int numberOfLessons;

    private int teacherId;

    private Set<Integer> studentsId;
}
