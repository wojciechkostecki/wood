package pl.wojciechkostecki.wood.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.wojciechkostecki.wood.model.Tree;

@Repository
public interface TreeRepository extends JpaRepository<Tree,Long> {
}
