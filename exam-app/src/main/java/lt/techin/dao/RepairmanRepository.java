package lt.techin.dao;

import lt.techin.model.CarWorkshop;
import lt.techin.model.Repairman;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository

public interface RepairmanRepository extends JpaRepository<Repairman, Long> {

    List<Repairman> findByCarWorkshop(CarWorkshop carWorkshop);


}
