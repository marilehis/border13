package ee.itcollege.team13;

import java.util.List;

import ee.itcollege.team13.domain.*;

public class generateData {

	public generateData() {
		genAdminUnits();
		genRoomTypes();
		genBeds();
		genBorderGuard();
	}

	private void genRoomTypes() {
		List<RoomType> types = RoomType.findAllRoomTypes();
		if (types == null || types.size() == 0) {
			RoomType a = new RoomType();
			a.setRoomTypeId("garnison");
			a.setName("Garnison");
			a.persist();
			
			RoomType b = new RoomType();
			b.setRoomTypeId("maja");
			b.setName("Maja");
			b.persist();
			
			RoomType c = new RoomType();
			c.setRoomTypeId("tiib");
			c.setName("Tiib");
			c.persist();
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
	
	private void genBeds(){
		List<Bed> beds = Bed.findAllBeds();
		if(beds == null || beds.size() == 0){
			Bed a = new Bed();
			a.setBedId("V1");
			a.setLength(200);
			a.setWidth(90);
			a.setComment("puidust");
			a.persist();
		}
	}
	
	private void genBorderGuard(){
		List<BorderGuard> BGs = BorderGuard.findAllBorderGuards();
		if(BGs == null | BGs.size() == 0){
			BorderGuard a = new BorderGuard();
			a.setBorderGuardId("98");
			a.setComment("reamees");
			a.setNameFirst("Vitali");
			a.setNameLast("Kosjugin");
			a.setPersonalId("7345873475");
			a.setSex('M');
			
		}
	}

}
