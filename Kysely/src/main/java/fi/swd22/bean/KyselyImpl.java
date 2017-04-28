package fi.swd22.bean;

import java.util.List;

public class KyselyImpl implements Kysely{
	private int id;
	private String nimi;
	//private String kuvaus; todo
	private List<Kysymys> kysymykset;
	
	public KyselyImpl() {
		super();
	}
	public KyselyImpl(int id, String nimi) {
		super();
		this.id = id;
		this.nimi = nimi;
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
	public List<Kysymys> getKysymykset() {
		return kysymykset;
	}
	public void setKysymykset(List<Kysymys> kysymykset) {
		this.kysymykset = kysymykset;
	}
	@Override
	public String toString() {
		return "KyselyImpl [id=" + id + ", Nimi=" + nimi + "]";
	}
}
