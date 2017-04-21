package fi.swd22.dao;

public interface KyselyDAO {
	
public String listaaKysymys(); //POST

public String tuoKysymys(); //GET

public String haeKysely(); //PUT

public String poistaKysely(); //DELETE

}
