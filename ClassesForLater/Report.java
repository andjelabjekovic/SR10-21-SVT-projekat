package rs.ac.uns.ftn.wines.domain;

import java.time.LocalDate;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class Report {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private ReportReason reason;
	private LocalDate timesTamp;
	@ManyToOne//*
    @JoinColumn(name="user_id", nullable=false)
	private User byUser;
	private boolean accepted;
	@ManyToOne//mora
    @JoinColumn(name="comment_id", nullable=false)
	private Comment coment;
	
public Report() {}
	
	public Report(int id,ReportReason reason,LocalDate timesTamp,User byUser,boolean accepted,Comment coment) {
		 this.id = id;
		 this.reason = reason;
		 this.timesTamp = timesTamp;
		 this.byUser = byUser;
		 this.accepted = accepted;
		 this.coment = coment;
		
		
		 
	}
	

	public Comment getComent() {
		return coment;
	}

	public void setComent(Comment coment) {
		this.coment = coment;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ReportReason getReason() {
		return reason;
	}

	public void setReason(ReportReason reason) {
		this.reason = reason;
	}

	public LocalDate getTimesTamp() {
		return timesTamp;
	}

	public void setTimesTamp(LocalDate timesTamp) {
		this.timesTamp = timesTamp;
	}

	public User getByUser() {
		return byUser;
	}

	public void setByUser(User byUser) {
		this.byUser = byUser;
	}

	public boolean isAccepted() {
		return accepted;
	}

	public void setAccepted(boolean accepted) {
		this.accepted = accepted;
	}
	

}
