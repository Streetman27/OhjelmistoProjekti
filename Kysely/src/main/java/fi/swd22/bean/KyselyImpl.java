package fi.swd22.bean;

import java.util.List;

public class KyselyImpl implements Kysely{
	private int id;
	private String Aihe;
	private List<Kysymys> kysymykset;
	
	public KyselyImpl() {
		super();
	}
	public KyselyImpl(int id, String aihe) {
		super();
		this.id = id;
		Aihe = aihe;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAihe() {
		return Aihe;
	}
	public void setAihe(String aihe) {
		Aihe = aihe;
	}
	public List<Kysymys> getKysymykset() {
		return kysymykset;
	}
	public void setKysymykset(List<Kysymys> kysymykset) {
		this.kysymykset = kysymykset;
	}
	@Override
	public String toString() {
		return "KyselyImpl [id=" + id + ", Aihe=" + Aihe + "]";
	}
}
