package ee.itcollege.team13.web;

import ee.itcollege.team13.domain.HouseType;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RooWebScaffold(path = "housetypes", formBackingObject = HouseType.class)
@RequestMapping("/housetypes")
@Controller
public class HouseTypeController {
}
