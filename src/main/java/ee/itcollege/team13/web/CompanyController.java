package ee.itcollege.team13.web;

import ee.itcollege.team13.domain.Company;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RooWebScaffold(path = "companys", formBackingObject = Company.class)
@RequestMapping("/companys")
@Controller
public class CompanyController {
}
