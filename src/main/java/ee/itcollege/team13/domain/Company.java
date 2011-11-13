package ee.itcollege.team13.domain;

import java.io.Serializable;
import java.util.Collection;

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
