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
@Table(name = "teacher")

public class Teacher implements Serializable {
    @Id
    @Column(nullable = false)
    int id;

    @Column(name = "name", nullable = false)
    String name;

    @Column(name = "address", nullable = false)
    String address;

    @Column(name = "phone_number", nullable = false)
    String phoneNumber;

    @Column(name = "level", nullable = false)
    String level;
}
