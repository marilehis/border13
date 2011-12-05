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

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;

@RooWebScaffold(path = "borderguardinbeds", formBackingObject = BorderGuardInBed.class)
@RequestMapping("/borderguardinbeds")
@Controller
public class BorderGuardInBedController {
    
	@RequestMapping(method = RequestMethod.PUT)
    public String update(@Valid BorderGuardInBed borderGuardInBed, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            uiModel.addAttribute("borderGuardInBed", borderGuardInBed);
            addDateTimeFormatPatterns(uiModel);
            return "borderguardinbeds/update";
        }
        uiModel.asMap().clear();
        borderGuardInBed.merge();
        return "redirect:/borderguardinbeds/" + encodeUrlPathSegment(borderGuardInBed.getId().toString(), httpServletRequest);
    }
    
    @RequestMapping(value = "/{id}", params = "form", method = RequestMethod.GET)
    public String updateForm(@PathVariable("id") Long id, Model uiModel) {
        uiModel.addAttribute("borderGuardInBed", BorderGuardInBed.findBorderGuardInBed(id));
        addDateTimeFormatPatterns(uiModel);
        return "borderguardinbeds/update";
    }
}
