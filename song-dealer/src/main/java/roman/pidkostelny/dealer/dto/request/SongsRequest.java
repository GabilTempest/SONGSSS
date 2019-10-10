package roman.pidkostelny.dealer.dto.request;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class SongsRequest {

    @NotNull
    @Size(min = 1, max = 500)
    private String name;

    @NotNull
    @Size(min = 1, max = 500)
    private String bame;

    @NotNull
    @Size(min = 1, max = 500)
    private String genreName;

    @NotNull
    @Size(min = 1, max = 1000000)
    private String urlname;

}
