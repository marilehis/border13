package ee.itcollege.team13.domain;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.tostring.RooToString;
import org.springframework.transaction.annotation.Transactional;

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

	
	
    public static long countRoomTypes() {
        return entityManager().createQuery("SELECT COUNT(o) FROM RoomType o WHERE o.deleted > :ed", Long.class).setParameter("ed", effectiveDate()).getSingleResult();
    }
    
    public static List<RoomType> findAllRoomTypes() {
        return entityManager().createQuery("SELECT o FROM RoomType o WHERE o.deleted > :ed", RoomType.class).setParameter("ed", effectiveDate()).getResultList();
    }
	
    public static List<RoomType> findRoomTypeEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM RoomType o WHERE o.deleted > :ed", RoomType.class).setParameter("ed", effectiveDate()).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    @Override
	@Transactional
	public void remove() {

	Collection<RoomEntity> r = getRoomEntitys();

		if (r != null)
			for (RoomEntity i : r)
				i.setRoomType(null);

		super.remove();

	}
    
    
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

	public static RoomType findRoomTypeByIdString(String id) {
        return entityManager()
			.createQuery("SELECT o FROM RoomType o WHERE o.roomTypeId = :typeId", RoomType.class)
			.setParameter("typeId", id)
			.getSingleResult()
		;
    }   
}
