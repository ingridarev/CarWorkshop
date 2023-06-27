package lt.techin.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class CarWorkshop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String title;

    private String address;

    private String manager;

//    @OneToMany(mappedBy = "carworkshop")
//    private List<Repairman> repairmans = new ArrayList<>();

    public CarWorkshop(){}

    public CarWorkshop(Long id, String title, String address, String manager) {
        this.id = id;
        this.title = title;
        this.address = address;
        this.manager = manager;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        CarWorkshop that = (CarWorkshop) o;
        return Objects.equals(id, that.id) && Objects.equals(title, that.title) && Objects.equals(address, that.address) && Objects.equals(manager, that.manager);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, address, manager);
    }

    @Override
    public String toString() {
        return "CarWorkshop{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", address='" + address + '\'' +
                ", manager='" + manager + '\'' +
                '}';
    }
}
