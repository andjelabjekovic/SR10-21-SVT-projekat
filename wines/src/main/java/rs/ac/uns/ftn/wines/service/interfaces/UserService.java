package rs.ac.uns.ftn.wines.service.interfaces;

import rs.ac.uns.ftn.wines.domain.User;
import rs.ac.uns.ftn.wines.dto.RegistrationDTO;
import rs.ac.uns.ftn.wines.dto.UserDTO;

public interface UserService {

    User findByUsername(String username);

    User createUser(RegistrationDTO userDTO);
    void changePassword(String password);
    User update(UserDTO dto);
}