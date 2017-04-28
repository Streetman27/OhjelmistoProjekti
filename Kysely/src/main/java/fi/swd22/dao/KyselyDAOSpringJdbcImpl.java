package fi.swd22.dao;

import java.util.List;

import javax.inject.Inject;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
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

	public Kysely haeKysely(int id) {
		String sqlKysely="SELECT id, nimi "
		+ "FROM kysely "
		+ "WHERE id = ?";
		
		String sqlKysymys="SELECT K.id, K.kysymys, T.maaritelma "
		+ "FROM kysymys K "
		+ "JOIN kysymys_tyyppi T ON T.id = K.tyyppi_id "
		+ "JOIN kysely Kys ON Kys.id = K.kysely_id "
		+ "WHERE Kys.id = ?;";
		
		String sqlVastaus="SELECT V.id, V.teksti "
		+ "FROM vastaus V "
		+ "JOIN kysymys K ON K.id = V.kysymys_id "
		+ "JOIN kysely Kys ON Kys.id = K.kysely_id "
		+ "WHERE Kys.id = ?;";
		
		Object[] parameters = new Object[] { id };
		//RowMapper<Kysely> mapperKysely = new KyselyRowMapper();
		RowMapper<Kysymys> mapperKysymys = new KysymysRowMapper();
		RowMapper<Vastaus> mapperVastaus = new VastausRowMapper();
		
		Kysely kysely = jdbcTemplate.queryForObject(sqlKysely, new KyselyRowMapper());
		List<Kysymys> kysymykset = jdbcTemplate.query(sqlKysymys, parameters, mapperKysymys);
		List<Vastaus> vastaukset = jdbcTemplate.query(sqlVastaus, parameters, mapperVastaus);
		
		kysely.setKysymykset(kysymykset);
		
		return kysely;
	}
	
	public Kysymys haeKysymys(int id) {
		String sqlKysymys="SELECT K.id, K.kysymys, T.maaritelma "
				+ "FROM kysymys K "
				+ "JOIN kysymys_tyyppi T ON T.id = K.tyyppi_id "
				+ "WHERE K.id = ?";
		
		String sqlVastaus="SELECT V.id, V.teksti "
				+ "FROM vastaus V "
				+ "JOIN kysymys K ON K.id = V.kysymys_id "
				+ "WHERE K.id = ?";
		
		Object[] parameters = new Object[] { id };
		RowMapper<Vastaus> mapperVastaus = new VastausRowMapper();
		
		Kysymys kysymys = jdbcTemplate.queryForObject(sqlKysymys, parameters, new KysymysRowMapper());
		List<Vastaus> vastaukset = jdbcTemplate.query(sqlVastaus, parameters, mapperVastaus);
		kysymys.setVastaukset(vastaukset);
		
		return kysymys;
	}

	public int luoKysymys(Kysymys kysymys) {
		// TODO Auto-generated method stub
		return 0;
	}

	public Kysymys paivitaKysymys(Kysymys kysymys) {
		// TODO Auto-generated method stub
		return null;
	}

	public int poistaKysymys(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	
}


