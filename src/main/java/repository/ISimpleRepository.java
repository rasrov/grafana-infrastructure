package repository;

import model.Simple;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISimpleRepository extends JpaRepository<Simple, Long> {
}
