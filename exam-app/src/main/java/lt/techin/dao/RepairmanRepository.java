package lt.techin.dao;

import lt.techin.model.Repairman;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface RepairmanRepository extends JpaRepository<Repairman, Long> {
}
