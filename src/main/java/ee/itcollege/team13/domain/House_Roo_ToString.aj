// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ee.itcollege.team13.domain;

import java.lang.String;

privileged aspect House_Roo_ToString {
    
    public String House.toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Address: ").append(getAddress()).append(", ");
        sb.append("Beds: ").append(getBeds() == null ? "null" : getBeds().size()).append(", ");
        sb.append("Comment: ").append(getComment()).append(", ");
        sb.append("HouseId: ").append(getHouseId()).append(", ");
        sb.append("HouseType: ").append(getHouseType()).append(", ");
        sb.append("Id: ").append(getId()).append(", ");
        sb.append("Name: ").append(getName()).append(", ");
        sb.append("Version: ").append(getVersion());
        return sb.toString();
    }
    
}
