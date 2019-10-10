package roman.pidkostelny.dealer.specification;

import org.springframework.data.jpa.domain.Specification;
import roman.pidkostelny.dealer.dto.request.SongsFilterRequest;
import roman.pidkostelny.dealer.entity.Bands;
import roman.pidkostelny.dealer.entity.Songs;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class SongSpecification implements Specification<Songs> {

    private SongsFilterRequest filter;

    public SongSpecification(SongsFilterRequest filter) {
        this.filter = filter;
    }

    private String value;

    public SongSpecification(String value) {
        this.value = value;
    }

    private Predicate findByName(Root<Songs> root, CriteriaBuilder criteriaBuilder) {
        return criteriaBuilder.like(root.get("name"), value);
    }


    @Override
    public Predicate toPredicate(Root<Songs> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();
        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));

    }

}
