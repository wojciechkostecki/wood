package pl.wojciechkostecki.wood.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.wojciechkostecki.wood.model.Branch;

@Repository
public interface BranchRepository extends JpaRepository<Branch, Long> {
}
