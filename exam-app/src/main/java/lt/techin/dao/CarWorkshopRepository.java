package lt.techin.dao;

import lt.techin.model.CarWorkshop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface CarWorkshopRepository extends JpaRepository<CarWorkshop, Long> {
}
