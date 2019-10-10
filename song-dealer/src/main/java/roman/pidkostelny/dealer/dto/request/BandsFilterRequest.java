package roman.pidkostelny.dealer.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class BandsFilterRequest {
    private String name;

    private List<Long> bandsId = new ArrayList<>();

    private PaginationRequest paginationRequest;
}
