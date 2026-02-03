package kz.aitu.myproj.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "profesors")
@Getter
@Setter
@NoArgsConstructor
public class Professor {

    @Id
    @Column(name = "professor_id")
    private Integer id;

    @Column(name = "professor_name")
    private String professorName;

    @Column(name = "professor_course")
    private String professorCourse;

    @Column(name = "professor_age")
    private Integer professorAge;

    @ManyToOne
    @JoinColumn(name = "uni_id")
    private University university;
}