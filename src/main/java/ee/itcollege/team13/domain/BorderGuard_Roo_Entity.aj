// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ee.itcollege.team13.domain;

import ee.itcollege.team13.domain.BorderGuard;
import java.lang.Long;
import java.util.List;
import javax.persistence.Entity;

privileged aspect BorderGuard_Roo_Entity {
    
    declare @type: BorderGuard: @Entity;
    
    public static long BorderGuard.countBorderGuards() {
        return entityManager().createQuery("SELECT COUNT(o) FROM BorderGuard o", Long.class).getSingleResult();
    }
    
    public static List<BorderGuard> BorderGuard.findAllBorderGuards() {
        return entityManager().createQuery("SELECT o FROM BorderGuard o", BorderGuard.class).getResultList();
    }
    
    public static BorderGuard BorderGuard.findBorderGuard(Long id) {
        if (id == null) return null;
        return entityManager().find(BorderGuard.class, id);
    }
    
    public static List<BorderGuard> BorderGuard.findBorderGuardEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM BorderGuard o", BorderGuard.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
}
