package pl.wojciechkostecki.wood.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.wojciechkostecki.wood.model.Leaf;

@Repository
public interface LeafRepository extends JpaRepository<Leaf,Long> {
}
