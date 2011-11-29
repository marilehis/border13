package ee.itcollege.team13.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.tostring.RooToString;

/**
 * Entity implementation class for Entity: BorderGuardInBed
 * 
 */
@Entity
@RooToString
@RooEntity
public class BorderGuardInBed extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@NotNull
	@DateTimeFormat(style = "M-")
	private Date startDate;

	@NotNull
	@DateTimeFormat(style = "M-")
	private Date endDate;

	private String comment;

	@NotNull
	@ManyToOne
	private Bed bed;

	@NotNull
	@ManyToOne
	private BorderGuard borderGuard;

	public BorderGuardInBed() {
		super();
	}

	public static long countBorderGuardInBeds() {
		return entityManager()
				.createQuery(
						"SELECT COUNT(o) FROM BorderGuardInBed o WHERE o.deleted > :ed",
						Long.class).setParameter("ed", effectiveDate())
				.getSingleResult();
	}

	public static List<BorderGuardInBed> findAllBorderGuardInBeds() {
		return entityManager()
				.createQuery(
						"SELECT o FROM BorderGuardInBed o WHERE o.deleted > :ed",
						BorderGuardInBed.class)
				.setParameter("ed", effectiveDate()).getResultList();
	}

	public static List<BorderGuardInBed> findBorderGuardInBedEntries(
			int firstResult, int maxResults) {
		return entityManager()
				.createQuery(
						"SELECT o FROM BorderGuardInBed o WHERE o.deleted > :ed",
						BorderGuardInBed.class)
				.setParameter("ed", effectiveDate())
				.setFirstResult(firstResult).setMaxResults(maxResults)
				.getResultList();
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Bed getBed() {
		return bed;
	}

	public void setBed(Bed param) {
		this.bed = param;
	}

	public BorderGuard getBorderGuard() {
		return borderGuard;
	}

	public void setBorderGuard(BorderGuard param) {
		this.borderGuard = param;
	}

}
