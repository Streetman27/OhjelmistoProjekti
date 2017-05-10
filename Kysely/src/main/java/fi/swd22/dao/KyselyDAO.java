package fi.swd22.dao;

import java.util.List;

import fi.swd22.bean.Kysely;
import fi.swd22.bean.Kysymys;
import fi.swd22.bean.LuoKysymys;
import fi.swd22.bean.Tulos;

public interface KyselyDAO {

	// Kyselyn käsittely
	public abstract int luoKysely(Kysely kysely);
	
	public abstract List<Kysely> haeKaikkiKyselyt();

	public abstract Kysely haeKysely(int id);

	// Yhden kysymyksen käsittely
	public abstract Kysymys haeKysymys(int id);

	public abstract int luoKysymys(LuoKysymys kysymys);

	public abstract Kysymys paivitaKysymys(Kysymys kysymys);

	public abstract int poistaKysymys(int id);

	// Tuloksien käsittely
	public abstract List<Tulos> haeTulosKysymys(int id);

	public abstract int talletaTulos(Tulos tulos);
}
