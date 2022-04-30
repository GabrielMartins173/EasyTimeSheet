package com.ufrgs.EasyTimesheet.components.classroom;

import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
public class AddStudentRequest {

    @NotBlank
    private Long classRoomId;
    private Long studentId;
}
