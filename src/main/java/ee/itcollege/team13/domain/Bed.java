package ee.itcollege.team13.domain;

import ee.itcollege.team13.domain.BaseEntity;
import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.tostring.RooToString;
import ee.itcollege.team13.domain.BorderGuardInBed;
import java.util.Collection;
import ee.itcollege.team13.domain.House;

/**
 * Entity implementation class for Entity: Space
 *
 */
@Entity
@RooToString
@RooEntity

public class Bed extends BaseEntity implements Serializable {

	@NotNull
	private String spaceId;
	
	@NotNull
	private int length;
	
	@NotNull
	private int width;
	
	private String comment;
	private static final long serialVersionUID = 1L;

	@OneToMany(mappedBy = "bed")
	private Collection<BorderGuardInBed> borderGuardsInBed;

	@ManyToOne
	private House house;

	public Bed() {
		super();
	}   
	public String getSpaceId() {
		return this.spaceId;
	}

	public void setSpaceId(String spaceId) {
		this.spaceId = spaceId;
	}   
	public int getLength() {
		return this.length;
	}

	public void setLength(int length) {
		this.length = length;
	}   
	public int getWidth() {
		return this.width;
	}

	public void setWidth(int width) {
		this.width = width;
	}   
	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	public Collection<BorderGuardInBed> getBorderGuardsInBed() {
	    return borderGuardsInBed;
	}
	public void setBorderGuardsInBed(Collection<BorderGuardInBed> param) {
	    this.borderGuardsInBed = param;
	}
	public House getHouse() {
	    return house;
	}
	public void setHouse(House param) {
	    this.house = param;
	}
   
}
