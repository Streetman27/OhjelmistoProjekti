package fi.swd22.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import fi.swd22.bean.Kysely;
import fi.swd22.bean.Kysymys;
import fi.swd22.bean.Vastaus;

@Repository
public class KyselyDAOSpringJdbcImpl implements KyselyDAO {

	@Inject
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public Kysymys haeKysymys() {
		String sql="SELECT K.id, K.kysymys, T.maaritelma, V.teksti"
				+ " FROM kysymys K"
				+ " JOIN kysymys_tyyppi T ON T.id = K.tyyppi_id"
				+ " JOIN vastaus V ON V.kysymys_id = K.id"
				+ " WHERE K.id = ?";
		RowMapper<Kysymys> mapper = new KyselyRowMapper();
		List<Kysymys> kysymykset = jdbcTemplate.query(sql, mapper);
		
		return kysymykset;
	}

	public Kysymys luoKysymys() {
		// TODO Auto-generated method stub
		return null;
	}

	public Kysymys paivitaKysymys() {
		// TODO Auto-generated method stub
		return null;
	}

	public Kysymys poistaKysymys() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}


