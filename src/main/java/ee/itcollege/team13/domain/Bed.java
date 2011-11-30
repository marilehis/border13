package ee.itcollege.team13.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Query;
import javax.validation.constraints.NotNull;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.tostring.RooToString;
import ee.itcollege.team13.domain.RoomEntity;
import javax.persistence.ManyToOne;

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

	@ManyToOne
	private RoomEntity roomEntity;

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
	public RoomEntity getRoomEntity() {
	    return roomEntity;
	}
	public void setRoomEntity(RoomEntity param) {
	    this.roomEntity = param;
	}

    public static List<Bed> findBedsForRoomEntity(RoomEntity room) {
        return entityManager()
    		.createQuery("SELECT o FROM Bed o WHERE o.deleted > NOW() AND o.roomEntity = :room", Bed.class)
    		.setParameter("room", room)
    		.getResultList()
		;
    }
	
    public static List<Bed> findFreeBedsInRoom(Long roomId, Long bgId) {
    	List<Bed> bedsInRoom = new ArrayList<Bed>();
    	System.out.println(roomId.toString());
    	Query q = entityManager().createQuery(
    			"SELECT * FROM Bed AS b " +
    			"JOIN b.boarderguardinbed AS bg " +
    			"WHERE b.roomentity= :roomid && (bg.borderguard= :bgid || bg.borderguard= :''");
    	q.setParameter("roomid",roomId);
    	q.setParameter("bgid",bgId);
    	bedsInRoom = q.getResultList();
    	return bedsInRoom;
    }

}
