package roman.pidkostelny.dealer.dto.respons;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import roman.pidkostelny.dealer.entity.Songs;

@Getter
@Setter
@NoArgsConstructor
public class SongsRespons {

    private Long id;

    private String name;

    private String bame;

    private String genreName;

    private String urlname;


    public SongsRespons(Songs songs) {
        id = songs.getId();
        name = songs.getName();
        bame = songs.getBame();
        genreName = songs.getGenreName();
        urlname = songs.getUrlname();
    }
}
