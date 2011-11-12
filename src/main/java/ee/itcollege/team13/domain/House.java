package ee.itcollege.team13.domain;

import ee.itcollege.team13.domain.BaseEntity;
import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.tostring.RooToString;
import ee.itcollege.team13.domain.Bed;
import java.util.Collection;
import ee.itcollege.team13.domain.HouseType;

/**
 * Entity implementation class for Entity: House
 *
 */
@Entity
@RooToString
@RooEntity

public class House extends BaseEntity implements Serializable {

	@NotNull
	private String houseId;
	
	@NotNull
	private String name;
	
	@NotNull
	private String address;
	
	private String comment;
	private static final long serialVersionUID = 1L;

	@OneToMany(mappedBy = "house")
	private Collection<Bed> beds;

	@ManyToOne
	private HouseType houseType;

	public House() {
		super();
	}   
	public String getHouseId() {
		return this.houseId;
	}

	public void setHouseId(String houseId) {
		this.houseId = houseId;
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}   
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}   
	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	public Collection<Bed> getBeds() {
	    return beds;
	}
	public void setBeds(Collection<Bed> param) {
	    this.beds = param;
	}
	public HouseType getHouseType() {
	    return houseType;
	}
	public void setHouseType(HouseType param) {
	    this.houseType = param;
	}
   
}
