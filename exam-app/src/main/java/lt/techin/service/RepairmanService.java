package lt.techin.service;

import lt.techin.dao.CarWorkshopRepository;
import lt.techin.dao.RepairmanRepository;
import lt.techin.exception.CarWorkshopValidationException;
import lt.techin.model.CarWorkshop;
import lt.techin.model.Repairman;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RepairmanService {

    private final RepairmanRepository repairmanRepository;
    private final CarWorkshopRepository carWorkshopRepository;

    public RepairmanService(RepairmanRepository repairmanRepository, CarWorkshopRepository carWorkshopRepository) {
        this.repairmanRepository = repairmanRepository;
        this.carWorkshopRepository = carWorkshopRepository;
    }


    public List<Repairman> getAll() {
        return repairmanRepository.findAll();
    }

    public Optional<Repairman> getById(Long id) {
        return repairmanRepository.findById(id);
    }

    public Repairman create(Repairman repairman, Long carWorkshopId) {
        var existingCarWorkshop = carWorkshopRepository.findById(carWorkshopId)
                .orElseThrow(() -> new CarWorkshopValidationException("Menu does not exist",
                        "id", "Menu not found", carWorkshopId.toString()));
        repairman.setCarWorkshop(existingCarWorkshop);

        return repairmanRepository.save(repairman);
    }

    public boolean deleteById(Long id) {
        try {
            repairmanRepository.deleteById(id);
            return true;
        } catch (EmptyResultDataAccessException exception) {
            return false;
        }
    }

    public Repairman update(Long id, Repairman repairman) {
        var existingRepairman = repairmanRepository.findById(id)
                .orElseThrow(() -> new CarWorkshopValidationException("Menu does not exist",
                        "id", "Menu not found", id.toString()));

        existingRepairman.setName(repairman.getName());
        existingRepairman.setSurname(repairman.getSurname());
        existingRepairman.setWorkScope(repairman.getWorkScope());
        existingRepairman.setCity(repairman.getCity());
        existingRepairman.setRating(repairman.getRating());
        existingRepairman.setCarWorkshop(repairman.getCarWorkshop());

        return repairmanRepository.save(existingRepairman);
    }

    public List<Repairman> getRepairmanByCarWorkshopId(Long carWorkshopId) {
        CarWorkshop carWorkshop = new CarWorkshop();
        carWorkshop.setId(carWorkshopId);

        return repairmanRepository.findByCarWorkshop(carWorkshop);
    }
}
