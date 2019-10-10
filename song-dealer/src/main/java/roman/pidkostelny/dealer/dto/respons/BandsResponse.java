package roman.pidkostelny.dealer.dto.respons;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import roman.pidkostelny.dealer.entity.Bands;
import roman.pidkostelny.dealer.entity.Songs;

@Getter
@Setter
@NoArgsConstructor
public class BandsResponse {

    private Long id;

    private String name;

    private String genreName;

    private String alive;




    public BandsResponse(Bands bands) {
        id = bands.getId();
        name = bands.getName();
        genreName = bands.getGenreName();
        alive = bands.getAlive();

    }
}
