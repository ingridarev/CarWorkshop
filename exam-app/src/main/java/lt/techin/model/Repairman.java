package lt.techin.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Repairman {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;

    private String surname;

    private String workScope;
    private String city;

    private Double rating;

    @ManyToOne
    @JoinColumn(name = "carworkshop_id")
    @JsonIgnore
    private CarWorkshop carWorkshop;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Repairman(){}

    public Repairman(Long id, String name, String surname, String workScope, String city, Double rating, CarWorkshop carWorkshop) {
        this.id = id;
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
        Repairman repairman = (Repairman) o;
        return Objects.equals(id, repairman.id) && Objects.equals(name, repairman.name) && Objects.equals(surname, repairman.surname) && Objects.equals(workScope, repairman.workScope) && Objects.equals(city, repairman.city) && Objects.equals(rating, repairman.rating) && Objects.equals(carWorkshop, repairman.carWorkshop);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, workScope, city, rating, carWorkshop);
    }

    @Override
    public String toString() {
        return "Repairman{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", workScope='" + workScope + '\'' +
                ", city='" + city + '\'' +
                ", rating=" + rating +
                ", carWorkshop=" + carWorkshop +
                '}';
    }
}
