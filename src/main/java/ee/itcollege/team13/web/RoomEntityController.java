package ee.itcollege.team13.web;

import ee.itcollege.team13.domain.RoomEntity;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RooWebScaffold(path = "roomentitys", formBackingObject = RoomEntity.class)
@RequestMapping("/roomentitys")
@Controller
public class RoomEntityController {
}
