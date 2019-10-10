package roman.pidkostelny.dealer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import roman.pidkostelny.dealer.entity.User;


import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByLoginEquals(String login);
}
