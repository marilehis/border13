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
    	List<RoomEntity> allRooms = RoomEntity.findAllRoomEntitys();
    	if(allRooms == null || allRooms.size() == 0){
    		uiModel.addAttribute("borderguard", BorderGuard.findBorderGuard(id));
            uiModel.addAttribute("itemId", id);
    		return "borderguards/show";
    	}
    	if(BorderGuardInBed.findBorderGuardInBed(id) == null){
    		uiModel.addAttribute("borderguard", BorderGuard.findBorderGuard(id));
    		uiModel.addAttribute("allRooms", allRooms);
            uiModel.addAttribute("itemId", id);
    		return "borderguards/show";
    	}
    	Bed currentBed = BorderGuardInBed.getBGCurrentBed(id).getBed();
    	RoomEntity currentRoom = currentBed.getRoomEntity();
    	freeBeds = Bed.findFreeBedsInRoom(currentRoom.getId(), id);
    	
    	if(freeBeds.isEmpty()){
    		uiModel.addAttribute("error", "No free rooms");
    	}else{
    		uiModel.addAttribute("freeBeds", freeBeds);
    	}
    	
    	uiModel.addAttribute("currentRoom",currentRoom);
        uiModel.addAttribute("borderguard", BorderGuard.findBorderGuard(id));
        uiModel.addAttribute("itemId", id);

        return "borderguards/show";

    }
	
}
