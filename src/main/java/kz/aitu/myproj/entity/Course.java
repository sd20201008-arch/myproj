package kz.aitu.myproj.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public abstract class Course {

    @Id
    @Column(name = "courseid")
    private Integer courseId;

    @Column(name = "coursename")
    private String courseName;

    @Column(name = "courseavailable")
    private Boolean courseAvailable;

    @ManyToOne
    @JoinColumn(name = "uni_id")
    private University university;

    @ManyToOne
    @JoinColumn(name = "professor_id")
    private Professor professor;

}
