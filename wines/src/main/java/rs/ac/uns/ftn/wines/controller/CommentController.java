package rs.ac.uns.ftn.wines.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.uns.ftn.wines.domain.Comment;
import rs.ac.uns.ftn.wines.domain.Group;
import rs.ac.uns.ftn.wines.dto.CommentDTO;
import rs.ac.uns.ftn.wines.dto.CreationCommentDTO;
import rs.ac.uns.ftn.wines.dto.GroupDTO;
import rs.ac.uns.ftn.wines.service.interfaces.CommentService;


@RestController
@RequestMapping("api/comments")
public class CommentController {
	private CommentService commentService;

	@Autowired
	public  CommentController( CommentService  commentService) {
		this.commentService = commentService;
	}


	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Comment>> getAll() {

		List<Comment> comments = this.commentService.getAll();

		return new ResponseEntity<List<Comment>>(comments, HttpStatus.OK);
	}
	
	@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<Comment> add(@RequestBody CreationCommentDTO dto) {

		Comment comment = commentService.create(dto);

        return new ResponseEntity<Comment>(comment, HttpStatus.OK);
    } 
	
	@GetMapping(value = "/getCommentsForPost/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CommentDTO>> getAllForPost(@PathVariable int id) {

		List<CommentDTO> dtos = commentService.getAllForPost(id);
		return new ResponseEntity<List<CommentDTO>>(dtos, HttpStatus.OK);
	}
}
































