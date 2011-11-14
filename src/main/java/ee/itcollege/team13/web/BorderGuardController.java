package ee.itcollege.team13.web;

import ee.itcollege.team13.domain.BorderGuard;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RooWebScaffold(path = "borderguards", formBackingObject = BorderGuard.class)
@RequestMapping("/borderguards")
@Controller
public class BorderGuardController {
}
