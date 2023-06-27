package lt.techin.api;

import lt.techin.api.dto.CarWorkshopDto;
import lt.techin.api.dto.CarWorkshopEntityDto;
import lt.techin.api.dto.mapper.CarWorkshopMapper;
import lt.techin.exception.CarWorkshopValidationException;
import lt.techin.model.CarWorkshop;
import lt.techin.service.CarWorkshopService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static lt.techin.api.dto.mapper.CarWorkshopMapper.toCarWorkshop;
import static lt.techin.api.dto.mapper.CarWorkshopMapper.toCarWorkshopDto;
import static org.springframework.http.ResponseEntity.ok;

@Controller
@RequestMapping("/api/v1/carWorkshops")
@Validated
public class CarWorkshopController {

    public static Logger logger = LoggerFactory.getLogger(CarWorkshopController.class);

    private final CarWorkshopService carWorkshopService;

    public CarWorkshopController(CarWorkshopService carWorkshopService) {
        this.carWorkshopService = carWorkshopService;
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public List<CarWorkshopEntityDto> getCarWorkshops() {
        return carWorkshopService.getAll().stream()
                .map(CarWorkshopMapper::toCarWorkshopEntityDto)
                .collect(toList());
    }


    @GetMapping(value = "/{carWorkshopId}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<CarWorkshop> getCarWorkshop(@PathVariable Long carWorkshopId) {
        var carWorkshopOptional = carWorkshopService.getById(carWorkshopId);

        var responseEntity = carWorkshopOptional
                .map(carWorkshop -> ok(carWorkshop))
                .orElseGet(() -> ResponseEntity.notFound().build());

        return responseEntity;
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<CarWorkshopDto> createCarWorkshop(@RequestBody CarWorkshopDto carWorkshopDto) {

        if (carWorkshopService.carWorkshopTitleIsUnique(toCarWorkshop(carWorkshopDto))) {
            var createdMenu = carWorkshopService.create(toCarWorkshop(carWorkshopDto));
            return ok(carWorkshopDto);
        } else {
            throw new CarWorkshopValidationException("Menu already exists", "Menu title", "Already exists", carWorkshopDto.getTitle());
        }
    }

    @DeleteMapping("/{carWorkshopId}")
    public ResponseEntity<Void> deleteCarWorkshop(@PathVariable Long carWorkshopId) {
        logger.info("Attempt to delete carWorkshop by id: {}", carWorkshopId);

        boolean deleted = carWorkshopService.deleteById(carWorkshopId);
        if (deleted) {
            return ResponseEntity.noContent().build();

        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/{carWorkshopId}")
    public ResponseEntity<CarWorkshopDto> updateCarWorkshop(@PathVariable Long carWorkshopId, @RequestBody CarWorkshopDto carWorkshopDto) {
        var updatedCarWorkshop = carWorkshopService.update(carWorkshopId, toCarWorkshop(carWorkshopDto));

        return ok(toCarWorkshopDto(updatedCarWorkshop));
    }


}

