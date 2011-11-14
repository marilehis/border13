package ee.itcollege.team13.web;

import ee.itcollege.team13.domain.BorderGuardInCompany;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RooWebScaffold(path = "borderguardincompanys", formBackingObject = BorderGuardInCompany.class)
@RequestMapping("/borderguardincompanys")
@Controller
public class BorderGuardInCompanyController {
}
