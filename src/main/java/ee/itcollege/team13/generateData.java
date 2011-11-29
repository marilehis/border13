package ee.itcollege.team13;

import java.util.List;

import ee.itcollege.team13.domain.AdminUnit;

public class generateData {

	public generateData() {
		List<AdminUnit> units = AdminUnit.findAllAdminUnits();
		
		if (units == null || units.size() == 0) {
			AdminUnit a = new AdminUnit();
			a.setAdminUnitId("karupesa");
			a.setAdminUnitName("Karupesa kihelkond");			
			a.persist();
			
			AdminUnit b = new AdminUnit();
			b.setAdminUnitId("tartu");
			b.setAdminUnitName("Tartu linn");			
			b.persist();
		}
	}

}
