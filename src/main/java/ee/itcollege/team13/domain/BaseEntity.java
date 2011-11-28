package ee.itcollege.team13.domain;


import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;


import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.tostring.RooToString;
import org.springframework.transaction.annotation.Transactional;


@MappedSuperclass
@RooToString
@RooEntity(mappedSuperclass = true)

public abstract class BaseEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	String createdBy;
	String updatedBy;
	String deletedBy;
	Date created;
	Date updated;
	Date deleted;

	// TODO: muuta kasutaja andmed createdBy, updatedBy, modifiedBy
	
	@PrePersist
    public void recordCreated() {
        setCreated( new Date() );
        setUpdated (new Date(253402207200000L));
        setDeleted (new Date(253402207200000L));
        setCreatedBy ("looja");
    }

    @PreUpdate
    public void recordUpdated() {
        setUpdated( new Date() );
        setUpdatedBy("uuendaja");
    }

    @PreRemove
    public void preventRemove() {
        throw new SecurityException("Removing of records is prohibited!");
    }
	
    @Transactional
    public void remove() {
    	setDeleted(new Date());
    	setDeletedBy ("kustutaja");
    	merge();
    }
    
    
    @Transactional
    public BaseEntity merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        
    	if(this.id != null && !entityManager.contains(this)) {
    		BaseEntity oldEntity = entityManager().find(getClass(), id);
    		if (getCreated() == null)
    			setCreated(oldEntity.getCreated());
    		if (getCreatedBy() == null)
    			setCreatedBy(oldEntity.getCreatedBy());
     		if (getDeleted() == null)
    			setDeleted(oldEntity.getDeleted());
    		if (getDeletedBy() == null)
    			setDeletedBy(oldEntity.getDeletedBy());

    	}
        BaseEntity merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
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
