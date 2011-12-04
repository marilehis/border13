package ee.itcollege.team13.web;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ee.itcollege.team13.domain.*;

@RequestMapping("/housingreport/**")
@Controller
public class HousingReportController {

//	@RequestMapping
//	public void get(ModelMap modelMap, HttpServletRequest request,
//			HttpServletResponse response) {
//	}
//
//	@RequestMapping(method = RequestMethod.POST, value = "{id}")
//	public void post(@PathVariable Long id, ModelMap modelMap,
//			HttpServletRequest request, HttpServletResponse response) {
//	}

	@RequestMapping
	public String index(Model uiModel) {

		List<HousingReportData> rooms = new ArrayList<HousingReportData>();

		for (RoomEntity room : RoomEntity.findAllRoomEntitys()) {

			rooms.add(HousingReportData.findBedsForDate(new Date(), room));
		}

		uiModel.addAttribute("rooms", rooms);
		uiModel.addAttribute("roomentitys", RoomEntity.findAllRoomEntitys());
		return "housingreport/index";
	}
	
	/*
	  @RequestMapping(value = "/{date}", method = RequestMethod.GET) 
	  public  String byDate(   
	  @RequestParam("date") @DateTimeFormat(iso = ISO.DATE) Date date,  @RequestParam("room") RoomEntity room, Model
	  uiModel) {
	  
	   List<HousingReportData> rooms = new ArrayList<HousingReportData>();
	  	  rooms.add(HousingReportData.findBedsForDate(new Date(), room));
	  // TODO: find childRooms to add
	  	  uiModel.addAttribute("rooms", rooms); return "housingreport/index"; }
	 */
}
