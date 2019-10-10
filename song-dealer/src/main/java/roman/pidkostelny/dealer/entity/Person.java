package roman.pidkostelny.dealer.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, nullable = false)
    private String firstName;

    @Column(unique = true, nullable = false)
    private String lastName;

    private Integer age;

//    @OneToOne(mappedBy = "person")
//    private User user;

    @OneToMany(mappedBy = "person")
    private List<Bands> bands = new ArrayList<>();


}
