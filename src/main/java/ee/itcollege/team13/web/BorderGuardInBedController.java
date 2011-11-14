package ee.itcollege.team13.web;

import ee.itcollege.team13.domain.BorderGuardInBed;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RooWebScaffold(path = "borderguardinbeds", formBackingObject = BorderGuardInBed.class)
@RequestMapping("/borderguardinbeds")
@Controller
public class BorderGuardInBedController {
}
