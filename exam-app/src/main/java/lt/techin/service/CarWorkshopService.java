package lt.techin.service;

import lt.techin.dao.CarWorkshopRepository;
import lt.techin.dao.RepairmanRepository;
import lt.techin.exception.CarWorkshopValidationException;
import lt.techin.model.CarWorkshop;
import lt.techin.model.Repairman;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service

public class CarWorkshopService {

    private final CarWorkshopRepository carWorkshopRepository;
    private final RepairmanRepository repairmanRepository;

    private final Validator validator;

    public CarWorkshopService(CarWorkshopRepository carWorkshopRepository, RepairmanRepository repairmanRepository, Validator validator) {
        this.carWorkshopRepository = carWorkshopRepository;
        this.repairmanRepository = repairmanRepository;
        this.validator = validator;
    }

    void validateInputWithInjectedValidator(CarWorkshop carWorkshop) {
        Set<ConstraintViolation<CarWorkshop>> violations = validator.validate(carWorkshop);
        if (!violations.isEmpty()) {
            throw new CarWorkshopValidationException(violations.toString(), "Menu", "Error in Menu entity", carWorkshop.toString());
        }
    }

    public boolean carWorkshopTitleIsUnique(CarWorkshop carWorkshop) {
        return carWorkshopRepository.findAll()
                .stream()
                .noneMatch(bp -> bp.getTitle().equals(carWorkshop.getTitle()));
    }

    public List<CarWorkshop> getAll() {
        return carWorkshopRepository.findAll();
    }

    public Optional<CarWorkshop> getById(Long id) {
        return carWorkshopRepository.findById(id);
    }

    public CarWorkshop create(CarWorkshop carWorkshop) {
        return carWorkshopRepository.save(carWorkshop);
    }

    public boolean deleteById(Long id) {
        try {
            carWorkshopRepository.deleteById(id);
            return true;
        } catch (EmptyResultDataAccessException exception) {
            return false;
        }
    }

    public CarWorkshop update(Long id, CarWorkshop carWorkshop) {
        var existingCarWorkshop = carWorkshopRepository.findById(id)
                .orElseThrow(() -> new CarWorkshopValidationException("Menu does not exist",
                        "id", "Menu not found", id.toString()));

        existingCarWorkshop.setTitle(carWorkshop.getTitle());
        existingCarWorkshop.setAddress(carWorkshop.getAddress());
        existingCarWorkshop.setManager(carWorkshop.getManager());

        return carWorkshopRepository.save(existingCarWorkshop);
    }

    public List<Repairman> getRepairmenByCarWorkshopId(Long carWorkshopId) {
        return carWorkshopRepository.findRepairmenById(carWorkshopId);
    }

    public boolean deleteCarWorkshopAndRepairmen(Long carWorkshopId) {
        Optional<CarWorkshop> carWorkshopOptional = carWorkshopRepository.findById(carWorkshopId);
        if (carWorkshopOptional.isPresent()) {
            CarWorkshop carWorkshop = carWorkshopOptional.get();
            List<Repairman> repairmen = repairmanRepository.findByCarWorkshop(carWorkshop);

            for (Repairman repairman : repairmen) {
                repairman.setCarWorkshop(null);
                repairmanRepository.save(repairman);
            }

            carWorkshopRepository.deleteById(carWorkshopId);

            return true;
        } else {
            return false;
        }
    }



}
