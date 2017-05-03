package fi.swd22.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import fi.swd22.bean.Tulos;

public class TulosRowMapper implements RowMapper<Tulos> {

	public Tulos mapRow(ResultSet rs, int rowNum) throws SQLException {
		Tulos tulos = new Tulos();
		tulos.setId(rs.getInt("id"));
		tulos.setTeksti(rs.getString("teksti"));
		tulos.setKysymys_id(rs.getInt("kysymys_id"));
		tulos.setKysely_id(rs.getInt("kysely_id"));

		return tulos;
	}

}