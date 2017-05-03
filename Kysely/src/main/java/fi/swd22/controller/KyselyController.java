package fi.swd22.controller;


import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import fi.swd22.bean.Kysymys;
import fi.swd22.bean.Kysymys;
import fi.swd22.dao.KyselyDAO;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class KyselyController {
	@Inject
	KyselyDAO dao;
	
	@RequestMapping(value= "kysymys/{id}", method= RequestMethod.GET)
	public @ResponseBody Kysymys getKysymys(@PathVariable int id){
		Kysymys kysymys = dao.haeKysymys(id);
		return kysymys;
	}
	
	@RequestMapping(value= "kysymys/{uusi}", method={RequestMethod.POST}, headers="application/json")
	public @ResponseBody Integer luoKysymys(@PathVariable Kysymys uusi){
		int vastaus = dao.luoKysymys(uusi);
		return vastaus;
	}
	
	@RequestMapping(value= "kysymys/poistettava/{id}", method= RequestMethod.DELETE)
	public @ResponseBody Integer poistaKysymys(@PathVariable int id){
		int vastaus = dao.poistaKysymys(id);
		return vastaus;
	}
	
	@RequestMapping(value= "kysymys/{id}", method= RequestMethod.PATCH)
	public @ResponseBody Kysymys paivitaKysymys(@PathVariable Kysymys paivitys){
		Kysymys kysymys = dao.paivitaKysymys(paivitys);
		return kysymys;
	}
	
	
	@RequestMapping(value="uusi", method=RequestMethod.GET)
	public String getCreateForm(Model model) {
		Kysymys uusiKysymys = new Kysymys();
		uusiKysymys.setKysymys("");
		
		model.addAttribute("kysymys", uusiKysymys);
		return "kys/uusiKysymys";
	}
	
	
	@RequestMapping(value = "kys/kiitos", method = RequestMethod.GET)
	public String Kiitos() {
		return "kys/kiitos";
	}
}
