package ee.itcollege.team13.domain;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.tostring.RooToString;

/**
 * Entity implementation class for Entity: Bed
 *
 */
@Entity
@RooToString
@RooEntity

public class Bed extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@NotNull
	private String bedId;
	
	@NotNull
	private int length;
	
	@NotNull
	private int width;
	
	private String comment;
	

	@OneToMany(mappedBy = "bed")
	private Collection<BorderGuardInBed> borderGuardsInBed;

	@NotNull
	@ManyToOne
	private House house;

	public Bed() {
		super();
	}   
	public String getBedId() {
		return this.bedId;
	}

	public void setBedId(String bedId) {
		this.bedId = bedId;
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
