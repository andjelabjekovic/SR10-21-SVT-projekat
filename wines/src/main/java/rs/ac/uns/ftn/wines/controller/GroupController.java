package rs.ac.uns.ftn.wines.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.uns.ftn.wines.domain.Group;
import rs.ac.uns.ftn.wines.domain.Post;
import rs.ac.uns.ftn.wines.dto.GroupDTO;
import rs.ac.uns.ftn.wines.dto.GroupResponseDTO;
import rs.ac.uns.ftn.wines.dto.PostResponseDTO;
import rs.ac.uns.ftn.wines.dto.UpdateGroupDTO;
import rs.ac.uns.ftn.wines.service.interfaces.GroupService;

@RestController
@CrossOrigin
@RequestMapping("api/groups")
public class GroupController {
	private GroupService groupService;

	@Autowired
	public GroupController(GroupService groupService) {
		this.groupService = groupService;
	}

	@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
	@GetMapping( produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<GroupResponseDTO>> getAll() {

		List<Group> groups = this.groupService.getAll();
		ArrayList<GroupResponseDTO> dtos = new ArrayList<GroupResponseDTO>();
		for(Group group : groups) {
			dtos.add(new GroupResponseDTO(group));
		}
		return new ResponseEntity<List<GroupResponseDTO>>(dtos, HttpStatus.OK);
	}
	@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<Group> add(@RequestBody GroupDTO dto) {

		Group group = groupService.add(dto);

        return new ResponseEntity<Group>(group, HttpStatus.OK);
    } 
	
	@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @PutMapping( produces = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<Group> update(@RequestBody UpdateGroupDTO dto) {

		Group group = groupService.update(dto);
		if(group == null) {
			return new ResponseEntity<Group>(HttpStatus.NOT_FOUND);
		}

        return new ResponseEntity<Group>(group, HttpStatus.OK);
    }
	
	@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
	@GetMapping( value = "/getGroupsForLogged", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<GroupResponseDTO>> getGroupsForLoggedUser() {

		List<Group> groups = this.groupService.getAllForLogged();
		ArrayList<GroupResponseDTO> dtos = new ArrayList<GroupResponseDTO>();
		for(Group group : groups) {
			dtos.add(new GroupResponseDTO(group));
		}

		return new ResponseEntity<List<GroupResponseDTO>>(dtos, HttpStatus.OK);
	}
}
