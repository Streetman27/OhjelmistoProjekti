package fi.swd22.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import fi.swd22.bean.Kysymys;

public class KysymysRowMapper implements RowMapper<Kysymys> {

	public Kysymys mapRow(ResultSet rs, int rowNum) throws SQLException {
		Kysymys kysymys = new Kysymys();
		kysymys.setId(rs.getInt("id"));
		kysymys.setKysymys(rs.getString("kysymys"));
		kysymys.setTyyppi(rs.getString("maaritelma"));
		
		
		return kysymys;
	}

}
