// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ee.itcollege.team13.web;

import ee.itcollege.team13.domain.RoomEntity;
import ee.itcollege.team13.domain.RoomType;
import java.io.UnsupportedEncodingException;
import java.lang.Integer;
import java.lang.Long;
import java.lang.String;
import java.util.Collection;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriUtils;
import org.springframework.web.util.WebUtils;

privileged aspect RoomTypeController_Roo_Controller {
    
    @RequestMapping(method = RequestMethod.POST)
    public String RoomTypeController.create(@Valid RoomType roomType, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            uiModel.addAttribute("roomType", roomType);
            return "roomtypes/create";
        }
        uiModel.asMap().clear();
        roomType.persist();
        return "redirect:/roomtypes/" + encodeUrlPathSegment(roomType.getId().toString(), httpServletRequest);
    }
    
    @RequestMapping(params = "form", method = RequestMethod.GET)
    public String RoomTypeController.createForm(Model uiModel) {
        uiModel.addAttribute("roomType", new RoomType());
        return "roomtypes/create";
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String RoomTypeController.show(@PathVariable("id") Long id, Model uiModel) {
        uiModel.addAttribute("roomtype", RoomType.findRoomType(id));
        uiModel.addAttribute("itemId", id);
        return "roomtypes/show";
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public String RoomTypeController.list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            uiModel.addAttribute("roomtypes", RoomType.findRoomTypeEntries(page == null ? 0 : (page.intValue() - 1) * sizeNo, sizeNo));
            float nrOfPages = (float) RoomType.countRoomTypes() / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("roomtypes", RoomType.findAllRoomTypes());
        }
        return "roomtypes/list";
    }
    
    @RequestMapping(method = RequestMethod.PUT)
    public String RoomTypeController.update(@Valid RoomType roomType, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            uiModel.addAttribute("roomType", roomType);
            return "roomtypes/update";
        }
        uiModel.asMap().clear();
        roomType.merge();
        return "redirect:/roomtypes/" + encodeUrlPathSegment(roomType.getId().toString(), httpServletRequest);
    }
    
    @RequestMapping(value = "/{id}", params = "form", method = RequestMethod.GET)
    public String RoomTypeController.updateForm(@PathVariable("id") Long id, Model uiModel) {
        uiModel.addAttribute("roomType", RoomType.findRoomType(id));
        return "roomtypes/update";
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String RoomTypeController.delete(@PathVariable("id") Long id, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        RoomType.findRoomType(id).remove();
        uiModel.asMap().clear();
        uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
        uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
        return "redirect:/roomtypes";
    }
    
    @ModelAttribute("roomentitys")
    public Collection<RoomEntity> RoomTypeController.populateRoomEntitys() {
        return RoomEntity.findAllRoomEntitys();
    }
    
    @ModelAttribute("roomtypes")
    public Collection<RoomType> RoomTypeController.populateRoomTypes() {
        return RoomType.findAllRoomTypes();
    }
    
    String RoomTypeController.encodeUrlPathSegment(String pathSegment, HttpServletRequest httpServletRequest) {
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
