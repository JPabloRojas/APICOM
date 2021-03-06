package cl.apicom.spring.backend.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="apicom_profile")
@NamedQuery(name="Profile.findAll", query="SELECT p FROM Profile p")
public class Profile {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id", unique = true, nullable = false)
	private long id;
	
	@Column(name = "description", unique = false, nullable = false)
	private String description;

	public long getId() {
		return id;
	}
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@OneToMany(mappedBy = "profile")
	private List<User> user_profile;

	public List<User> getUser_profile() {
		return user_profile;
	}
	public void setUser_profile(List<User> user_profile) {
		this.user_profile = user_profile;
	}
}
