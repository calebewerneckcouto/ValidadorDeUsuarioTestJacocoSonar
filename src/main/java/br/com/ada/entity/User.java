package br.com.ada.entity;

public class User {

    private String email;
    private String name;
    private Boolean verified;

    public User(String email, String name) {
        this.email = email;
        this.name = name;
        this.verified = false;
    }

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getVerified() {
		return verified;
	}

	public void setVerified(Boolean verified) {
		this.verified = verified;
	}
    
    
    

}
