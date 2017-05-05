package fi.swd22.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import fi.swd22.bean.Kysely;
import fi.swd22.bean.Kysymys;
import fi.swd22.bean.Tulos;
import fi.swd22.dao.KyselyDAO;


@Controller
public class KyselyController {
	@Inject
	KyselyDAO dao;
	
	//kyselyn hallinta
	@RequestMapping(value= "kyselyt", method= RequestMethod.GET, produces="application/json") // kysymykset= null, tarviiko?
	public @ResponseBody List<Kysely> getKysely(){
		List<Kysely> kysely = dao.haeKaikkiKyselyt();
		return kysely;
	}
	
	@RequestMapping(value= "kysely/{id}", method= RequestMethod.GET, produces="application/json")
	public @ResponseBody Kysely getKysely(@PathVariable int id){
		Kysely kysely = dao.haeKysely(id);
		return kysely;
	}
	
	//kysymyksen hallinta
	@RequestMapping(value= "kysymys/{id}", method= RequestMethod.GET, produces="application/json")
	public @ResponseBody Kysymys getKysymys(@PathVariable int id){
		Kysymys kysymys = dao.haeKysymys(id);
		return kysymys;
	}
//in progress vvv
	@RequestMapping(value= "kysymys/uusi", method={RequestMethod.POST}, consumes="application/json")
	public @ResponseBody void luoKysymys(@RequestBody Kysymys kysymys, final int kysely_id){ //kuinka id:n kanssa?
		dao.luoKysymys(kysymys, -1);
	}

	@RequestMapping(value= "kysymys/{id}", method= RequestMethod.DELETE)
	public @ResponseBody Integer poistaKysymys(@PathVariable int id){
		int vastaus = dao.poistaKysymys(id);
		return vastaus;
	}
	
	@RequestMapping(value= "kysymys/{id}", method= RequestMethod.PUT)
	public @ResponseBody Kysymys paivitaKysymys(@RequestBody Kysymys paivitys){
		Kysymys kysymys = dao.paivitaKysymys(paivitys);
		return kysymys;
	}
// in progress ^^^
	
	//tuloksien hallinta
	@RequestMapping(value= "tulos", method={RequestMethod.POST}, consumes="application/json")
	public @ResponseBody void luoTulos(@RequestBody Tulos tulos){ //{"id": "123","teksti": "vastausteksti","kysely_id": "1","kysymys_id": "2"}
		dao.talletaTulos(tulos);
	}
	
	@RequestMapping(value= "kysymys/tulos/{id}", method= RequestMethod.GET)
	public @ResponseBody List<Tulos> getTulosKysely(@PathVariable int id){
		List<Tulos> tulos = dao.haeTulosKysymys(id);
		return tulos;
	}
	
	//testisivun linkkejä
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
