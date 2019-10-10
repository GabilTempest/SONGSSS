package roman.pidkostelny.dealer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import roman.pidkostelny.dealer.entity.Songs;

@Repository
public interface SongsRepository extends JpaRepository<Songs, Long>, JpaSpecificationExecutor<Songs> {


}
