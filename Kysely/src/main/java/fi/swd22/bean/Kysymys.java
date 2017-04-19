package fi.swd22.bean;

import java.util.List;

public interface Kysymys {
	public abstract int getId();
	public abstract String getKysymys();
	public abstract String getTyyppi();
	public abstract List<Vastaus> getVaihtehdot();
}
