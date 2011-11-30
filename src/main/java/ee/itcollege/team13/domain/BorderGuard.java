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

/**
 * Entity implementation class for Entity: BorderGuard
 * 
 */
@Entity
@RooToString
@RooEntity
public class BorderGuard extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@NotNull
	private String borderGuardId;

	@NotNull
	private String nameFirst;

	@NotNull
	private String nameLast;

	@NotNull
	private Character sex;

	@NotNull
	private String personalId;

	private String comment;

	@OneToMany(mappedBy = "borderGuard")
	private Collection<BorderGuardInCompany> borderGuardsInCompany;

	@OneToMany(mappedBy = "borderGuard")
	private Collection<BorderGuardInBed> borderGuardsInBed;

	public BorderGuard() {
		super();
	}

	public static long countBorderGuards() {
		return entityManager()
				.createQuery(
						"SELECT COUNT(o) FROM BorderGuard o WHERE o.deleted > :ed",
						Long.class).setParameter("ed", effectiveDate())
				.getSingleResult();
	}

	public static List<BorderGuard> findAllBorderGuards() {
		return entityManager()
				.createQuery(
						"SELECT o FROM BorderGuard o WHERE o.deleted > :ed",
						BorderGuard.class).setParameter("ed", effectiveDate())
				.getResultList();
	}

	public static List<BorderGuard> findBorderGuardEntries(int firstResult,
			int maxResults) {
		return entityManager()
				.createQuery(
						"SELECT o FROM BorderGuard o WHERE o.deleted > :ed",
						BorderGuard.class).setParameter("ed", effectiveDate())
				.setFirstResult(firstResult).setMaxResults(maxResults)
				.getResultList();
	}

	@Override
	@Transactional
	public void remove() {

		Collection<BorderGuardInCompany> c = getBorderGuardsInCompany();
		Collection<BorderGuardInBed> b = getBorderGuardsInBed();

		if (c != null)
			for (BorderGuardInCompany i : c)
				i.setEndDate(new Date());

		if (b != null)
			for (BorderGuardInBed i : b)
				i.setEndDate(new Date());

		super.remove();

	}

	public String getBorderGuardId() {
		return this.borderGuardId;
	}

	public void setBorderGuardId(String borderGuardId) {
		this.borderGuardId = borderGuardId;
	}

	public String getNameFirst() {
		return this.nameFirst;
	}

	public void setNameFirst(String nameFirst) {
		this.nameFirst = nameFirst;
	}

	public String getNameLast() {
		return this.nameLast;
	}

	public void setNameLast(String nameLast) {
		this.nameLast = nameLast;
	}

	public Character getSex() {
		return this.sex;
	}

	public void setSex(Character sex) {
		this.sex = sex;
	}

	public String getPersonalId() {
		return this.personalId;
	}

	public void setPersonalId(String personalId) {
		this.personalId = personalId;
	}

	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Collection<BorderGuardInCompany> getBorderGuardsInCompany() {
		return borderGuardsInCompany;
	}

	public void setBorderGuardsInCompany(Collection<BorderGuardInCompany> param) {
		this.borderGuardsInCompany = param;
	}

	public Collection<BorderGuardInBed> getBorderGuardsInBed() {
		return borderGuardsInBed;
	}

	public void setBorderGuardsInBed(Collection<BorderGuardInBed> param) {
		this.borderGuardsInBed = param;
	}

}
