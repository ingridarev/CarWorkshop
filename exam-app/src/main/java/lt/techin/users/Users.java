package lt.techin.users;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Entity
public class Users {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;


    private String userName;

    @NotBlank
    @NotEmpty
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    public Users() {

    }

    public Users(Role role, String username, String password) {
        super();
        this.password = password;
        this.userName = username;
        this.role = role;
    }

    public String getUserName() {
        return this.userName;
    }
    public void setUserName(String username) {
        this.userName = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getPassword() {
        return this.password;
    }

    public Role getRole() {
        return this.role;
    }
    public void setRole(Role role) {
        this.role = role;
    }

}