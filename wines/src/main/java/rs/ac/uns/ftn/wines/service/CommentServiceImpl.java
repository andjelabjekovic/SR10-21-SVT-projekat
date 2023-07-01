package rs.ac.uns.ftn.wines.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.wines.domain.Comment;
import rs.ac.uns.ftn.wines.repository.CommentRepository;
import rs.ac.uns.ftn.wines.service.interfaces.CommentService;
@Service
public class CommentServiceImpl implements CommentService {

	

	@Autowired
	public CommentServiceImpl(CommentRepository commentRepository) {
		this.commentRepository = commentRepository;
	}

	 @Autowired
	 CommentRepository commentRepository;

	    @Override
	    public List<Comment> getAll() {
	        return commentRepository.findAll();
	    }

	    @Override
	    public Optional<Comment> getById(int id) {
	        return commentRepository.findById(id);
	    }

	    @Override
	    public Comment save(Comment comment) {
	        try{
	            return commentRepository.save(comment);
	        }catch (IllegalArgumentException e){
	            return null;
	        }
	    }
}
