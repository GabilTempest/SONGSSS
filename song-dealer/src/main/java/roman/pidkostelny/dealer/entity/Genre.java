package roman.pidkostelny.dealer.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor

@Entity
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;


    @OneToMany
    private List<Songs> songs = new ArrayList<>();


    @OneToMany(mappedBy = "genre")
    private List<Bands> bands = new ArrayList<>();


}
