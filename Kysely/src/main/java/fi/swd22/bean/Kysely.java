package fi.swd22.bean;

import java.util.List;

public class Kysely {
	private int id;
	private String nimi;
	private String kuvaus;
	private List<Kysymys> kysymykset;

	public Kysely() {
		super();
	}

	public Kysely(int id, String nimi, String kuvaus, List<Kysymys> kysymykset) {
		super();
		this.id = id;
		this.nimi = nimi;
		this.kuvaus = kuvaus;
		this.kysymykset = kysymykset;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNimi() {
		return nimi;
	}

	public void setNimi(String nimi) {
		this.nimi = nimi;
	}

	public String getKuvaus() {
		return kuvaus;
	}

	public void setKuvaus(String kuvaus) {
		this.kuvaus = kuvaus;
	}

	public List<Kysymys> getKysymykset() {
		return kysymykset;
	}

	public void setKysymykset(List<Kysymys> kysymykset) {
		this.kysymykset = kysymykset;
	}

	@Override
	public String toString() {
		return "Kysely [id=" + id + ", nimi=" + nimi + ", kuvaus=" + kuvaus
				+ ", kysymykset=" + kysymykset + "]";
	}

}
