package fi.swd22.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import fi.swd22.bean.Kysely;
import fi.swd22.bean.KyselyImpl;

public class KyselyRowMapper implements RowMapper<Kysely> {

	public Kysely mapRow(ResultSet rs, int rowNum) throws SQLException {
		Kysely kysely = new KyselyImpl();
		kysely.setId(rs.getInt("id"));
		kysely.setAihe(rs.getString("aihe"));
		
		
		
		return kysely;
	}

}
