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
    
    @RequestMapping(value = "/{id}", params = "guardinbed", method = RequestMethod.GET)
    public String guardinbed(@PathVariable("id") Long id, Model uiModel) {
    	List<Bed> freeBeds = new ArrayList<Bed>();
    	System.out.println(BorderGuardInBed.findBorderGuardInBed(id).toString());
    	RoomEntity bedEntity = BorderGuardInBed.findBorderGuardInBed(id).getBed().getRoomEntity();
    	freeBeds = Bed.findFreeBedsInRoom(RoomEntity.findRoomEntity(bedEntity.getId()).getId(),id); 
    	
    	uiModel.addAttribute("freebeds",freeBeds);
    	uiModel.addAttribute("borderguard", BorderGuard.findBorderGuard(id));
        uiModel.addAttribute("itemId", id);
        uiModel.addAttribute("rooms",RoomEntity.findAllRoomEntitys());
        return "borderguards/show";
    }
	
}
