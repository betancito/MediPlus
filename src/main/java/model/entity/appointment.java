package model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import model.enums.appointmentStatus;

import java.sql.Time;
import java.util.Date;

@Entity
@Table(name = "appointment")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    @JoinColumn(name = "doctor_id", referencedColumnName = "id")
    private doctor doctor;

    @OneToOne
    @JoinColumn(name = "patient_id", referencedColumnName = "id")
    private patient patient;

    @Column(nullable = false)
    private Date appointment_date;

    @Column(nullable = false)
    private Time appointment_start;

    @Column(nullable = false)
    private Time appointment_end;

    @Column(nullable = true)
    private String diagnosis;

    @Column(nullable = true)
    private String treatment;

    @Column(nullable = false)
    private appointmentStatus status;
}
