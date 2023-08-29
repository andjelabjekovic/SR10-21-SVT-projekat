package rs.ac.uns.ftn.wines.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.uns.ftn.wines.domain.Post;
import rs.ac.uns.ftn.wines.dto.DeletePostDTO;
import rs.ac.uns.ftn.wines.dto.PostDTO;
import rs.ac.uns.ftn.wines.dto.PostResponseDTO;
import rs.ac.uns.ftn.wines.dto.UpdatePostDTO;
import rs.ac.uns.ftn.wines.service.interfaces.PostService;


@RestController
@CrossOrigin
@RequestMapping("api/posts")
public class PostController {
	private PostService postService;

	@Autowired
	public PostController(PostService postService) {
		this.postService = postService;
	}

	@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
	@GetMapping( produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<PostResponseDTO>> getAll() {

		List<PostResponseDTO> dtos = this.postService.getAll();
		

		return new ResponseEntity<List<PostResponseDTO>>(dtos, HttpStatus.OK);
	}
	
	@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
	@GetMapping( value = "/getPostsForLogged", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<PostResponseDTO>> getPostsForLoggedUser() {

		List<Post> posts = this.postService.getAllForLogged();
		ArrayList<PostResponseDTO> dtos = new ArrayList<PostResponseDTO>();
		for(Post post : posts) {
			dtos.add(new PostResponseDTO(post));
		}

		return new ResponseEntity<List<PostResponseDTO>>(dtos, HttpStatus.OK);
	}
	
	@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<Post> add(@RequestBody PostDTO dto) {

		Post post = postService.add(dto);

        return new ResponseEntity<Post>(post, HttpStatus.OK);
    }
	
	@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @PutMapping( produces = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<Post> update(@RequestBody UpdatePostDTO dto) {

		Post post = postService.update(dto);
		if(post == null) {
			return new ResponseEntity<Post>(HttpStatus.NOT_FOUND);
		}

        return new ResponseEntity<Post>(post, HttpStatus.OK);
    }
	
	@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @DeleteMapping(value="/{id}", produces = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<?> delete(@PathVariable int id) {

		 postService.delete(id);
		

        return new ResponseEntity(HttpStatus.OK);
    }

}
