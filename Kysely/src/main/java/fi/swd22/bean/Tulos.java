package fi.swd22.bean;

public class Tulos {
	private int id;
	private String teksti;
	private int kysely_id;
	private int kysymys_id;

	public Tulos() {
		super();
	}

	public Tulos(int id, String teksti, int kysely_id, int kysymys_id) {
		super();
		this.id = id;
		this.teksti = teksti;
		this.kysely_id = kysely_id;
		this.kysymys_id = kysymys_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTeksti() {
		return teksti;
	}

	public void setTeksti(String teksti) {
		this.teksti = teksti;
	}

	public int getKysely_id() {
		return kysely_id;
	}

	public void setKysely_id(int kysely_id) {
		this.kysely_id = kysely_id;
	}

	public int getKysymys_id() {
		return kysymys_id;
	}

	public void setKysymys_id(int kysymys_id) {
		this.kysymys_id = kysymys_id;
	}

	@Override
	public String toString() {
		return "Tulos [id=" + id + ", teksti=" + teksti + ", kysely_id="
				+ kysely_id + ", kysymys_id=" + kysymys_id + "]";
	}

}
