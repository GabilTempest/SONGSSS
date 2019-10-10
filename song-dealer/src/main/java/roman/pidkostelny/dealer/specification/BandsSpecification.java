package roman.pidkostelny.dealer.specification;

import org.springframework.data.jpa.domain.Specification;
import roman.pidkostelny.dealer.dto.request.BandsFilterRequest;
import roman.pidkostelny.dealer.dto.request.SongsFilterRequest;
import roman.pidkostelny.dealer.entity.Bands;
//import roman.pidkostelny.dealer.entity.Person;
import roman.pidkostelny.dealer.entity.Songs;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class BandsSpecification implements Specification<Bands> {

    private String value;

    private BandsFilterRequest filter;

    public BandsSpecification(BandsFilterRequest filter) {
        this.filter = filter;
    }

    public BandsSpecification(String value) {
        this.value = value;
    }

    private Predicate findByName(Root<Bands> root, CriteriaBuilder criteriaBuilder) {
        return criteriaBuilder.like(root.get("Name"), value);
    }


    @Override
    public Predicate toPredicate(Root<Bands> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        return criteriaBuilder.or(findByName(root, criteriaBuilder));
    }

}
