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
 * Entity implementation class for Entity: BorderGuardInCompany
 * 
 */
@Entity
@RooToString
@RooEntity
public class BorderGuardInCompany extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@NotNull
	@DateTimeFormat(style = "M-")
	private Date startDate;

	@NotNull
	@DateTimeFormat(style = "M-")
	private Date endDate = notDeleted;

	private String comment;

	@NotNull
	@ManyToOne
	private Company company;

	@NotNull
	@ManyToOne
	private BorderGuard borderGuard;

	public BorderGuardInCompany() {
		super();
	}

	public static long countBorderGuardInCompanys() {
		return entityManager()
				.createQuery(
						"SELECT COUNT(o) FROM BorderGuardInCompany o WHERE o.deleted > :ed",
						Long.class).setParameter("ed", effectiveDate())
				.getSingleResult();
	}

	public static List<BorderGuardInCompany> findAllBorderGuardInCompanys() {
		return entityManager()
				.createQuery(
						"SELECT o FROM BorderGuardInCompany o WHERE o.deleted > :ed",
						BorderGuardInCompany.class)
				.setParameter("ed", effectiveDate()).getResultList();
	}

	public static List<BorderGuardInCompany> findBorderGuardInCompanyEntries(
			int firstResult, int maxResults) {
		return entityManager()
				.createQuery(
						"SELECT o FROM BorderGuardInCompany o WHERE o.deleted > :ed",
						BorderGuardInCompany.class)
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

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company param) {
		this.company = param;
	}

	public BorderGuard getBorderGuard() {
		return borderGuard;
	}

	public void setBorderGuard(BorderGuard param) {
		this.borderGuard = param;
	}

}
