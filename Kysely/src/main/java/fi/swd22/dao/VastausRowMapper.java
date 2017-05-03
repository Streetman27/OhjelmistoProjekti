package fi.swd22.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import fi.swd22.bean.Vastaus;

public class VastausRowMapper implements RowMapper<Vastaus> {

	public Vastaus mapRow(ResultSet rs, int rowNum) throws SQLException {
		Vastaus vastaus = new Vastaus();
		vastaus.setId(rs.getInt("id"));
		vastaus.setArvo(rs.getString("teksti"));
		
		return vastaus;
	}

}
