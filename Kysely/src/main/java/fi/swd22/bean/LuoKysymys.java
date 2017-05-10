package fi.swd22.bean;

import java.util.List;

public class LuoKysymys {
		private int kysely_id;
		private int id;
		private String kysymys;
		private String tyyppi;
		private List<Vastaus> vastaukset;
		public LuoKysymys() {
			super();
			// TODO Auto-generated constructor stub
		}
		public LuoKysymys(int kysely_id, int id, String kysymys, String tyyppi, List<Vastaus> vastaukset) {
			super();
			this.kysely_id = kysely_id;
			this.id = id;
			this.kysymys = kysymys;
			this.tyyppi = tyyppi;
			this.vastaukset = vastaukset;
		}
		public int getKysely_id() {
			return kysely_id;
		}
		public void setKysely_id(int kysely_id) {
			this.kysely_id = kysely_id;
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
		public List<Vastaus> getVastaukset() {
			return vastaukset;
		}
		public void setVastaukset(List<Vastaus> vastaukset) {
			this.vastaukset = vastaukset;
		}
		@Override
		public String toString() {
			return "LuoKysymys [kysely_id=" + kysely_id + ", id=" + id + ", kysymys=" + kysymys + ", tyyppi=" + tyyppi
					+ ", vastaukset=" + vastaukset + "]";
		}
		
}
