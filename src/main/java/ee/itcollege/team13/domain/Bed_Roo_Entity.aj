// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ee.itcollege.team13.domain;

import ee.itcollege.team13.domain.Bed;
import java.lang.Long;
import java.util.List;
import javax.persistence.Entity;

privileged aspect Bed_Roo_Entity {
    
    declare @type: Bed: @Entity;
    
    public static long Bed.countBeds() {
        return entityManager().createQuery("SELECT COUNT(o) FROM Bed o", Long.class).getSingleResult();
    }
    
    public static List<Bed> Bed.findAllBeds() {
        return entityManager().createQuery("SELECT o FROM Bed o", Bed.class).getResultList();
    }
    
    public static Bed Bed.findBed(Long id) {
        if (id == null) return null;
        return entityManager().find(Bed.class, id);
    }
    
    public static List<Bed> Bed.findBedEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM Bed o", Bed.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
}