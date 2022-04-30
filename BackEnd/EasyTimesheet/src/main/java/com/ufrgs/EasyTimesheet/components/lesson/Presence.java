package com.ufrgs.EasyTimesheet.components.lesson;

import com.ufrgs.EasyTimesheet.models.User;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

public class Presence {
    @Id
    @Column(name = "PRESENCEID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ALUMN", referencedColumnName = "ID")
    private User alumn;

    @NotNull
    Boolean isPresent;
}
