package book.library.randlsys.service;

import book.library.randlsys.model.User;
import book.library.randlsys.web.dto.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User save(UserRegistrationDto registrationDto);
}
