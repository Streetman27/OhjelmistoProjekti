package fi.swd22.bean;

public class VastausImpl implements Vastaus {
	private int id;
	private String arvo;
	public VastausImpl() {
		super();
	}
	public VastausImpl(int id, String arvo) {
		super();
		this.id = id;
		this.arvo = arvo;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getArvo() {
		return arvo;
	}
	public void setArvo(String arvo) {
		this.arvo = arvo;
	}
	@Override
	public String toString() {
		return "VastausImpl [id=" + id + ", arvo=" + arvo + "]";
	}
}
