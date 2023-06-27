package lt.techin.api.dto;

import lt.techin.model.CarWorkshop;

import java.util.Objects;

public class RepairmanEntityDto extends RepairmanDto {

    private Long id;

    public RepairmanEntityDto() {
    }

    public RepairmanEntityDto(Long id) {
        this.id = id;
    }

    public RepairmanEntityDto(String name, String surname, String workScope, String city, Double rating, CarWorkshop carWorkshop, Long id) {
        super(name, surname, workScope, city, rating, carWorkshop);
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
        RepairmanEntityDto that = (RepairmanEntityDto) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id);
    }

    @Override
    public String toString() {
        return "RepairmanEntityDto{" +
                "id=" + id +
                '}';
    }
}
