package roman.pidkostelny.dealer.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter

public class BandsRequest {


    @NotNull
    @Size(min = 1, max = 500)
    private String name;


    @NotNull
    @Size(min = 1, max = 50)
    private String alive;

    @NotNull
    @Size(min = 1, max = 50)
    private String genreName;


}
