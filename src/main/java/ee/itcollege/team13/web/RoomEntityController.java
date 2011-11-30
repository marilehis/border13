package ee.itcollege.team13.web;

import java.io.UnsupportedEncodingException;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.tiles.util.URLUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriUtils;
import org.springframework.web.util.WebUtils;

import ee.itcollege.team13.domain.AdminUnit;
import ee.itcollege.team13.domain.RoomEntity;
import ee.itcollege.team13.domain.RoomType;

@RequestMapping("/roomentitys")
@Controller
public class RoomEntityController {
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		dataBinder.setRequiredFields(new String[] {"roomEntityId", "name", "adminUnit", "roomType"});
	}
	
    @RequestMapping(value = "edit", method = RequestMethod.POST)
    public String create(@Valid RoomEntity roomEntity, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
    	RoomEntity parent = roomEntity.getParentRoomEntity();
		if (parent != null && roomEntity.getId().equals(parent.getId())) {
    		bindingResult.rejectValue("parentRoomEntity", "roomEntity.invalid.parent");
    	}
    	
        if (bindingResult.hasErrors()) {
            uiModel.addAttribute("roomEntity", roomEntity);
            uiModel.addAttribute("breadCrumbs", this.buildBreadCrumbs(roomEntity));
            return "roomentitys/edit";
        }
        uiModel.asMap().clear();

		Long id = roomEntity.getId();
		if (id != null && id > 0) {
			roomEntity.merge();
        }
        else {
        	roomEntity.persist();
        }
		
        return "redirect:/roomentitys";
    }

	@RequestMapping(value = "edit", method = RequestMethod.GET)
    public String createForm(Model uiModel, 
    		@RequestParam(value = "parentId", required = false) Long parentId, 
    		@RequestParam(value = "id", required = false) Long id
    ) {
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
        	entity.setAdminUnit(parent.getAdminUnit());
        }
        
        uiModel.addAttribute("breadCrumbs", this.buildBreadCrumbs(entity));

		uiModel.addAttribute("roomEntity", entity);
        return "roomentitys/edit";
    }

	@RequestMapping(method = RequestMethod.GET)
    public String list(Model uiModel) {
    	List<RoomEntity> rooms = RoomEntity.findAllRoomEntitys();
		uiModel.addAttribute("roomentitys", rooms);
        return "roomentitys/list";
    }

    @RequestMapping(value = "delete")
    public String delete(@RequestParam("id") Long id) {
        RoomEntity entity = RoomEntity.findRoomEntity(id);
		entity.remove();
        return "redirect:/roomentitys";
    }
    
    @ModelAttribute("adminunits")
    public Collection<AdminUnit> populateAdminUnits() {
        return AdminUnit.findAllAdminUnits();
    }
    
    @ModelAttribute("roomtypes")
    public Collection<RoomType> populateRoomTypes() {
        return RoomType.findAllRoomTypes();
    }

    @ModelAttribute("allEntities")
    public Collection<RoomEntity> populateRoomEntitys() {
        return RoomEntity.findAllRoomEntitys();
    }

    private String buildBreadCrumbs(RoomEntity entity) {
    	RoomEntity parent = entity.getParentRoomEntity();
    	StringBuilder sb = new StringBuilder();
    	Boolean isFirst = true;
    	//try {
	    	while (parent != null) {
	    		if (!isFirst) {
	    			sb.insert(0, " -> ");
	    		}
	    		else isFirst = false;
	    		
	    		sb.insert(0, "<a href='" 
					+ "edit"
					+ "?id=" + parent.getId().toString()
					+ "'>" + parent.getName() + "</a>"
				);
		    	parent = parent.getParentRoomEntity();
	    	}
	    	
    	//}
    	//catch (UnsupportedEncodingException e) {}
		return sb.toString();
	}

}
