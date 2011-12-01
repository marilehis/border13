package ee.itcollege.team13;

import java.util.List;

import ee.itcollege.team13.domain.AdminUnit;
import ee.itcollege.team13.domain.RoomType;

public class generateData {

	public generateData() {
		genAdminUnits();
		genRoomTypes();
	}

	private void genRoomTypes() {
		List<RoomType> types = RoomType.findAllRoomTypes();
		if (types == null || types.size() == 0) {
			RoomType a = new RoomType();
			a.setRoomTypeId("garnison");
			a.setName("Garnison");
		}
	}

	private void genAdminUnits() {
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
