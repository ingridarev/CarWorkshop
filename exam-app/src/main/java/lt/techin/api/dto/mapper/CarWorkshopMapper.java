package lt.techin.api.dto.mapper;

import lt.techin.api.dto.CarWorkshopDto;
import lt.techin.api.dto.CarWorkshopEntityDto;
import lt.techin.model.CarWorkshop;

public class CarWorkshopMapper {

    public static CarWorkshopDto toCarWorkshopDto(CarWorkshop carWorkshop) {
        var carWorkshopDto = new CarWorkshopDto();

        carWorkshopDto.setTitle(carWorkshop.getTitle());
        carWorkshopDto.setAddress(carWorkshop.getAddress());
        carWorkshopDto.setManager(carWorkshop.getManager());


        return carWorkshopDto;
    }

    public static CarWorkshopEntityDto toCarWorkshopEntityDto(CarWorkshop carWorkshop) {
        var carWorkshopDto = new CarWorkshopEntityDto();

        carWorkshopDto.setId(carWorkshop.getId());
        carWorkshopDto.setTitle(carWorkshop.getTitle());
        carWorkshopDto.setAddress(carWorkshop.getAddress());
        carWorkshopDto.setManager(carWorkshop.getManager());

        return carWorkshopDto;
    }

    public static CarWorkshop toCarWorkshop(CarWorkshopDto carWorkshopDto) {
        var carWorkshop = new CarWorkshop();

        carWorkshop.setTitle(carWorkshopDto.getTitle());
        carWorkshop.setAddress(carWorkshopDto.getAddress());
        carWorkshop.setManager(carWorkshopDto.getManager());

        return carWorkshop;
    }

    public static CarWorkshop toCarWorkshopFromEntityDto(CarWorkshopEntityDto carWorkshopDto) {
        var carWorkshop = new CarWorkshop();

        carWorkshop.setId(carWorkshopDto.getId());
        carWorkshop.setTitle(carWorkshopDto.getTitle());
        carWorkshop.setAddress(carWorkshopDto.getAddress());
        carWorkshop.setManager(carWorkshopDto.getManager());

        return carWorkshop;
    }


}
