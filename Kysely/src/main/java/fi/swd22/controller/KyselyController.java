package fi.swd22.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import fi.swd22.bean.Kysymys;
import fi.swd22.bean.KysymysImpl;

import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class KyselyController {
	
	@RequestMapping(value = "kys/kiitos", method = RequestMethod.GET)
	public String Kiitos() {
		return "kys/kiitos";
	}
	
	@RequestMapping(value= "kys/haeKysymys", method= RequestMethod.GET)
	public String Kysymyshaku(){
		return "kys/haeKysymys";
	}
	
	@RequestMapping(value="kys/uusiKysymys", method=RequestMethod.GET)
	public String getCreateForm(Model model) {
		Kysymys tyhjaKysymys = new KysymysImpl();
		tyhjaKysymys.setKysymys("");
		
		model.addAttribute("kysymys", tyhjaKysymys);
		return "kys/uusiKysymys";
	}
}
