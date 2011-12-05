package ee.itcollege.team13.web;

import ee.itcollege.team13.domain.BorderGuardInBed;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
    
}
