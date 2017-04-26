package fi.swd22.dao;

import fi.swd22.bean.Kysymys;

public interface KyselyDAO {

	public Kysymys haeKysymys(String id);

	public Kysymys luoKysymys(String id);

	public Kysymys paivitaKysymys(String id);

	public Kysymys poistaKysymys(String id);

}
