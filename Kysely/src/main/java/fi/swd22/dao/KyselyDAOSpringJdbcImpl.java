package fi.swd22.dao;

import java.util.List;

import javax.inject.Inject;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import fi.swd22.bean.Kysymys;

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
		String sql="SELECT K.id, K.kysymys, T.maaritelma, GROUP_CONCAT(V.teksti) as arvot"
				+ " FROM kysymys K"
				+ " JOIN kysymys_tyyppi T ON T.id = K.tyyppi_id"
				+ " JOIN vastaus V ON V.kysymys_id = K.id"
				+ " WHERE K.id = ?";
		Object[] parameters = new Object[] { id };
		RowMapper<Kysymys> mapper = new KysymysRowMapper();
		
		List<Kysymys> kysymykset = jdbcTemplate.query(sql, parameters, mapper);
		Kysymys kysymys = kysymykset.get(1);  //paivitä tätä
		
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


