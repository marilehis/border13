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

/**
 * Entity implementation class for Entity: Company
 * 
 */
@Entity
@RooToString
@RooEntity
public class Company extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@NotNull
	private String companyID;

	@NotNull
	private String name;

	@OneToMany(mappedBy = "company")
	private Collection<BorderGuardInCompany> borderGuardsInCompany;

	public Company() {
		super();
	}

	public static long countCompanys() {

		return entityManager()
				.createQuery(
						"SELECT COUNT(o) FROM Company o WHERE o.deleted > :ed",
						Long.class).setParameter("ed", effectiveDate())
				.getSingleResult();

	}

	public static List<Company> findAllCompanys() {

		return entityManager()
				.createQuery("SELECT o FROM Company o WHERE o.deleted > :ed",
						Company.class).setParameter("ed", effectiveDate())
				.getResultList();

	}

	public static List<Company> findCompanyEntries(int firstResult,
			int maxResults) {
		return entityManager()
				.createQuery("SELECT o FROM Company o WHERE o.deleted > :ed",
						Company.class).setParameter("ed", effectiveDate())
				.setFirstResult(firstResult).setMaxResults(maxResults)
				.getResultList();

	}

	public String getCompanyID() {
		return this.companyID;
	}

	public void setCompanyID(String companyID) {
		this.companyID = companyID;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Collection<BorderGuardInCompany> getBorderGuardsInCompany() {
		return borderGuardsInCompany;
	}

	public void setBorderGuardsInCompany(Collection<BorderGuardInCompany> param) {
		this.borderGuardsInCompany = param;
	}

}
