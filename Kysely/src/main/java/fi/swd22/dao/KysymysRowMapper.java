package fi.swd22.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import fi.swd22.bean.Kysymys;
import fi.swd22.bean.KysymysImpl;

public class KysymysRowMapper implements RowMapper<Kysymys> {

	public Kysymys mapRow(ResultSet rs, int rowNum) throws SQLException {
		Kysymys kysymys = new KysymysImpl();
		kysymys.setId(rs.getInt("id"));
		kysymys.setKysymys(rs.getString("kysymys"));
		kysymys.setTyyppi(rs.getString("maaritelma"));
		
		
		return kysymys;
	}

}
