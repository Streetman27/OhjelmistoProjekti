package fi.swd22.dao;

import java.util.List;

import fi.swd22.bean.Kysely;
import fi.swd22.bean.Kysymys;
import fi.swd22.bean.Tulos;

public interface KyselyDAO {
	
	//tuloksien k�sittely
	public abstract List<Tulos> haeTulosKysymys(int id);
	
	//kyselyn k�sittely
	public abstract List<Kysely> haeKaikkiKyselyt();
	
	public abstract Kysely haeKysely(int id);
	
	//yhden kysymyksen k�sittely
	public abstract Kysymys haeKysymys(int id);

	public abstract int luoKysymys(Kysymys kysymys);

	public abstract Kysymys paivitaKysymys(Kysymys kysymys);

	public abstract int poistaKysymys(int id);
	
	//tuloksien tallettaminen
	
	public abstract void talletaTulos(Tulos tulos);
}
