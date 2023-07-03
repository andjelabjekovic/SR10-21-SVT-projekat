package rs.ac.uns.ftn.wines.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.uns.ftn.wines.domain.Post;
import rs.ac.uns.ftn.wines.domain.User;
import rs.ac.uns.ftn.wines.dto.ChangePasswordDTO;
import rs.ac.uns.ftn.wines.dto.LoginDTO;
import rs.ac.uns.ftn.wines.dto.RegistrationDTO;
import rs.ac.uns.ftn.wines.dto.TokenDTO;
import rs.ac.uns.ftn.wines.security.TokenUtils;
import rs.ac.uns.ftn.wines.service.interfaces.UserService;


@RestController
@RequestMapping("api/users")
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    UserDetailsService userDetailsService;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    TokenUtils tokenUtils;


    @PostMapping
    public ResponseEntity<RegistrationDTO> create(@RequestBody RegistrationDTO newUser){

        User createdUser = userService.createUser(newUser);

        if(createdUser == null){
            return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
        }
        RegistrationDTO userDTO = new RegistrationDTO(createdUser);

        return new ResponseEntity<>(userDTO, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<TokenDTO> login(@RequestBody LoginDTO userDto) {
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(userDto.getUsername(), userDto.getPassword());
        Authentication authentication;
        try {
        	authentication = authenticationManager.authenticate(authenticationToken);
        	
        }catch(BadCredentialsException e1) {
        	return ResponseEntity.notFound().build();
        }
        SecurityContextHolder.getContext().setAuthentication(authentication);
        try {
            UserDetails userDetails = userDetailsService.loadUserByUsername(userDto.getUsername());
            return ResponseEntity.ok(new TokenDTO(tokenUtils.generateToken(userDetails)));
        } catch (UsernameNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
    
	@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @PostMapping("/changePassword")
    public ResponseEntity<String> changePassword(@RequestBody ChangePasswordDTO dto) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		
		
		
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(username, dto.getOldPassword());
        try {
        	authentication = authenticationManager.authenticate(authenticationToken);
        	
        }catch(BadCredentialsException e1) {
        	return ResponseEntity.notFound().build();
        }
        userService.changePassword(dto.getNewPassword());
        return new ResponseEntity<String>("Password changed", HttpStatus.OK);
        
    }
}