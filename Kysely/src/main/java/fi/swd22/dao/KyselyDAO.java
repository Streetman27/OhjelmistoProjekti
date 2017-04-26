package fi.swd22.dao;

import fi.swd22.bean.Kysymys;

public interface KyselyDAO {

	public Kysymys haeKysymys();

	public Kysymys luoKysymys();

	public Kysymys paivitaKysely();

	public Kysymys poistaKysely();

}
