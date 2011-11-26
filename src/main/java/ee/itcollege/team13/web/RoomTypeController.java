package ee.itcollege.team13.web;

import ee.itcollege.team13.domain.RoomType;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RooWebScaffold(path = "roomtypes", formBackingObject = RoomType.class)
@RequestMapping("/roomtypes")
@Controller
public class RoomTypeController {
}
