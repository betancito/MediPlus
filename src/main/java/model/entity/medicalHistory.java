package model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Entity
@Table(name = "medical_history")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class medicalHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    @JoinColumn(name = "patient_id", referencedColumnName = "id")
    private patient patient;

    @ManyToOne
    @JoinColumn(name = "appointment_id")
    private appointment appointment;

}
