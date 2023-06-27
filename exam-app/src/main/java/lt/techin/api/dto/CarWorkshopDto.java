package lt.techin.api.dto;

import lt.techin.model.Repairman;

import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CarWorkshopDto {

    private String title;

    private String address;
    private String manager;


    public CarWorkshopDto(){}

    public CarWorkshopDto(String title, String address, String manager) {
        this.title = title;
        this.address = address;
        this.manager = manager;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarWorkshopDto that = (CarWorkshopDto) o;
        return Objects.equals(title, that.title) && Objects.equals(address, that.address) && Objects.equals(manager, that.manager);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, address, manager);
    }

    @Override
    public String toString() {
        return "CarWorkshopDto{" +
                "title='" + title + '\'' +
                ", address='" + address + '\'' +
                ", manager='" + manager + '\'' +
                '}';
    }
}
