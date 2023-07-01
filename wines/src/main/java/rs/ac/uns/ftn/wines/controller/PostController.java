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

import rs.ac.uns.ftn.wines.domain.Post;
import rs.ac.uns.ftn.wines.dto.PostDTO;
import rs.ac.uns.ftn.wines.service.interfaces.PostService;


@RestController
@RequestMapping("api/posts")
public class PostController {
	private PostService postService;

	@Autowired
	public PostController(PostService postService) {
		this.postService = postService;
	}

	@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
	@GetMapping( produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Post>> getAll() {

		List<Post> posts = this.postService.getAll();

		return new ResponseEntity<>(posts, HttpStatus.OK);
	}
	
	@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<Post> add(@RequestBody PostDTO dto) {

		Post post = postService.add(dto);

        return new ResponseEntity<Post>(post, HttpStatus.OK);
    }

}
