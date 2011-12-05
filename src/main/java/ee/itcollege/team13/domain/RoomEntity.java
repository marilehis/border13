package ee.itcollege.team13.domain;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.tostring.RooToString;
import org.springframework.transaction.annotation.Transactional;

import ee.itcollege.team13.domain.AdminUnit;

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

	@ManyToOne
	private AdminUnit adminUnit;

	public RoomEntity() {
		super();
	}

	public static long countRoomEntitys() {
		return entityManager()
				.createQuery(
						"SELECT COUNT(o) FROM RoomEntity o WHERE o.deleted > :ed",
						Long.class).setParameter("ed", effectiveDate())
				.getSingleResult();
	}

	public static List<RoomEntity> findAllRoomEntitys() {
		return entityManager()
				.createQuery(
						"SELECT o FROM RoomEntity o WHERE o.deleted > :ed",
						RoomEntity.class).setParameter("ed", effectiveDate())
				.getResultList();
	}

	public static List<RoomEntity> findRoomEntityEntries(int firstResult,
			int maxResults) {
		return entityManager()
				.createQuery(
						"SELECT o FROM RoomEntity o WHERE o.deleted > :ed",
						RoomEntity.class).setParameter("ed", effectiveDate())
				.setFirstResult(firstResult).setMaxResults(maxResults)
				.getResultList();
	}

	public static List<RoomEntity> findParentRoomEntitys() {
		
		return entityManager()
				.createQuery(
						"SELECT o FROM RoomEntity o WHERE o.deleted > :ed " +
						"AND o.parentRoomEntity IS NULL",
						RoomEntity.class).setParameter("ed", effectiveDate())
						
				.getResultList();
	}	
	
	public static List<RoomEntity> findChildRoomEntitys(Long id) {
		return entityManager()
				.createQuery(
						"SELECT o FROM RoomEntity o WHERE o.deleted > :ed AND " +
						"o.parentRoomEntity = :pID",
						RoomEntity.class).setParameter("ed", effectiveDate()).setParameter("pID", id)
						
				.getResultList();
	}		
	

	public static List<RoomEntity> findAllRoomEntitysByDate(Date date) {
		return entityManager()
				.createQuery(
						"SELECT o FROM RoomEntity o WHERE o.deleted > :ed",
						RoomEntity.class).setParameter("ed", effectiveDate())
				.getResultList();
	}
	
	
    @Override
	@Transactional
	public void remove() {
	Collection<Bed> beds = getBeds();
	Collection<RoomEntity> rooms = getChildRoomEntitys();
		if (beds != null) {
			for (Bed b : beds) {
				b.remove();
			}
		}
		
		if (rooms != null) {
			for (RoomEntity r : rooms) {
				r.remove();
			}
		}

		super.remove();

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
	
	public int getBedCount() {
		return beds != null ? beds.size() : 0;
	}

	public void setBeds(Collection<Bed> param) {
		this.beds = param;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public AdminUnit getAdminUnit() {
		return adminUnit;
	}

	public void setAdminUnit(AdminUnit param) {
		this.adminUnit = param;
	}

}
