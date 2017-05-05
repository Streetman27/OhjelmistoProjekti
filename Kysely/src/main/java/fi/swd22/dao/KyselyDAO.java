package fi.swd22.dao;

import java.util.List;

import fi.swd22.bean.Kysely;
import fi.swd22.bean.Kysymys;
import fi.swd22.bean.Tulos;

public interface KyselyDAO {

	// Kyselyn käsittely
	public abstract List<Kysely> haeKaikkiKyselyt();

	public abstract Kysely haeKysely(int id);

	// Yhden kysymyksen käsittely
	public abstract Kysymys haeKysymys(int id);

	public abstract void luoKysymys(Kysymys kysymys, final int kysely_id);

	public abstract Kysymys paivitaKysymys(Kysymys kysymys);

	public abstract int poistaKysymys(int id);

	// Tuloksien käsittely
	public abstract List<Tulos> haeTulosKysymys(int id);

	public abstract void talletaTulos(Tulos tulos);
}
