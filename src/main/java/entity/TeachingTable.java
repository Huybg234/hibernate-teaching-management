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
@AllArgsConstructor
@XmlRootElement
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "teaching_table")

public class TeachingTable implements Serializable {

    @Id
    @Column(nullable = false)
    int id;

    @Column(name = "teacher_id", nullable = false)
    int teacherId;

    @Column(name = "subject_id", nullable = false)
    int subjectId;

    @Column(name = "class_total", nullable = false)
    int classTotal;
}
