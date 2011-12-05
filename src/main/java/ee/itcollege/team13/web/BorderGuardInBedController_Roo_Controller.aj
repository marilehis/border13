// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ee.itcollege.team13.web;

import ee.itcollege.team13.domain.Bed;
import ee.itcollege.team13.domain.BorderGuard;
import ee.itcollege.team13.domain.BorderGuardInBed;
import java.io.UnsupportedEncodingException;
import java.lang.Integer;
import java.lang.Long;
import java.lang.String;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.joda.time.format.DateTimeFormat;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriUtils;
import org.springframework.web.util.WebUtils;

privileged aspect BorderGuardInBedController_Roo_Controller {
    
    @RequestMapping(method = RequestMethod.POST)
    public String BorderGuardInBedController.create(@Valid BorderGuardInBed borderGuardInBed, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            uiModel.addAttribute("borderGuardInBed", borderGuardInBed);
            addDateTimeFormatPatterns(uiModel);
            return "borderguardinbeds/create";
        }
        uiModel.asMap().clear();
        borderGuardInBed.persist();
        return "redirect:/borderguardinbeds/" + encodeUrlPathSegment(borderGuardInBed.getId().toString(), httpServletRequest);
    }
    
    @RequestMapping(params = "form", method = RequestMethod.GET)
    public String BorderGuardInBedController.createForm(Model uiModel) {
        uiModel.addAttribute("borderGuardInBed", new BorderGuardInBed());
        addDateTimeFormatPatterns(uiModel);
        List dependencies = new ArrayList();
        if (Bed.countBeds() == 0) {
            dependencies.add(new String[]{"bed", "beds"});
        }
        if (BorderGuard.countBorderGuards() == 0) {
            dependencies.add(new String[]{"borderguard", "borderguards"});
        }
        uiModel.addAttribute("dependencies", dependencies);
        return "borderguardinbeds/create";
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String BorderGuardInBedController.show(@PathVariable("id") Long id, Model uiModel) {
        addDateTimeFormatPatterns(uiModel);
        uiModel.addAttribute("borderguardinbed", BorderGuardInBed.findBorderGuardInBed(id));
        uiModel.addAttribute("itemId", id);
        return "borderguardinbeds/show";
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public String BorderGuardInBedController.list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            uiModel.addAttribute("borderguardinbeds", BorderGuardInBed.findBorderGuardInBedEntries(page == null ? 0 : (page.intValue() - 1) * sizeNo, sizeNo));
            float nrOfPages = (float) BorderGuardInBed.countBorderGuardInBeds() / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("borderguardinbeds", BorderGuardInBed.findAllBorderGuardInBeds());
        }
        addDateTimeFormatPatterns(uiModel);
        return "borderguardinbeds/list";
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String BorderGuardInBedController.delete(@PathVariable("id") Long id, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        BorderGuardInBed.findBorderGuardInBed(id).remove();
        uiModel.asMap().clear();
        uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
        uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
        return "redirect:/borderguardinbeds";
    }
    
    @ModelAttribute("beds")
    public Collection<Bed> BorderGuardInBedController.populateBeds() {
        return Bed.findAllBeds();
    }
    
    @ModelAttribute("borderguards")
    public Collection<BorderGuard> BorderGuardInBedController.populateBorderGuards() {
        return BorderGuard.findAllBorderGuards();
    }
    
    @ModelAttribute("borderguardinbeds")
    public Collection<BorderGuardInBed> BorderGuardInBedController.populateBorderGuardInBeds() {
        return BorderGuardInBed.findAllBorderGuardInBeds();
    }
    
    void BorderGuardInBedController.addDateTimeFormatPatterns(Model uiModel) {
        uiModel.addAttribute("borderGuardInBed_startdate_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
        uiModel.addAttribute("borderGuardInBed_enddate_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
    }
    
    String BorderGuardInBedController.encodeUrlPathSegment(String pathSegment, HttpServletRequest httpServletRequest) {
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
