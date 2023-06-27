package lt.techin.users;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FirstUser {

    @Autowired
    UserRepo userRepo;

    @Autowired
    UserService userService;

    @PostConstruct
    public void createFirstUser() throws Exception {

        if(userRepo.findByRole(Role.USER).size() == 0 ) {
            userService.createUser("admin", "admin",Role.ADMIN);

        }

    }
}