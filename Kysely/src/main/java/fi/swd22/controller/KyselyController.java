package fi.swd22.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class KyselyController {
	@RequestMapping(value = "testJSON", method = RequestMethod.GET)
	public @ResponseBody String TestJSON() {
		return "test";
	}
}
