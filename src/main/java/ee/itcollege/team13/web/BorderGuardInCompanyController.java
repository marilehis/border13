package ee.itcollege.team13.web;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import ee.itcollege.team13.domain.BorderGuard;
import ee.itcollege.team13.domain.BorderGuardInCompany;
import ee.itcollege.team13.domain.Company;

import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RooWebScaffold(path = "borderguardincompanys", formBackingObject = BorderGuardInCompany.class)
@RequestMapping("/borderguardincompanys")
@Controller
public class BorderGuardInCompanyController {
	
	@RequestMapping(method = RequestMethod.POST)
    public String create(@Valid BorderGuardInCompany borderGuardInCompany, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            uiModel.addAttribute("borderGuardInCompany", borderGuardInCompany);
            addDateTimeFormatPatterns(uiModel);
            return "borderguardincompanys/create";
        }
        uiModel.asMap().clear();
        borderGuardInCompany.persist();
        return "redirect:/borderguardincompanys/";
    }
	

    @RequestMapping(params = "form", method = RequestMethod.GET)
    public String createForm(Model uiModel) {
    	BorderGuardInCompany bgic = new BorderGuardInCompany();
    	Calendar cal = Calendar.getInstance();
    	cal.add(Calendar.YEAR, 1);
    	bgic.setEndDate(cal.getTime());
        uiModel.addAttribute("borderGuardInCompany", bgic);
        addDateTimeFormatPatterns(uiModel);
        List<String[]> dependencies = new ArrayList<String[]>();
        if (Company.countCompanys() == 0) {
            dependencies.add(new String[]{"company", "companys"});
        }
        if (BorderGuard.countBorderGuards() == 0) {
            dependencies.add(new String[]{"borderguard", "borderguards"});
        }
        uiModel.addAttribute("dependencies", dependencies);
        return "borderguardincompanys/create";
    }
}
