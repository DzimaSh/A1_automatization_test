package by.a1.supplies.repository;

import by.a1.supplies.entity.Login;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoginRepository extends CrudRepository<Login, Long> {
    Optional<Login> findByAppAccountName(String name);
}
