package rs.ac.uns.ftn.wines.service.interfaces;

import java.util.List;
import java.util.Optional;

import rs.ac.uns.ftn.wines.domain.Post;
import rs.ac.uns.ftn.wines.dto.PostDTO;

public interface PostService {
	List<Post> getAll();

	Post add(PostDTO dto);

	Optional<Post> getById(int id);

}
