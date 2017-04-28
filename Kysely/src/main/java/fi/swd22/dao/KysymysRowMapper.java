package fi.swd22.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
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
		Vastaus vastaus = new VastausImpl();
		
		kysymys.setId(rs.getInt("id"));
		kysymys.setKysymys(rs.getString("kysymys"));
		kysymys.setTyyppi(rs.getString("maaritelma"));

		//vastaus arvot
		String arvot = (rs.getString("arvot"));
		List<String> items = Arrays.asList(arvot.split(","));
		List<Vastaus> vastaukset = null;
		for (String arvo : items) {
			vastaus.setArvo(arvo);
			vastaukset.add(vastaus);
		}
		kysymys.setVastaukset(vastaukset);
		
		return kysymys;
	}

}
