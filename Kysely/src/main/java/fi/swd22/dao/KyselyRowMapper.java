package fi.swd22.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import fi.swd22.bean.Kysely;

public class KyselyRowMapper implements RowMapper<Kysely> {

	public Kysely mapRow(ResultSet rs, int rowNum) throws SQLException {
		Kysely kysely = new Kysely();
		kysely.setId(rs.getInt("id"));
		kysely.setNimi(rs.getString("nimi"));
		kysely.setKuvaus(rs.getString("kuvaus"));

		return kysely;
	}

}
