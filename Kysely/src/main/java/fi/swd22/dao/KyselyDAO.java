package fi.swd22.dao;

import java.util.List;

import fi.swd22.bean.Kysely;
import fi.swd22.bean.Kysymys;
import fi.swd22.bean.LuoKysymys;
import fi.swd22.bean.Tulos;

public interface KyselyDAO {

	// Kyselyn k�sittely
	public abstract List<Kysely> haeKaikkiKyselyt();

	public abstract Kysely haeKysely(int id);

	public abstract int luoKysely(Kysely kysely);

	public abstract void paivitaKysely(int id, Kysely kysely);

	public abstract Kysely poistaKysely(int id);

	// Yhden kysymyksen k�sittely
	public abstract Kysymys haeKysymys(int id);

	public abstract int luoKysymys(LuoKysymys kysymys);

	public abstract void paivitaKysymys(int id, LuoKysymys kysymys);

	public abstract Kysymys poistaKysymys(int id);

	// Tuloksien k�sittely
	public abstract List<Tulos> haeTulosKysymys(int id);

	public abstract int talletaTulos(Tulos tulos);
}
