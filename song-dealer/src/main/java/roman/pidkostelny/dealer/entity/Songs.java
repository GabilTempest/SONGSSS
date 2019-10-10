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
public class Songs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;

    private String bame;

    private String genreName;

    private String urlname;


    @ManyToMany
    private List<Bands> bands = new ArrayList<>();

    @ManyToOne
    private Genre genres;
}
