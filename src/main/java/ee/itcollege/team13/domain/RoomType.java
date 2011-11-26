package ee.itcollege.team13.domain;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.tostring.RooToString;
import ee.itcollege.team13.domain.RoomEntity;

/**
 * Entity implementation class for Entity: RoomEntityType
 */
@Entity
@RooToString
@RooEntity

public class RoomType extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@NotNull
	private String roomTypeId;
	
	@NotNull
	private String name;
	
	private String comment;

	@OneToMany(mappedBy = "roomType")
	private Collection<RoomEntity> roomEntitys;

	
	
	public String getRoomTypeId() {
		return roomTypeId;
	}

	public void setRoomTypeId(String roomTypeId) {
		this.roomTypeId = roomTypeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Collection<RoomEntity> getRoomEntitys() {
	    return roomEntitys;
	}

	public void setRoomEntitys(Collection<RoomEntity> param) {
	    this.roomEntitys = param;
	}



   
}
