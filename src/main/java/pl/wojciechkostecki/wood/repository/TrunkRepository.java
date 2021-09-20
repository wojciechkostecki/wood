package pl.wojciechkostecki.wood.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.wojciechkostecki.wood.model.Trunk;

@Repository
public interface TrunkRepository extends JpaRepository<Trunk, Long> {
}
