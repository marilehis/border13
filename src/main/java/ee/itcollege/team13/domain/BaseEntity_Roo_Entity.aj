// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ee.itcollege.team13.domain;

import ee.itcollege.team13.domain.BaseEntity;
import java.lang.Integer;
import java.lang.Long;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Version;
import org.springframework.transaction.annotation.Transactional;

privileged aspect BaseEntity_Roo_Entity {
    
    @PersistenceContext
    transient EntityManager BaseEntity.entityManager;
    
    @Version
    @Column(name = "version")
    private Integer BaseEntity.version;
    
    public Integer BaseEntity.getVersion() {
        return this.version;
    }
    
    public void BaseEntity.setVersion(Integer version) {
        this.version = version;
    }
    
    @Transactional
    public void BaseEntity.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void BaseEntity.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public void BaseEntity.clear() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.clear();
    }
    
    public static final EntityManager BaseEntity.entityManager() {
        EntityManager em = new BaseEntity() {
        }.entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static long BaseEntity.countBaseEntitys() {
        return entityManager().createQuery("SELECT COUNT(o) FROM BaseEntity o", Long.class).getSingleResult();
    }
    
    public static List<BaseEntity> BaseEntity.findAllBaseEntitys() {
        return entityManager().createQuery("SELECT o FROM BaseEntity o", BaseEntity.class).getResultList();
    }
    
    public static BaseEntity BaseEntity.findBaseEntity(Long id) {
        if (id == null) return null;
        return entityManager().find(BaseEntity.class, id);
    }
    
    public static List<BaseEntity> BaseEntity.findBaseEntityEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM BaseEntity o", BaseEntity.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
}
