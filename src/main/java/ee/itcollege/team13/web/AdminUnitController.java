package ee.itcollege.team13.web;

import ee.itcollege.team13.domain.AdminUnit;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RooWebScaffold(path = "adminunits", formBackingObject = AdminUnit.class)
@RequestMapping("/adminunits")
@Controller
public class AdminUnitController {
}
