package fi.swd22.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import fi.swd22.bean.Kysymys;
import fi.swd22.bean.KysymysImpl;
import fi.swd22.dao.KyselyDAO;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class KyselyController {
	@Inject
	KyselyDAO dao;
	
	@RequestMapping(value= "kys/{id}", method= RequestMethod.GET)
	public @ResponseBody Kysymys getKysymys(@PathVariable String id){
		Kysymys kysymys = dao.haeKysymys(id);
		return kysymys;
	}
	
	@RequestMapping(value= "{}", method= RequestMethod.POST)
	public @ResponseBody Kysymys luoKysymys(@PathVariable String id){
		Kysymys kysymys = dao.luoKysymys(id);
		return kysymys;
	}
	
	@RequestMapping(value= "kys/{id}", method= RequestMethod.DELETE)
	public @ResponseBody Kysymys poistaKysymys(@PathVariable String id){
		Kysymys kysymys = dao.poistaKysymys(id);
		return kysymys;
	}
	
	@RequestMapping(value= "{}", method= RequestMethod.PATCH)
	public @ResponseBody Kysymys paivitaKysymys(@PathVariable String id){
		Kysymys kysymys = dao.paivitaKysymys(id);
		return kysymys;
	}
	
	
	@RequestMapping(value="uusi", method=RequestMethod.GET)
	public String getCreateForm(Model model) {
		Kysymys uusiKysymys = new KysymysImpl();
		uusiKysymys.setKysymys("");
		
		model.addAttribute("kysymys", uusiKysymys);
		return "kys/uusiKysymys";
	}
	
	
	@RequestMapping(value = "kys/kiitos", method = RequestMethod.GET)
	public String Kiitos() {
		return "kys/kiitos";
	}
}
