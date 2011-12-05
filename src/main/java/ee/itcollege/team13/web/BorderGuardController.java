package ee.itcollege.team13.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ee.itcollege.team13.domain.Bed;
import ee.itcollege.team13.domain.BorderGuard;
import ee.itcollege.team13.domain.BorderGuardInBed;
import ee.itcollege.team13.domain.RoomEntity;

@RooWebScaffold(path = "borderguards", formBackingObject = BorderGuard.class)
@RequestMapping("/borderguards")
@Controller
public class BorderGuardController {
    

    @RequestMapping(value = "/{id}", params="beds", method = RequestMethod.GET)
    public String putToBed(@PathVariable("id") Long id, Model uiModel) {
    	List<RoomEntity> pRoomEntity = RoomEntity.findParentRoomEntitys();
    	
    	Bed currentBed = BorderGuardInBed.getBGCurrentBed(id).getBed();
    	RoomEntity currentRoom = currentBed.getRoomEntity();
    	List<Bed> freeBeds = Bed.findFreeBedsInRoom(currentRoom);
    	freeBeds.add(0, currentBed);
    	
    	String nimi = BorderGuard.findBorderGuard(id).getNameFirst() + " " + BorderGuard.findBorderGuard(id).getNameLast();
    	
    	uiModel.addAttribute("bgName", nimi);
    	uiModel.addAttribute("freeBeds", freeBeds);
    	uiModel.addAttribute("currentRoom",currentRoom);
        uiModel.addAttribute("borderguard", BorderGuard.findBorderGuard(id));
        uiModel.addAttribute("itemId", id);
		uiModel.addAttribute("pRoom", pRoomEntity);
		
        return "borderguards/show";

    }
    
    @RequestMapping(value = "/{id}", params = "rE", method = RequestMethod.GET)
    public String putToBed(@PathVariable("id") Long id, @PathVariable("reID") Long reID, Model uiModel) {
    	List<RoomEntity> pRoomEntity = RoomEntity.findParentRoomEntitys();
    	
    	Bed currentBed = BorderGuardInBed.getBGCurrentBed(id).getBed();
    	List<Bed> freeBeds = Bed.findFreeBedsInRoom(RoomEntity.findRoomEntity(reID));
    	freeBeds.add(0, currentBed);
    	
    	String nimi = BorderGuard.findBorderGuard(id).getNameFirst() + " " + BorderGuard.findBorderGuard(id).getNameLast();
    	
    	uiModel.addAttribute("bgName", nimi);
    	uiModel.addAttribute("freeBeds", freeBeds);
        uiModel.addAttribute("borderguard", BorderGuard.findBorderGuard(id));
        uiModel.addAttribute("itemId", id);
		uiModel.addAttribute("pRoom", pRoomEntity);
		
        return "borderguards/show";

    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String show(@PathVariable("id") Long id, Model uiModel) {
        uiModel.addAttribute("borderguard", BorderGuard.findBorderGuard(id));
        uiModel.addAttribute("itemId", id);
        return "borderguards/show";
    }
	
}
