package fi.swd22.dao;

import java.util.List;

import javax.inject.Inject;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

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

	public Kysymys haeKysymys(int id) {
		String sqlKysymys="SELECT K.id, K.kysymys, T.maaritelma "
				+ "FROM kysymys K "
				+ "JOIN kysymys_tyyppi T ON T.id = K.tyyppi_id "
				+ "WHERE K.id = ?";
		
		String sqlVastaukset="SELECT V.id, V.teksti "
				+ "FROM vastaus V "
				+ "JOIN kysymys K ON K.id = V.kysymys_id "
				+ "WHERE K.id = ?";
		
		Object[] parameters = new Object[] { id };
		RowMapper<Kysymys> mapperKysymys = new KysymysRowMapper();
		RowMapper<Vastaus> mapperVastaus = new VastausRowMapper();
		
		List<Kysymys> kysymykset = jdbcTemplate.query(sqlKysymys, parameters, mapperKysymys);
		List<Vastaus> vastaukset = jdbcTemplate.query(sqlVastaukset, parameters, mapperVastaus);
		Kysymys kysymys = kysymykset.get(0);  //paivitä tätä
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


