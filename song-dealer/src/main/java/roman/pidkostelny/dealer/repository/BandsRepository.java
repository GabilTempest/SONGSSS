package roman.pidkostelny.dealer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import roman.pidkostelny.dealer.entity.Bands;

@Repository
public interface BandsRepository extends JpaRepository<Bands, Long>, JpaSpecificationExecutor<Bands> {

}
