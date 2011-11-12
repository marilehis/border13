package ee.itcollege.team13.domain;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.tostring.RooToString;

/**
 * Entity implementation class for Entity: BorderGuard
 *
 */
@Entity
@RooToString
@RooEntity

public class BorderGuard extends BaseEntity implements Serializable {

	@NotNull
	private String borderGuardId;
	
	@NotNull
	private String nameFirst;
	
	@NotNull
	private String nameLast;
	
	@NotNull
	private String sex;
	
	@NotNull
	private String personalId;
	
	private String comment;
	private static final long serialVersionUID = 1L;

	@OneToMany(mappedBy = "borderGuard")
	private Collection<BorderGuardInCompany> borderGuardsInCompany;

	@OneToMany(mappedBy = "borderGuard")
	private Collection<BorderGuardInBed> borderGuardsInBed;

	public BorderGuard() {
		super();
	}   
	public String getBorderGuardId() {
		return this.borderGuardId;
	}

	public void setBorderGuardId(String borderGuardId) {
		this.borderGuardId = borderGuardId;
	}   
	public String getNameFirst() {
		return this.nameFirst;
	}

	public void setNameFirst(String nameFirst) {
		this.nameFirst = nameFirst;
	}   
	public String getNameLast() {
		return this.nameLast;
	}

	public void setNameLast(String nameLast) {
		this.nameLast = nameLast;
	}   
	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}   
	public String getPersonalId() {
		return this.personalId;
	}

	public void setPersonalId(String personalId) {
		this.personalId = personalId;
	}   
	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	public Collection<BorderGuardInCompany> getBorderGuardsInCompany() {
	    return borderGuardsInCompany;
	}
	public void setBorderGuardsInCompany(Collection<BorderGuardInCompany> param) {
	    this.borderGuardsInCompany = param;
	}
	public Collection<BorderGuardInBed> getBorderGuardsInBed() {
	    return borderGuardsInBed;
	}
	public void setBorderGuardsInBed(Collection<BorderGuardInBed> param) {
	    this.borderGuardsInBed = param;
	}
   
}
