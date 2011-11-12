package ee.itcollege.team13.domain;

import ee.itcollege.team13.domain.BaseEntity;
import java.io.Serializable;
import java.lang.String;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.tostring.RooToString;
import ee.itcollege.team13.domain.Bed;
import ee.itcollege.team13.domain.BorderGuard;

/**
 * Entity implementation class for Entity: BorderGuardInBed
 *
 */
@Entity
@RooToString
@RooEntity

public class BorderGuardInBed extends BaseEntity implements Serializable {

	@NotNull
	private Date from;
	
	@NotNull
	private Date to;
	
	private String comment;
	private static final long serialVersionUID = 1L;

	@ManyToOne
	private Bed bed;

	@ManyToOne
	private BorderGuard borderGuard;

	public BorderGuardInBed() {
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
	public Bed getBed() {
	    return bed;
	}
	public void setBed(Bed param) {
	    this.bed = param;
	}
	public BorderGuard getBorderGuard() {
	    return borderGuard;
	}
	public void setBorderGuard(BorderGuard param) {
	    this.borderGuard = param;
	}
   
}
