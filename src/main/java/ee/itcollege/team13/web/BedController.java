package ee.itcollege.team13.web;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ee.itcollege.team13.domain.Bed;
import ee.itcollege.team13.domain.RoomEntity;

@RooWebScaffold(path = "beds", formBackingObject = Bed.class)
@RequestMapping("/beds")
@Controller
public class BedController {

    @RequestMapping(method = RequestMethod.GET)
    public String list(
    	@RequestParam(value = "parentId", required = true) Long parentId, 
		Model uiModel
	) {
    	RoomEntity room = RoomEntity.findRoomEntity(parentId);
		uiModel.addAttribute("roomEntity", room);
        uiModel.addAttribute("beds", Bed.findBedsForRoomEntity(room));
        
        return "beds/list";
    }
    
    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String createForm(
		@RequestParam(value = "id", required = false) Long id,
		@RequestParam(value = "parentId", required = true) Long parentId,
		Model uiModel
	) {
    	Bed bed;
    	if (id != null) {
    		bed = Bed.findBed(id);
    	}
    	else {
    		bed = new Bed();
    	}
    	
    	bed.setRoomEntity(RoomEntity.findRoomEntity(parentId));
    	
		uiModel.addAttribute("bed", bed);
        return "beds/edit";
    }

    @RequestMapping(value="/edit", method = RequestMethod.POST)
    public String create(@Valid Bed bed, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
    	if (bed.getRoomEntity() == null) {
    		bindingResult.rejectValue("roomEntity", "roomEntity_required");
    	}
    	
        if (bindingResult.hasErrors()) {
            uiModel.addAttribute("bed", bed);
            return "beds/edit";
        }
        uiModel.asMap().clear();

        Long id = bed.getId();
		if (id != null && id > 0) {
			bed.merge();
        }
        else {
        	bed.persist();
        }
        
        return "redirect:/beds?parentId=" + bed.getRoomEntity().getId();
        
    }
    
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(@RequestParam("id") Long id, Model uiModel) {
    	Bed bed = Bed.findBed(id);
    	RoomEntity parent = bed.getRoomEntity();
        bed.remove();
        uiModel.asMap().clear();
        
        return "redirect:/beds?parentId=" + parent.getId();
    }
    
}