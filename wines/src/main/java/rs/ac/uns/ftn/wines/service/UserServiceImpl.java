package rs.ac.uns.ftn.wines.service;
import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.wines.domain.Group;
import rs.ac.uns.ftn.wines.domain.User;
import rs.ac.uns.ftn.wines.domain.enums.Roles;
import rs.ac.uns.ftn.wines.dto.RegistrationDTO;
import rs.ac.uns.ftn.wines.dto.UpdateGroupDTO;
import rs.ac.uns.ftn.wines.dto.UserDTO;
import rs.ac.uns.ftn.wines.repository.UserRepository;
import rs.ac.uns.ftn.wines.service.interfaces.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User findByUsername(String username) {
        Optional<User> user = userRepository.findByUsername(username);
        if (!user.isEmpty()) {
            return user.get();
        }
        return null;
    }

    @Override
    public User createUser(RegistrationDTO userDTO ) {

        Optional<User> user = userRepository.findByUsername(userDTO.getUsername());

        if(user.isPresent()){
            return null;
        }

        User newUser = new User();
        newUser.setId(0);
        newUser.setUsername(userDTO.getUsername());
        newUser.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        newUser.setEmail(userDTO.getEmail());
        newUser.setLastLogin(LocalDate.now());
        newUser.setFirstName(userDTO.getFirstName());
        newUser.setLastName(userDTO.getLastName());
        newUser.setDisplayName(userDTO.getDisplayName());
        newUser.setDescription(userDTO.getDescription());
        newUser.setRole(Roles.USER);
        newUser = userRepository.save(newUser);

        return newUser;
    }
    
    public void changePassword(String password) {
    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		Optional<User> userOpt = userRepository.findByUsername(username);
		if (userOpt.isEmpty()) {
			return ;
		}
		User user = userOpt.get();
		user.setPassword(passwordEncoder.encode(password));
		userRepository.save(user);
    }
    
    @Override
	public User update(UserDTO dto) {
		User user = userRepository.findById(dto.getId()).get();
		if(user == null) {
			return null;
		}
		user.setFirstName(dto.getFirstName());
		user.setLastName(dto.getLastName());
		user.setEmail(dto.getEmail());
		user.setDisplayName(dto.getDisplayName());
		user.setDescription(dto.getDescription());
		
		userRepository.save(user);
		return user;
	}
}