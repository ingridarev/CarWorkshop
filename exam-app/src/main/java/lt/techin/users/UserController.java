package lt.techin.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;

import java.util.List;

@RestController
@Api(tags = "user-service")
@RequestMapping(value = "api/users")
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping(path="/user/create",method =  RequestMethod.POST)
    public @ResponseBody ResponseEntity<String> createUser(String userName, String password) {

        String username = SecurityContextHolder.getContext().getAuthentication().getName();

        if(!userService.usersUserNameIsUnique(userName))
            return new ResponseEntity<String>("Naudotojas egzistuoja", HttpStatus.BAD_REQUEST);

        userService.createUser(userName, password);

        return new ResponseEntity<String>("Sukurtas naudotojas",HttpStatus.CREATED);

    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public List<Users> getUsers() {
        return userService.getAll();
    }

    @GetMapping(value = "/{userName}",produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public UserDto getUserByUserName(@PathVariable String userName) {
        UserDto userDto = new UserDto();
        Users user = userService.findByUserName(userName);
        userDto.setUserName(user.getUserName());
        userDto.setRole(user.getRole());
        return userDto;
    }

}