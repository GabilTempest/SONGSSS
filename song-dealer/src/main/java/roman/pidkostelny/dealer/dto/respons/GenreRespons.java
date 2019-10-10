package roman.pidkostelny.dealer.dto.respons;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import roman.pidkostelny.dealer.entity.Genre;

@Getter
@Setter
@NoArgsConstructor
public class GenreRespons {

    private Long id;

    private String name;

//    private String url;


    public GenreRespons(Genre genre) {
        id = genre.getId();
        name = genre.getName();
//        url = genre.getUrl();


    }

}
