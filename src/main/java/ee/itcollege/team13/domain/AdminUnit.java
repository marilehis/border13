package ee.itcollege.team13.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.tostring.RooToString;
import ee.itcollege.team13.domain.RoomEntity;
import java.util.Collection;
import java.util.List;

import javax.persistence.OneToMany;

/**
 * Entity implementation class for Entity: AdminUnit
 *
 */
@Entity
@RooToString
@RooEntity

public class AdminUnit extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	
	@NotNull
	private String adminUnitId;
	
	@NotNull
	private String adminUnitName;


	@OneToMany(mappedBy = "adminUnit")
	private Collection<RoomEntity> roomEntitys;


	public AdminUnit() {
		super();
	}

	public String getAdminUnitId() {
		return adminUnitId;
	}

	public void setAdminUnitId(String adminUnitId) {
		this.adminUnitId = adminUnitId;
	}

	public String getAdminUnitName() {
		return adminUnitName;
	}

	public void setAdminUnitName(String adminUnitName) {
		this.adminUnitName = adminUnitName;
	}

	public Collection<RoomEntity> getRoomEntitys() {
	    return roomEntitys;
	}

	public void setRoomEntitys(Collection<RoomEntity> param) {
	    this.roomEntitys = param;
	}
	
	/*public static List<AdminUnit> findAllAdminUnits(){
		return entityManager().createQuery("SELECT o FROM adminunit", AdminUnit.class).getResultList();
	}*/

}
