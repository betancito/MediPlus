package com.appointments.medical.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Time;

@Entity
@Table(name = "doctor")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true, nullable = false)
    private Long identification;

    @Column(nullable = false)
    private String full_name;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private Time shift_start;

    @Column(nullable = false)
    private Time shift_end;

    @Column(nullable = false)
    private Boolean available;

}
