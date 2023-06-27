package lt.techin.users;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<Users, Long> {

    Users findByUserName(String username);
    List<Users> findByRole(Role role);
    void deleteByUserName(String username);



}