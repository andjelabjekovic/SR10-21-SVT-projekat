package rs.ac.uns.ftn.wines.service.interfaces;

import java.util.List;
import java.util.Optional;

import rs.ac.uns.ftn.wines.domain.Comment;
import rs.ac.uns.ftn.wines.domain.GroupAdmin;

public interface CommentService {
	List<Comment> getAll();

	Optional<Comment> getById(int id);

	Comment save(Comment comment);

}
