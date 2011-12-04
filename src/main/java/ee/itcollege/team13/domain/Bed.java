package ee.itcollege.team13.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Query;
import javax.validation.constraints.NotNull;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.tostring.RooToString;
import org.springframework.transaction.annotation.Transactional;

import ee.itcollege.team13.domain.RoomEntity;
import javax.persistence.ManyToOne;

/**
 * Entity implementation class for Entity: Bed
 * 
 */
@Entity

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

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("BedId: ").append(getBedId()).append(", ");
    //    sb.append("BorderGuardsInBed: ").append(getBorderGuardsInBed() == null ? "null" : getBorderGuardsInBed().size()).append(", ");
        sb.append("Comment: ").append(getComment()).append(", ");
        sb.append("Id: ").append(getId()).append(", ");
        sb.append("Length: ").append(getLength()).append(", ");
     //   sb.append("RoomEntity: ").append(getRoomEntity()).append(", ");
        sb.append("Version: ").append(getVersion()).append(", ");
        sb.append("Width: ").append(getWidth());
        return sb.toString();
    }
	
	
	public static long countBeds() {
		return entityManager()
				.createQuery(
						"SELECT COUNT(o) FROM Bed o WHERE o.deleted > :ed",
						Long.class).setParameter("ed", effectiveDate())
				.getSingleResult();
	}

	public static List<Bed> findAllBeds() {
		return entityManager()
				.createQuery("SELECT o FROM Bed o WHERE o.deleted > :ed",
						Bed.class).setParameter("ed", effectiveDate())
				.getResultList();
	}

	public static List<Bed> findBedEntries(int firstResult, int maxResults) {
		return entityManager()
				.createQuery("SELECT o FROM Bed o WHERE o.deleted > :ed",
						Bed.class).setParameter("ed", effectiveDate())
				.setFirstResult(firstResult).setMaxResults(maxResults)
				.getResultList();
	}
	
	  @Override
		@Transactional
		public void remove() {

		Collection<BorderGuardInBed> b = getBorderGuardsInBed();

			if (b != null)
				for (BorderGuardInBed i : b)
					i.setEndDate(new Date());

			super.remove();

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

	
//    public static List<Bed> findAllBedsInRoom(Long id) {
//    	List<Bed> bedsInRoom = new ArrayList<Bed>();
//
//    	Object roomId;
//	//	System.out.println(roomId.toString());
//    	Query q = entityManager().createQuery(
//    			"SELECT b FROM Bed b " +
//    			"JOIN b.boarderguardinbed bg " +
//    			"WHERE b.roomentity= :roomid AND (bg.borderguard= :bgid OR bg.borderguard= :empty" +
//    			"ORDER BY bg.borderguard");
//    //	q.setParameter("roomid",roomId);
//    
//	//	q.setParameter("bgid",bgId);
//    	q.setParameter("empty", "");
//    	
//    	bedsInRoom = q.getResultList();
//        return bedsInRoom;
//    }
  

}
