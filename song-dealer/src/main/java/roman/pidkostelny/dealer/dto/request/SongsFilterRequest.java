package roman.pidkostelny.dealer.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class SongsFilterRequest {


    private String name;

    private String bame;

    private String genreName;

    private List<Long> songId = new ArrayList<>();

    private PaginationRequest paginationRequest;
}
