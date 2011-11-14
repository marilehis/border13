package ee.itcollege.team13.web;

import ee.itcollege.team13.domain.Bed;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RooWebScaffold(path = "beds", formBackingObject = Bed.class)
@RequestMapping("/beds")
@Controller
public class BedController {
}
