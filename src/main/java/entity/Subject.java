package entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@Data
@Entity
@NoArgsConstructor
@XmlRootElement
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "subject")

public class Subject implements Serializable {
    @Id
    @Column(nullable = false)
    int id;

    @Column(name = "name", nullable = false)
    String name;

    @Column(name = "total_lesson", nullable = false)
    int totalLesson;

    @Column(name = "theory_lesson", nullable = false)
    int theoryLesson;

    @Column(name = "unit_theory_cost", nullable = false)
    float unitTheoryCost;

}
