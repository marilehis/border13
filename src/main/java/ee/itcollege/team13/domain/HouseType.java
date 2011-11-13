package ee.itcollege.team13.domain;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.tostring.RooToString;

/**
 * Entity implementation class for Entity: HouseType
 *
 */
@Entity
@RooToString
@RooEntity

public class HouseType extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@NotNull
	private String houseTypeId;
	
	@NotNull
	private String name;
	
	private String comment;


	@OneToMany(mappedBy = "houseType")
	private Collection<House> houses;

	public HouseType() {
		super();
	}   
	public String getHouseTypeId() {
		return this.houseTypeId;
	}

	public void setHouseTypeId(String houseTypeId) {
		this.houseTypeId = houseTypeId;
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}   
	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	public Collection<House> getHouses() {
	    return houses;
	}
	public void setHouses(Collection<House> param) {
	    this.houses = param;
	}
   
}
