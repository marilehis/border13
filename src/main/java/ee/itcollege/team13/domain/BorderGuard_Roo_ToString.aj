// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ee.itcollege.team13.domain;

import java.lang.String;

privileged aspect BorderGuard_Roo_ToString {
    
    public String BorderGuard.toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("BorderGuardId: ").append(getBorderGuardId()).append(", ");
        sb.append("BorderGuardsInBed: ").append(getBorderGuardsInBed() == null ? "null" : getBorderGuardsInBed().size()).append(", ");
        sb.append("BorderGuardsInCompany: ").append(getBorderGuardsInCompany() == null ? "null" : getBorderGuardsInCompany().size()).append(", ");
        sb.append("Comment: ").append(getComment()).append(", ");
        sb.append("Id: ").append(getId()).append(", ");
        sb.append("NameFirst: ").append(getNameFirst()).append(", ");
        sb.append("NameLast: ").append(getNameLast()).append(", ");
        sb.append("PersonalId: ").append(getPersonalId()).append(", ");
        sb.append("Sex: ").append(getSex()).append(", ");
        sb.append("Version: ").append(getVersion());
        return sb.toString();
    }
    
}
