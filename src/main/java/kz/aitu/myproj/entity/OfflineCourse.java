package kz.aitu.myproj.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name ="offlinecourses")
public class OfflineCourse extends Course {
}
