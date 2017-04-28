package fi.swd22.bean;

import java.util.List;

public interface Kysymys {
	public abstract int getId();
	
	public abstract void setId(int Id);
	
	public abstract String getKysymys();
	
	public abstract void setKysymys(String kysymys);
	
	public abstract String getTyyppi();
	
	public abstract void setTyyppi(String tyyppi);
	
	public abstract List<Vastaus> getVastaukset();
	
	public abstract void setVastaukset(List<Vastaus> vastaukset);
	
}
