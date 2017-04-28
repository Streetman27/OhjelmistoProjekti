package fi.swd22.dao;

import java.util.List;

import fi.swd22.bean.Kysymys;

public interface KyselyDAO {
	
	
	//yhden kysymyksen käsittely
	public abstract List<Kysymys> haeKysymys(int id);

	public abstract Kysymys luoKysymys();

	public abstract Kysymys paivitaKysymys();

	public abstract Kysymys poistaKysymys(int id);

}
