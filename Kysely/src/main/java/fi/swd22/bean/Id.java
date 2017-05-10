package fi.swd22.bean;

public class Id {
	private int id;

	public Id() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Id(int id) {
		super();
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Id [id=" + id + "]";
	}
	
}
