package ee.itcollege.team13.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.tostring.RooToString;

/**
 * Entity implementation class for Entity: BorderGuardInCompany
 *
 */
@Entity
@RooToString
@RooEntity

public class BorderGuardInCompany extends BaseEntity implements Serializable {

	@NotNull
	private Date from;
	
	@NotNull
	private Date to;
	
	private String comment;
	private static final long serialVersionUID = 1L;

	@ManyToOne
	private Company company;

	@ManyToOne
	private BorderGuard borderGuard;

	public BorderGuardInCompany() {
		super();
	}   
	public Date getFrom() {
		return this.from;
	}

	public void setFrom(Date from) {
		this.from = from;
	}   
	public Date getTo() {
		return this.to;
	}

	public void setTo(Date to) {
		this.to = to;
	}   
	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	public Company getCompany() {
	    return company;
	}
	public void setCompany(Company param) {
	    this.company = param;
	}
	public BorderGuard getBorderGuard() {
	    return borderGuard;
	}
	public void setBorderGuard(BorderGuard param) {
	    this.borderGuard = param;
	}
   
}
