package ee.itcollege.team13.web;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.roo.addon.javabean.RooJavaBean;

import ee.itcollege.team13.domain.Bed;
import ee.itcollege.team13.domain.RoomEntity;

@Configurable
@RooJavaBean
public class HousingReportData {

	@PersistenceContext
	EntityManager entityManager;

	RoomEntity room;
	List<String[]> beds;
	Date date;

	public HousingReportData() {

	}

	public HousingReportData(Date date, List<String[]> beds, RoomEntity room) {

		this.beds = beds;
		this.date = date;
		this.room = room;
	}

	@SuppressWarnings("unchecked")
	public static HousingReportData findBedsForDate(Date date, RoomEntity room) {
		Query q = entityManager().createQuery(
				"SELECT  r.name, null,  count(b) AS beds  "
						+ "  FROM Bed AS b JOIN b.roomEntity AS r "
						+ "  WHERE r = :room "
						+ " AND b.deleted > :date AND r.deleted > :date "
						+ "  GROUP BY r.name");

		q.setParameter("date", date);
		q.setParameter("room", room);
		return new HousingReportData(date, q.getResultList(), room);
	}

	public static final EntityManager entityManager() {
		EntityManager em = new HousingReportData().entityManager;
		if (em == null)
			throw new IllegalStateException(
					"Entity manager has not been injected");
		return em;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public RoomEntity getRoom() {
		return room;
	}

	public void setRoom(RoomEntity room) {
		this.room = room;
	}

	public List<String[]> getBeds() {
		return beds;
	}

	public void setBeds(List<String[]> beds) {
		this.beds = beds;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
