package rs.ac.uns.ftn.wines.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class Banned {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false)
	private LocalDate timesTamp;
	@Column(nullable = false)
	private User userTowards;
	@Column(nullable = false)
	private GroupAdmin groupAdmin;
	@ManyToOne//*
    @JoinColumn(name="group_admin_id", nullable=false)
	private Administrator administrator;
	@ManyToOne//*
    @JoinColumn(name="group_id", nullable=false)
	private Group group;
	
	Banned() {}
	
	public Banned(int id,LocalDate timesTamp, User userTowards, GroupAdmin groupAdmin,Administrator administrator, Group group) {
		
		 this.id=id;
		 this.timesTamp = timesTamp;
		 this.userTowards = userTowards;
		 this.groupAdmin = groupAdmin;
		 this.administrator = administrator;
		 this.group = group;
	}

	public Administrator getAdministrator() {
		return administrator;
	}

	public void setAdministrator(Administrator administrator) {
		this.administrator = administrator;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public GroupAdmin getGroupAdmin() {
		return groupAdmin;
	}

	public void setGroupAdmin(GroupAdmin groupAdmin) {
		this.groupAdmin = groupAdmin;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getTimesTamp() {
		return timesTamp;
	}

	public void setTimesTamp(LocalDate timesTamp) {
		this.timesTamp = timesTamp;
	}

	public User getUserTowards() {
		return userTowards;
	}

	public void setUserTowards(User userTowards) {
		this.userTowards = userTowards;
	}

}
