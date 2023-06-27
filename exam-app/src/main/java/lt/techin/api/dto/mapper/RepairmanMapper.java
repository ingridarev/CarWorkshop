package lt.techin.api.dto.mapper;

import lt.techin.api.dto.RepairmanDto;
import lt.techin.api.dto.RepairmanEntityDto;
import lt.techin.model.Repairman;

public class RepairmanMapper {


    public static RepairmanDto toRepairmanDto(Repairman repairman) {
        var repairmanDto = new RepairmanDto();

        repairmanDto.setName(repairman.getName());
        repairmanDto.setSurname(repairman.getSurname());
        repairmanDto.setWorkScope(repairman.getWorkScope());
        repairmanDto.setCity(repairman.getCity());
        repairmanDto.setRating(repairman.getRating());
        repairmanDto.setCarWorkshop(repairman.getCarWorkshop());

        return repairmanDto;
    }

    public static RepairmanEntityDto toRepairmanEntityDto(Repairman repairman) {
        var repairmanDto = new RepairmanEntityDto();

        repairmanDto.setId(repairman.getId());
        repairmanDto.setName(repairman.getName());
        repairmanDto.setSurname(repairman.getSurname());
        repairmanDto.setWorkScope(repairman.getWorkScope());
        repairmanDto.setCity(repairman.getCity());
        repairmanDto.setRating(repairman.getRating());
        repairmanDto.setCarWorkshop(repairman.getCarWorkshop());

        return repairmanDto;
    }

    public static Repairman toRepairman(RepairmanDto repairmanDto) {
        var repairman = new Repairman();

        repairman.setName(repairmanDto.getName());
        repairman.setSurname(repairmanDto.getSurname());
        repairman.setWorkScope(repairmanDto.getWorkScope());
        repairman.setCity(repairmanDto.getCity());
        repairman.setRating(repairmanDto.getRating());
        repairman.setCarWorkshop(repairmanDto.getCarWorkshop());

        return repairman;
    }

    public static Repairman toRepairmanFromEntityDto(RepairmanEntityDto repairmanDto) {
        var repairman = new Repairman();

        repairman.setId(repairmanDto.getId());
        repairman.setName(repairmanDto.getName());
        repairman.setSurname(repairmanDto.getSurname());
        repairman.setWorkScope(repairmanDto.getWorkScope());
        repairman.setCity(repairmanDto.getCity());
        repairman.setRating(repairmanDto.getRating());
        repairman.setCarWorkshop(repairmanDto.getCarWorkshop());

        return repairman;
    }
}
