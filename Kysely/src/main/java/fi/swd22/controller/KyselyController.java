package fi.swd22.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import fi.swd22.bean.Id;
import fi.swd22.bean.Kysely;
import fi.swd22.bean.Kysymys;
import fi.swd22.bean.LuoKysymys;
import fi.swd22.bean.Tulos;
import fi.swd22.dao.KyselyDAO;

@CrossOrigin
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
	
	@RequestMapping(value="kysely/uusi", method=RequestMethod.POST, consumes="application/json")
	public @ResponseBody Id luoKysely(@RequestBody Kysely kysely){
		Id id = new Id(dao.luoKysely(kysely));
		
		return id;
	}
	//prog vvv
	@RequestMapping(value= "kysely/{id}", method=RequestMethod.PUT)
	public @ResponseBody void paivitaKysely(@PathVariable int id, @RequestBody Kysely paivitys){
		dao.paivitaKysely(id, paivitys);
	}
	//prog ^^^
	
	@RequestMapping(value= "kysely/{id}", method=RequestMethod.DELETE)
	public @ResponseBody Kysely poistaKysely(@PathVariable int id){
		return dao.poistaKysely(id);
	}
	
	//kysymyksen hallinta
	@RequestMapping(value= "kysymys/{id}", method= RequestMethod.GET, produces="application/json")
	public @ResponseBody Kysymys getKysymys(@PathVariable int id){
		Kysymys kysymys = dao.haeKysymys(id);
		return kysymys;
	}

	@RequestMapping(value= "kysymys/uusi", method=RequestMethod.POST, consumes="application/json")
	public @ResponseBody Id luoKysymys(@RequestBody LuoKysymys kysymys){ //kuinka id:n kanssa?
		Id id = new Id(dao.luoKysymys(kysymys));		
		return id;
	}
	
	@RequestMapping(value= "kysymys/{id}", method=RequestMethod.DELETE)
	public @ResponseBody Kysymys poistaKysymys(@PathVariable int id){
		return dao.poistaKysymys(id);
	}
	
	@RequestMapping(value= "kysymys/{id}", method=RequestMethod.PUT)
	public @ResponseBody void paivitaKysymys(@PathVariable int id, @RequestBody LuoKysymys paivitys){
		dao.paivitaKysymys(id, paivitys);
	}
	
	//tuloksien hallinta
	@RequestMapping(value= "tulos", method={RequestMethod.POST}, consumes="application/json")
	public @ResponseBody Id luoTulos(@RequestBody Tulos tulos){ //{"id": "123","teksti": "vastausteksti","kysely_id": "1","kysymys_id": "2"}
		Id id = new Id();
		id.setId(dao.talletaTulos(tulos));
		return id;
	}
	
	@RequestMapping(value= "kysymys/tulos/{id}", method= RequestMethod.GET)
	public @ResponseBody List<Tulos> getTulosKysely(@PathVariable int id){
		List<Tulos> tulos = dao.haeTulosKysymys(id);
		return tulos;
	}
	
	//testisivun linkkej�
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
