package roman.pidkostelny.dealer.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class GenreFilterRequest {
    private String name;

    private List<Long> genreId = new ArrayList<>();

    private PaginationRequest paginationRequest;
}
