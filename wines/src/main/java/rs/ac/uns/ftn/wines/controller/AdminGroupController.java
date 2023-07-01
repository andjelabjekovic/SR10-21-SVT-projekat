package rs.ac.uns.ftn.wines.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.uns.ftn.wines.domain.GroupAdmin;
import rs.ac.uns.ftn.wines.service.interfaces.AdminGroupService;


@RestController
@RequestMapping("api/adminGroups")
public class AdminGroupController {
	private AdminGroupService adminGroupService;

	@Autowired
	public AdminGroupController(AdminGroupService adminGroupService) {
		this.adminGroupService = adminGroupService;
	}

	@PreAuthorize("hasAnyAuthority('WINE_USER, ADMIN')")
	@GetMapping( produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<GroupAdmin>> getAll() {

		List<GroupAdmin> adminGroups = this.adminGroupService.getAll();

		return new ResponseEntity<List<GroupAdmin>>(adminGroups, HttpStatus.OK);
	}
	

}
