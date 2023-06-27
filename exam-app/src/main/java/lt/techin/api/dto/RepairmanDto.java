package lt.techin.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lt.techin.model.CarWorkshop;

import java.util.Objects;

public class RepairmanDto {

    private String name;

    private String surname;

    private String workScope;
    private String city;
    private Double rating;

    @JsonIgnore
    private CarWorkshop carWorkshop;

    public RepairmanDto(){}

    public RepairmanDto(String name, String surname, String workScope, String city, Double rating, CarWorkshop carWorkshop) {
        this.name = name;
        this.surname = surname;
        this.workScope = workScope;
        this.city = city;
        this.rating = rating;
        this.carWorkshop = carWorkshop;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getWorkScope() {
        return workScope;
    }

    public void setWorkScope(String workScope) {
        this.workScope = workScope;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public CarWorkshop getCarWorkshop() {
        return carWorkshop;
    }

    public void setCarWorkshop(CarWorkshop carWorkshop) {
        this.carWorkshop = carWorkshop;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RepairmanDto that = (RepairmanDto) o;
        return Objects.equals(name, that.name) && Objects.equals(surname, that.surname) && Objects.equals(workScope, that.workScope) && Objects.equals(city, that.city) && Objects.equals(rating, that.rating) && Objects.equals(carWorkshop, that.carWorkshop);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, workScope, city, rating, carWorkshop);
    }

    @Override
    public String toString() {
        return "RepairmanDto{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", workScope='" + workScope + '\'' +
                ", city='" + city + '\'' +
                ", rating=" + rating +
                ", carWorkshop=" + carWorkshop +
                '}';
    }
}
