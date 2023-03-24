package Hibernate.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Formula;
import org.hibernate.annotations.GenericGenerator;

import java.sql.Date;
//@Deprecated //добавила сама
@Entity(name = "User")
@Table(schema = "studydb", name = "hibernatetraining")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
  //  @GeneratedValue(strategy = GenerationType.IDENTITY)//вообще убрать эту строчку, тк id String она выдает ошибку
    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(name = "Id", nullable = false, length = 128)
    private String id;
    @Basic
    @Column(name = "FirstName", nullable = true, length = 128)
    private String firstName;
    @Basic
    @Column(name = "LastName", nullable = true, length = 128)
    private String lastName;
    @Basic
    @Column(name = "BirthDate", nullable = true)
    private Date birthDate;

    @Basic
    @Column(name = "Age", nullable = true)
    @Formula("(TIMESTAMPDIFF(Age,BirthDate,CURDATE()))")
    private Integer age;

    @Override
    public String toString() {
        return super.toString();
    }

}
