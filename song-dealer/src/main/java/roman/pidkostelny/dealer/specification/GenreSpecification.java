package roman.pidkostelny.dealer.specification;

import org.springframework.data.jpa.domain.Specification;

import roman.pidkostelny.dealer.dto.request.GenreFilterRequest;
import roman.pidkostelny.dealer.entity.Genre;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class GenreSpecification implements Specification<Genre> {

    private GenreFilterRequest filter;

    public GenreSpecification(GenreFilterRequest filter) {
        this.filter = filter;
    }

    private String value;

    public GenreSpecification(String value) {
        this.value = value;
    }

    private Predicate findByName(Root<Genre> root, CriteriaBuilder criteriaBuilder) {
        return criteriaBuilder.like(root.get("Name"), value);
    }


    @Override
    public Predicate toPredicate(Root<Genre> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        return criteriaBuilder.or(findByName(root, criteriaBuilder));
    }
}
