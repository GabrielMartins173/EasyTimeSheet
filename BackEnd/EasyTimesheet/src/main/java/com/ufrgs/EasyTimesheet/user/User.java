package com.ufrgs.EasyTimesheet.user;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;

    @Entity(name = "USER")
    @Builder
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public class User {

        @Id
        @Column(name = "ID")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "NAME")
        @NotNull
        private String name;

        @Column(name = "ROLE")
        private String role;

        @Column(name = "EMAIL")
        @NotNull
        private String email;

        @Column(name = "PWD")
        @NotNull
        private String pwd;
    }