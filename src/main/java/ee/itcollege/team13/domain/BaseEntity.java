package ee.itcollege.team13.domain;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.tostring.RooToString;


@MappedSuperclass
@RooToString
@RooEntity(mappedSuperclass = true)

public abstract class BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
//	@NotNull
	String createdBy;
	
//	@NotNull
	String updatedBy;
	
//	@NotNull
	String deletedBy;
	
//	@NotNull
	Date created;
	
//	@NotNull
	Date updated;
	
//	@NotNull
	Date deleted;
	
	protected String getCreatedBy() {
		return createdBy;
	}

	protected void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	protected String getUpdatedBy() {
		return updatedBy;
	}

	protected void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	protected String getDeletedBy() {
		return deletedBy;
	}

	protected void setDeletedBy(String deletedBy) {
		this.deletedBy = deletedBy;
	}

	protected Date getCreated() {
		return created;
	}

	protected void setCreated(Date created) {
		this.created = created;
	}

	protected Date getUpdated() {
		return updated;
	}

	protected void setUpdated(Date updated) {
		this.updated = updated;
	}

	protected Date getDeleted() {
		return deleted;
	}

	protected void setDeleted(Date deleted) {
		this.deleted = deleted;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
