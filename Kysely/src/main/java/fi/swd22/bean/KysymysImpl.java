package fi.swd22.bean;

import java.util.List;

import fi.swd22.bean.Vastaus;

public class KysymysImpl implements Kysymys {
	private int id;
	private String kysymys;
	private String tyyppi;
	private List<Vastaus> vastaukset;
	public KysymysImpl() {
		super();
	}
	public KysymysImpl(int id, String kysymys, String tyyppi,
			List<Vastaus> vastaukset) {
		super();
		this.id = id;
		this.kysymys = kysymys;
		this.tyyppi = tyyppi;
		this.vastaukset = vastaukset;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getKysymys() {
		return kysymys;
	}
	public void setKysymys(String kysymys) {
		this.kysymys = kysymys;
	}
	public String getTyyppi() {
		return tyyppi;
	}
	public void setTyyppi(String tyyppi) {
		this.tyyppi = tyyppi;
	}
	public List<Vastaus> getVaihtehdot() {
		return vastaukset;
	}
	public void setVastaukset(List<Vastaus> vastaukset) {
		this.vastaukset = vastaukset;
	}
	@Override
	public String toString() {
		return "KysymysImpl [id=" + id + ", kysymys=" + kysymys + ", tyyppi="
				+ tyyppi + ", vastaukset=" + vastaukset + "]";
	}
}
