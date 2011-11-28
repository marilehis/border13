package ee.itcollege.team13.web;

import java.io.UnsupportedEncodingException;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import ee.itcollege.team13.domain.AdminUnit;
import ee.itcollege.team13.domain.Bed;
import ee.itcollege.team13.domain.RoomEntity;
import ee.itcollege.team13.domain.RoomType;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriUtils;
import org.springframework.web.util.WebUtils;

@RequestMapping("/roomentitys")
@Controller
public class RoomEntityController {

    @RequestMapping(value = "edit", method = RequestMethod.POST)
    public String create(@Valid RoomEntity roomEntity, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        //if (bindingResult.hasErrors()) {
    	
            uiModel.addAttribute("roomEntity", roomEntity);
            return "roomentitys/edit";
        /*}
        uiModel.asMap().clear();
        roomEntity.persist();
        return "redirect:/roomentitys/edit?id=" + encodeUrlPathSegment(roomEntity.getId().toString(), httpServletRequest);*/
    }
    
    @RequestMapping(value = "edit", method = RequestMethod.GET)
    public String createForm(Model uiModel, 
    		@RequestParam(value = "parentId", required = false) Long parentId, 
    		@RequestParam(value = "id", required = false) Long id) {
    	
    	RoomEntity entity;
    	if (id != null) {
    		entity = RoomEntity.findRoomEntity(id);
    	}
    	else {
    		entity = new RoomEntity();
    	}
    	
        if (parentId != null) {
        	if (id != null) {
        		throw new RuntimeException("Not allowed to change parent for existing entity.");
        	}
        	
        	RoomEntity parent = RoomEntity.findRoomEntity(parentId);
        	if (parent == null) {
        		// if id was defined it should already be valid
        		throw new RuntimeException("Invalid parent id");
        	}
        	entity.setParentRoomEntity(parent);
        	
        	// set appropriate room type based on parent's type
        	String parentType = parent.getRoomType().getName();
        	if (parentType.equals("garnison")) {
        		entity.setRoomType(RoomType.findRoomTypeByIdString("maja"));
        	}
        	else if (parentType.equals("maja")) {
        		entity.setRoomType(RoomType.findRoomTypeByIdString("tiib"));
        	}
        }
        else {
        	entity.setRoomType(RoomType.findRoomTypeByIdString("garnison"));
        }
        
		uiModel.addAttribute("roomEntity", entity);
        return "roomentitys/edit";
    }

    @RequestMapping(method = RequestMethod.GET)
    public String list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            uiModel.addAttribute("roomentitys", RoomEntity.findRoomEntityEntries(page == null ? 0 : (page.intValue() - 1) * sizeNo, sizeNo));
            float nrOfPages = (float) RoomEntity.countRoomEntitys() / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("roomentitys", RoomEntity.findAllRoomEntitys());
        }
        return "roomentitys/list";
    }
    
    @RequestMapping(value = "/{id}", params = "form", method = RequestMethod.GET)
    public String updateForm(@PathVariable("id") Long id, Model uiModel) {
        uiModel.addAttribute("roomEntity", RoomEntity.findRoomEntity(id));
        return "roomentitys/update";
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") Long id, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        RoomEntity.findRoomEntity(id).remove();
        uiModel.asMap().clear();
        uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
        uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
        return "redirect:/roomentitys";
    }
    
    @ModelAttribute("adminunits")
    public Collection<AdminUnit> populateAdminUnits() {
        return AdminUnit.findAllAdminUnits();
    }
    
    @ModelAttribute("beds")
    public Collection<Bed> populateBeds() {
        return Bed.findAllBeds();
    }
    
    @ModelAttribute("roomentitys")
    public Collection<RoomEntity> populateRoomEntitys() {
        return RoomEntity.findAllRoomEntitys();
    }
    
    @ModelAttribute("roomtypes")
    public Collection<RoomType> populateRoomTypes() {
        return RoomType.findAllRoomTypes();
    }
    
    private String encodeUrlPathSegment(String pathSegment, HttpServletRequest httpServletRequest) {
        String enc = httpServletRequest.getCharacterEncoding();
        if (enc == null) {
            enc = WebUtils.DEFAULT_CHARACTER_ENCODING;
        }
        try {
            pathSegment = UriUtils.encodePathSegment(pathSegment, enc);
        }
        catch (UnsupportedEncodingException uee) {}
        return pathSegment;
    }
}
