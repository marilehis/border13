// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ee.itcollege.team13.domain;

import ee.itcollege.team13.domain.BorderGuardInCompany;
import java.lang.Long;
import java.util.List;
import javax.persistence.Entity;

privileged aspect BorderGuardInCompany_Roo_Entity {
    
    declare @type: BorderGuardInCompany: @Entity;
    
    public static long BorderGuardInCompany.countBorderGuardInCompanys() {
        return entityManager().createQuery("SELECT COUNT(o) FROM BorderGuardInCompany o", Long.class).getSingleResult();
    }
    
    public static List<BorderGuardInCompany> BorderGuardInCompany.findAllBorderGuardInCompanys() {
        return entityManager().createQuery("SELECT o FROM BorderGuardInCompany o", BorderGuardInCompany.class).getResultList();
    }
    
    public static BorderGuardInCompany BorderGuardInCompany.findBorderGuardInCompany(Long id) {
        if (id == null) return null;
        return entityManager().find(BorderGuardInCompany.class, id);
    }
    
    public static List<BorderGuardInCompany> BorderGuardInCompany.findBorderGuardInCompanyEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM BorderGuardInCompany o", BorderGuardInCompany.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
}
