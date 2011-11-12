// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ee.itcollege.team13.domain;

import ee.itcollege.team13.domain.House;
import java.lang.Long;
import java.util.List;

privileged aspect House_Roo_Entity {
    
    public static long House.countHouses() {
        return entityManager().createQuery("SELECT COUNT(o) FROM House o", Long.class).getSingleResult();
    }
    
    public static List<House> House.findAllHouses() {
        return entityManager().createQuery("SELECT o FROM House o", House.class).getResultList();
    }
    
    public static House House.findHouse(Long id) {
        if (id == null) return null;
        return entityManager().find(House.class, id);
    }
    
    public static List<House> House.findHouseEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM House o", House.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
}
