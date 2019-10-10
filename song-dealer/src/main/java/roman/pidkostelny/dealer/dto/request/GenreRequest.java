package roman.pidkostelny.dealer.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
public class GenreRequest {

    @NotNull
    @Size(min = 1, max = 50)
    private String name;

//    @NotNull
//    @Size(min = 1, max = 500)
//    private String url;



}
