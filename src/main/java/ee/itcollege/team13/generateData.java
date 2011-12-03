package ee.itcollege.team13;

import java.util.Date;
import java.util.List;

import ee.itcollege.team13.domain.AdminUnit;
import ee.itcollege.team13.domain.Bed;
import ee.itcollege.team13.domain.BorderGuard;
import ee.itcollege.team13.domain.BorderGuardInBed;
import ee.itcollege.team13.domain.BorderGuardInCompany;
import ee.itcollege.team13.domain.Company;
import ee.itcollege.team13.domain.RoomEntity;
import ee.itcollege.team13.domain.RoomType;

public class generateData {

	
	protected static final Date endDate = new Date(253402207200000L);
	
	public generateData() {
		genAdminUnits();
		genRoomTypes();
		genBorderGuard();
		genCompany();
		genRoomEntity();
		genBed();
		genBorderGuardInCompany();
		genBorderGuardInBed();
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
	
	private void genBorderGuard() {
		List<BorderGuard> guards = BorderGuard.findAllBorderGuards();
		
		if (guards == null || guards.size() == 0) {
			BorderGuard a = new BorderGuard();
			a.setBorderGuardId("BG100");
			a.setNameFirst("Peeter");
			a.setNameLast("Pakiraam");
			a.setPersonalId("36712060001");
			a.setSex("M");
			a.setComment("taimetoitlane");
			a.persist();
			
			BorderGuard b = new BorderGuard();
			b.setBorderGuardId("BG200");
			b.setNameFirst("Artur");
			b.setNameLast("Kass");
			b.setPersonalId("37714050001");
			b.setSex("M");
			b.setComment("");
			b.persist();
		}
	}
	
	private void genCompany() {
		List<Company> comp = Company.findAllCompanys();
		
		if (comp == null || comp.size() == 0) {
			Company a = new Company();
			a.setCompanyID("Kalevi");
			a.setName("Kalevi pataljon");			
			a.persist();
			
			Company b = new Company();
			b.setCompanyID("Kuperjanovi");
			b.setName("Kuperjanovi jalaväepataljon");			
			b.persist();
		}
	}
	
	private void genRoomEntity() {
		List<RoomEntity> rooms = RoomEntity.findAllRoomEntitys();
		
		if (rooms == null || rooms.size() == 0) {
			RoomEntity a = new RoomEntity();
			a.setRoomEntityId("G1");
			a.setName("Garnison1");		
			a.setRoomType(RoomType.findRoomType((long)1));
			a.setAdminUnit(AdminUnit.findAdminUnit((long)1));
			a.setAddress("Kükametsa 5");
			a.persist();
			
			RoomEntity b = new RoomEntity();
			b.setRoomEntityId("M1");
			b.setName("Maja1");		
			b.setRoomType(RoomType.findRoomType((long)2));
			b.setAdminUnit(AdminUnit.findAdminUnit((long)1));
			b.setParentRoomEntity(RoomEntity.findRoomEntity((long)1));
			b.setAddress("Kükametsa 5");
			b.persist();
			
			RoomEntity c = new RoomEntity();
			c.setRoomEntityId("M2");
			c.setName("Maja2");		
			c.setRoomType(RoomType.findRoomType((long)2));
			c.setAdminUnit(AdminUnit.findAdminUnit((long)1));
			c.setParentRoomEntity(RoomEntity.findRoomEntity((long)1));
			c.setAddress("Kükametsa 7");
			c.persist();
			
			RoomEntity d = new RoomEntity();
			d.setRoomEntityId("M2-T1");
			d.setName("Maja2-Tiib1");		
			d.setRoomType(RoomType.findRoomType((long)3));
			d.setAdminUnit(AdminUnit.findAdminUnit((long)1));
			d.setParentRoomEntity(RoomEntity.findRoomEntity((long)3));
			d.setAddress("Kükametsa 7");
			d.persist();
			
			
		}
	}
	
	private void genBed() {
		List<Bed> beds = Bed.findAllBeds();
		
		if (beds == null || beds.size() == 0) {
			Bed a = new Bed();
			a.setBedId("B1");
			a.setLength((int)200);	
			a.setWidth((int)90);
			a.setComment("");
			a.setRoomEntity(RoomEntity.findRoomEntity((long)4));
			a.persist();
			
			Bed b = new Bed();
			b.setBedId("B2");
			b.setLength((int)180);	
			b.setWidth((int)90);
			b.setComment("");
			b.setRoomEntity(RoomEntity.findRoomEntity((long)4));
			b.persist();
			
			Bed c = new Bed();
			c.setBedId("B3");
			c.setLength((int)200);	
			c.setWidth((int)140);
			c.setComment("");
			c.setRoomEntity(RoomEntity.findRoomEntity((long)4));
			c.persist();
		}
	}
	
	private void genBorderGuardInCompany() {
		List<BorderGuardInCompany> bgc = BorderGuardInCompany.findAllBorderGuardInCompanys();
		
		if (bgc == null || bgc.size() == 0) {
			BorderGuardInCompany a = new BorderGuardInCompany();
			a.setBorderGuard(BorderGuard.findBorderGuard((long)1));
			a.setCompany(Company.findCompany((long)1))	;
			a.setStartDate(new Date());
			a.setEndDate(endDate);
			a.persist();
			
			BorderGuardInCompany b = new BorderGuardInCompany();
			b.setBorderGuard(BorderGuard.findBorderGuard((long)2));
			b.setCompany(Company.findCompany((long)2))	;
			b.setStartDate(new Date());
			b.setEndDate(endDate);
			b.persist();
		
			}
		}
	
	private void genBorderGuardInBed() {
		List<BorderGuardInBed> bgb = BorderGuardInBed.findAllBorderGuardInBeds();
		
		if (bgb == null || bgb.size() == 0) {
			BorderGuardInBed a = new BorderGuardInBed();
			a.setBorderGuard(BorderGuard.findBorderGuard((long)1));
			a.setBed(Bed.findBed((long)1))	;
			a.setStartDate(new Date());
			a.setEndDate(endDate);
			a.persist();
			
			BorderGuardInBed b = new BorderGuardInBed();
			b.setBorderGuard(BorderGuard.findBorderGuard((long)2));
			b.setBed(Bed.findBed((long)2))	;
			b.setStartDate(new Date());
			b.setEndDate(endDate);
			b.persist();
			
		
			}
		}
	}