package fi.swd22.bean;

import java.util.List;

public interface Kysely {
	public abstract int getId();

	public abstract void setId(int id);

	public abstract String getAihe();

	public abstract void setAihe(String aihe);

	public abstract List<Kysymys> getKysymykset();

	public abstract void setKysymykset(List<Kysymys> kysymykset);
}
