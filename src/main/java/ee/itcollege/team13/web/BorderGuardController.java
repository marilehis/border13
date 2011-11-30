package ee.itcollege.team13.web;

import java.util.*;

import ee.itcollege.team13.domain.*;

import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RooWebScaffold(path = "borderguards", formBackingObject = BorderGuard.class)
@RequestMapping("/borderguards")
@Controller
public class BorderGuardController {
    

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String show(@PathVariable("id") Long id, Model uiModel) {
    	List<Bed> freeBeds = new ArrayList<Bed>();
    	Bed currentBed = BorderGuardInBed.getBGCurrentBed(id).getBed();
    	RoomEntity currentRoom = currentBed.getRoomEntity();
    	List<RoomEntity> allRooms = RoomEntity.findAllRoomEntitys();
    	try{
    //		freeBeds = Bed.findFreeBedsInRoom(currentRoom.getId(), id);
    	}
    	catch (Exception e) {
    		uiModel.addAttribute("error", e.getMessage());
    		return "borderguards/show";
    	}
    	
    	uiModel.addAttribute("freeBeds", freeBeds);
    	uiModel.addAttribute("allRooms",allRooms);
    	uiModel.addAttribute("currentRoom",currentRoom);

        uiModel.addAttribute("borderguard", BorderGuard.findBorderGuard(id));
        uiModel.addAttribute("itemId", id);

        return "borderguards/show";

    }
	
}
