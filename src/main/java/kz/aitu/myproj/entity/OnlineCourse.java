package kz.aitu.myproj.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "onlinecourses")
public class OnlineCourse extends Course {

}
