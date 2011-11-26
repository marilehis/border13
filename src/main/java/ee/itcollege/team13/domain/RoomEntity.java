package ee.itcollege.team13.domain;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.tostring.RooToString;
import ee.itcollege.team13.domain.Bed;

/**
 * Entity implementation class for Entity: RoomEntity
 *
 */
@Entity
@RooToString
@RooEntity

public class RoomEntity extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@NotNull
	private String roomEntityId;
	
	@NotNull
	private String name;
	
	@NotNull
	private String address;
	
	private String comment;

	@ManyToOne
	private RoomType roomType;

	@ManyToOne
	private RoomEntity parentRoomEntity;

	@OneToMany(mappedBy = "parentRoomEntity")
	private Collection<RoomEntity> childRoomEntitys;

	@OneToMany(mappedBy = "roomEntity")
	private Collection<Bed> beds;

	public RoomEntity() {
		super();
	}   
	public String getRoomEntityId() {
		return this.roomEntityId;
	}

	public void setRoomEntityId(String roomEntityId) {
		this.roomEntityId = roomEntityId;
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
	public RoomType getRoomType() {
	    return roomType;
	}
	public void setRoomType(RoomType param) {
	    this.roomType = param;
	}
	public RoomEntity getParentRoomEntity() {
	    return parentRoomEntity;
	}
	public void setParentRoomEntity(RoomEntity param) {
	    this.parentRoomEntity = param;
	}
	public Collection<RoomEntity> getChildRoomEntitys() {
	    return childRoomEntitys;
	}
	public void setChildRoomEntitys(Collection<RoomEntity> param) {
	    this.childRoomEntitys = param;
	}
	public Collection<Bed> getBeds() {
	    return beds;
	}
	public void setBeds(Collection<Bed> param) {
	    this.beds = param;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}




	}
   

