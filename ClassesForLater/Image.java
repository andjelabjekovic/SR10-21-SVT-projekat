package rs.ac.uns.ftn.wines.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Image {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false)
	private String path;
	@Column(nullable = false)
	private Post belongsToPost;
	@Column(nullable = false)
	private User user;
	
	public Image() {}
	
	public Image(int id,String path,Post belongsToPost,  User user) {
		 this.id = id;
		 this.path = path;
		 this.belongsToPost = belongsToPost;
		 this.user = user;
		 
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPath() {
	    return path;
	  }

	
    public void setPath(String path) {
	    this.path = path;
	  }

	public Post getbelongsToPost() {
	    return belongsToPost;
	  }

	
    public void setBelongsToPost (Post belongsToPost) {
	    this.belongsToPost = belongsToPost;
	 
    }
    public User getUser() {
	    return user;
	  }

	
    public void setUser(User user) {
	    this.user = user;
	  }
}  
    
