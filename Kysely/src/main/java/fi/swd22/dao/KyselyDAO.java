package fi.swd22.dao;

import fi.swd22.bean.Kysely;
import fi.swd22.bean.Kysymys;
import fi.swd22.bean.Tulos;

public interface KyselyDAO {
	
	//kyselyn käsittely
	public abstract Kysely haeKysely(int id);
	
	//yhden kysymyksen käsittely
	public abstract Kysymys haeKysymys(int id);

	public abstract int luoKysymys(Kysymys kysymys);

	public abstract Kysymys paivitaKysymys(Kysymys kysymys);

	public abstract int poistaKysymys(int id);
	
	//tuloksien tallettaminen
	
	public abstract void talletaTulos(Tulos tulos);
}
