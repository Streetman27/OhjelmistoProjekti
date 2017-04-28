package fi.swd22.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import fi.swd22.bean.Kysymys;
import fi.swd22.bean.KysymysImpl;
import fi.swd22.bean.Vastaus;
import fi.swd22.bean.VastausImpl;

public class KysymysRowMapper implements RowMapper<Kysymys> {

	public Kysymys mapRow(ResultSet rs, int rowNum) throws SQLException {
		Kysymys kysymys = new KysymysImpl();
		kysymys.setId(rs.getInt("id"));
		kysymys.setKysymys(rs.getString("kysymys"));
		kysymys.setTyyppi(rs.getString("maaritelma"));
		
		
		//vastaus arvot
		String arvot = (rs.getString("arvot")); //Esimerkiksi splittaa Kyllä,Ei,Ehkä
		List<String> items = Arrays.asList(arvot.split("\\s*,\\s*"));
		List<Vastaus> vastaukset = new ArrayList<Vastaus>();

		
//		for (String arvo : items) {
		for (int i = 0; i < items.size(); i++) {
			
			Vastaus vastaus = new VastausImpl();
			vastaus.setArvo(items.get(i));
			vastaukset.add(vastaus);
		}

		kysymys.setVastaukset(vastaukset);
		
		
		return kysymys;
	}

}
