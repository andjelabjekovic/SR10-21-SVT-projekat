package rs.ac.uns.ftn.wines.dto;

public class TokenDTO {

	private String accessToken;

	public TokenDTO() {
	}

	public TokenDTO(String accessTokent) {
		super();
		this.accessToken = accessTokent;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	

}
