package rs.ac.uns.ftn.wines.service.interfaces;

import java.util.List;
import java.util.Optional;

import rs.ac.uns.ftn.wines.domain.Post;
import rs.ac.uns.ftn.wines.dto.PostDTO;
import rs.ac.uns.ftn.wines.dto.PostResponseDTO;
import rs.ac.uns.ftn.wines.dto.UpdatePostDTO;

public interface PostService {
	List<PostResponseDTO> getAll();
	List<Post> getAllForLogged();

	Post add(PostDTO dto);
	Post update(UpdatePostDTO dto);
	void delete(int id);

	Optional<Post> getById(int id);

}
