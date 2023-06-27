package lt.techin.api.dto;

import lt.techin.model.Repairman;

import java.util.List;
import java.util.Objects;

public class CarWorkshopEntityDto extends CarWorkshopDto{
    private Long id;

    public CarWorkshopEntityDto(){}

    public CarWorkshopEntityDto(Long id) {
        this.id = id;
    }

    public CarWorkshopEntityDto(String title, String address, String manager, Long id) {
        super(title, address, manager);
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CarWorkshopEntityDto that = (CarWorkshopEntityDto) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id);
    }

    @Override
    public String toString() {
        return "CarWorkshopEntityDto{" +
                "id=" + id +
                '}';
    }
}
