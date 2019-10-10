package roman.pidkostelny.dealer.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor

@Entity
public class Bands {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(unique = true)
    private String name;

    private String genreName;

    private String alive;


    @ManyToMany(mappedBy = "bands")
    private List<Songs> songs = new ArrayList<>();

    @ManyToOne
    private Person person;


    @ManyToOne
    private Genre genre;

}
