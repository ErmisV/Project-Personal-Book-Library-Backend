package book.library.randlsys.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import book.library.randlsys.service.UserService;
import book.library.randlsys.web.dto.UserRegistrationDto;

@Controller
@CrossOrigin (origins = "http://localhost:4200")
@RequestMapping("/registration")
public class UserRegistrationController {

    private final UserService userService;

    public UserRegistrationController(UserService userService) {
        super();
        this.userService = userService;
    }

    @ModelAttribute("user")
    public UserRegistrationDto userRegistrationDto() {
        return new UserRegistrationDto();
    }

    @GetMapping
    public String showRegistrationForm() {
        return "registration";
    }

    @PostMapping
    public String registerUserAccount(@ModelAttribute("user") UserRegistrationDto registrationDto) {
        userService.save(registrationDto);
        return "redirect:/registration?success";
    }

}
