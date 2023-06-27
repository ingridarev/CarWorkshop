package lt.techin.api;

import lt.techin.api.dto.RepairmanDto;
import lt.techin.model.Repairman;
import lt.techin.service.RepairmanService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static lt.techin.api.dto.mapper.RepairmanMapper.toRepairman;
import static lt.techin.api.dto.mapper.RepairmanMapper.toRepairmanDto;
import static org.springframework.http.ResponseEntity.ok;

@Controller
@RequestMapping("/api/v1/repairmans")
public class RepairmanController {



    public static Logger logger = LoggerFactory.getLogger(RepairmanController.class);

    private final RepairmanService repairmanService;

    public RepairmanController(RepairmanService repairmanService) {
        this.repairmanService = repairmanService;
    }

    @GetMapping
    @ResponseBody
    public List<Repairman> getRepairmans() {
        return repairmanService.getAll();
    }

    @GetMapping(value = "/{repairmanId}", produces = {MediaType.APPLICATION_JSON_VALUE})

    public ResponseEntity<Repairman> getRepairmanById(@PathVariable Long repairmanId) {
        var repairmanOptional = repairmanService.getById(repairmanId);

        var responseEntity = repairmanOptional
                .map(repairman -> ok(repairman))
                .orElseGet(() -> ResponseEntity.notFound().build());

        return responseEntity;
    }

    @PostMapping(value = "/{carWorkshopId}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<RepairmanDto> createRepairman(@RequestBody RepairmanDto repairmanDto, @PathVariable Long carWorkshopId) {
        var createdRepairman = repairmanService.create(toRepairman(repairmanDto), carWorkshopId);

        return ok(toRepairmanDto(createdRepairman));
    }
    @DeleteMapping("/{repairmanId}")
    public ResponseEntity<Void> deleteRepairman(@PathVariable Long repairmanId) {
        logger.info("Attempt to delete meal by id: {}", repairmanId);

        boolean deleted = repairmanService.deleteById(repairmanId);
        if (deleted) {
            return ResponseEntity.noContent().build();

        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/{repairmanId}")
    public ResponseEntity<RepairmanDto> updateRepairman(@PathVariable Long repairmanId, @RequestBody RepairmanDto repairmanDto) {
        var updatedRepairman = repairmanService.update(repairmanId, toRepairman(repairmanDto));

        return ok(toRepairmanDto(updatedRepairman));
    }


}

