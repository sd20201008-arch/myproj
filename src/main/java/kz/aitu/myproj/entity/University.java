package kz.aitu.myproj.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "university")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class University {

    @Id
    @Column(name = "uni_id")
    private Integer id;

    @Column(name = "uni_name")
    private String name;

    @Column(name = "uni_reccomend")
    private String reccomend;
}
