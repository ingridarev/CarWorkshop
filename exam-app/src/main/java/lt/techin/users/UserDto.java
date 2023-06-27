package lt.techin.users;

import java.util.Objects;

public class UserDto extends  Users{
    String username;

    Role role;

    public UserDto(){

    }

    public UserDto(Role role, String username, String password, String username1, Role role1) {
        super(role, username, password);
        this.username = username1;
        this.role = role1;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public Role getRole() {
        return role;
    }

    @Override
    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDto userDto = (UserDto) o;
        return Objects.equals(username, userDto.username) && role == userDto.role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, role);
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "username='" + username + '\'' +
                ", role=" + role +
                '}';
    }
}