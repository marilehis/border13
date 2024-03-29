// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ee.itcollege.team13.web;

import ee.itcollege.team13.domain.BorderGuard;
import ee.itcollege.team13.domain.BorderGuardInBed;
import ee.itcollege.team13.domain.BorderGuardInCompany;
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

privileged aspect BorderGuardController_Roo_Controller {
    
    @RequestMapping(method = RequestMethod.POST)
    public String BorderGuardController.create(@Valid BorderGuard borderGuard, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            uiModel.addAttribute("borderGuard", borderGuard);
            return "borderguards/create";
        }
        uiModel.asMap().clear();
        borderGuard.persist();
        return "redirect:/borderguards/" + encodeUrlPathSegment(borderGuard.getId().toString(), httpServletRequest);
    }
    
    @RequestMapping(params = "form", method = RequestMethod.GET)
    public String BorderGuardController.createForm(Model uiModel) {
        uiModel.addAttribute("borderGuard", new BorderGuard());
        return "borderguards/create";
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public String BorderGuardController.list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            uiModel.addAttribute("borderguards", BorderGuard.findBorderGuardEntries(page == null ? 0 : (page.intValue() - 1) * sizeNo, sizeNo));
            float nrOfPages = (float) BorderGuard.countBorderGuards() / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("borderguards", BorderGuard.findAllBorderGuards());
        }
        return "borderguards/list";
    }
    
    @RequestMapping(method = RequestMethod.PUT)
    public String BorderGuardController.update(@Valid BorderGuard borderGuard, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            uiModel.addAttribute("borderGuard", borderGuard);
            return "borderguards/update";
        }
        uiModel.asMap().clear();
        borderGuard.merge();
        return "redirect:/borderguards/" + encodeUrlPathSegment(borderGuard.getId().toString(), httpServletRequest);
    }
    
    @RequestMapping(value = "/{id}", params = "form", method = RequestMethod.GET)
    public String BorderGuardController.updateForm(@PathVariable("id") Long id, Model uiModel) {
        uiModel.addAttribute("borderGuard", BorderGuard.findBorderGuard(id));
        return "borderguards/update";
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String BorderGuardController.delete(@PathVariable("id") Long id, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        BorderGuard.findBorderGuard(id).remove();
        uiModel.asMap().clear();
        uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
        uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
        return "redirect:/borderguards";
    }
    
    @ModelAttribute("borderguards")
    public Collection<BorderGuard> BorderGuardController.populateBorderGuards() {
        return BorderGuard.findAllBorderGuards();
    }
    
    @ModelAttribute("borderguardinbeds")
    public Collection<BorderGuardInBed> BorderGuardController.populateBorderGuardInBeds() {
        return BorderGuardInBed.findAllBorderGuardInBeds();
    }
    
    @ModelAttribute("borderguardincompanys")
    public Collection<BorderGuardInCompany> BorderGuardController.populateBorderGuardInCompanys() {
        return BorderGuardInCompany.findAllBorderGuardInCompanys();
    }
    
    String BorderGuardController.encodeUrlPathSegment(String pathSegment, HttpServletRequest httpServletRequest) {
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
