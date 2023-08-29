package rs.ac.uns.ftn.wines.dto;

public class UpdatePostDTO {
	private int id;
	private String content;

	public UpdatePostDTO() {
		super();
	}

	public UpdatePostDTO(int id, String content) {
		super();
		this.id = id;
		this.content = content;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
