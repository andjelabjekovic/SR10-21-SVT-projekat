package rs.ac.uns.ftn.wines.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.uns.ftn.wines.domain.Reaction;
import rs.ac.uns.ftn.wines.dto.ReactionDTO;
import rs.ac.uns.ftn.wines.dto.ReactionResponseDTO;
import rs.ac.uns.ftn.wines.service.interfaces.ReactionService;

@RestController
@RequestMapping("api/reactions")
public class ReactionController {
	private ReactionService reactionService;

	@Autowired
	public  ReactionController( ReactionService  reactionService) {
		this.reactionService = reactionService;
	}

	@PreAuthorize("hasAnyRole('USER, ADMIN')")
	@GetMapping( produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Reaction>> getAll() {

		List<Reaction> reactions = this.reactionService.getAll();

		return new ResponseEntity<>(reactions, HttpStatus.OK);
	}
	
	@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ReactionResponseDTO> add(@RequestBody ReactionDTO dto) {

		Reaction reaction = reactionService.add(dto);
		ReactionResponseDTO dtoResponse = new ReactionResponseDTO(reaction);
		
        return new ResponseEntity<ReactionResponseDTO>(dtoResponse, HttpStatus.OK);
    }

}
