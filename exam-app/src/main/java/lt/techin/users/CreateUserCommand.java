package lt.techin.users;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class CreateUserCommand {

    @NotNull
    @Length(min = 1, max = 100)
    private String username;


    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }



}