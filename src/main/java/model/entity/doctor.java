package model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.sql.Time;

@Entity
@Table(name = "doctor")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class doctor {

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
