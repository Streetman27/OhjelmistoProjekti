package fi.swd22.dao;

import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import fi.swd22.bean.Kysely;
import fi.swd22.bean.Kysymys;
import fi.swd22.bean.Tulos;
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
		//kysely
		String sqlKysely="SELECT id, nimi "
		+ "FROM kysely "
		+ "WHERE id = ?";
		
		Object[] kyselyId = new Object[] { id };
		Kysely kysely = jdbcTemplate.queryForObject(sqlKysely, kyselyId, new KyselyRowMapper());
		
		//kysymys
		String sqlKysymys="SELECT K.id, K.kysymys, T.maaritelma "
		+ "FROM kysymys K "
		+ "JOIN kysymys_tyyppi T ON T.id = K.tyyppi_id "
		+ "JOIN kysely Kys ON Kys.id = K.kysely_id "
		+ "WHERE Kys.id = ?;";
		
		RowMapper<Kysymys> mapperKysymys = new KysymysRowMapper();
		List<Kysymys> kysymykset = jdbcTemplate.query(sqlKysymys, kyselyId, mapperKysymys);
		
		//vastaukset/vaihtoehdot
		String sqlVastaus="SELECT V.id, V.teksti "
				+ "FROM vastaus V "
				+ "JOIN kysymys K ON K.id = V.kysymys_id "
				+ "WHERE K.id = ?";
		
		RowMapper<Vastaus> mapperVastaus = new VastausRowMapper();
		
		for (Iterator<Kysymys> iterator = kysymykset.iterator(); iterator.hasNext();) {
			Kysymys kysymys = (Kysymys) iterator.next();
			
			Object[] kysymysId = new Object[] { kysymys.getId() };
			List<Vastaus> vastaukset = jdbcTemplate.query(sqlVastaus, kysymysId, mapperVastaus);
			
			kysymys.setVastaukset(vastaukset);
		}
		
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

	public void talletaTulos(Tulos tulos) {
		String sqlTulos = "INSERT INTO tulos (teksti, kysely_id, kysymys_id) "
				+ "VALUES (?, ?, ?)";
		
		final String teksti = tulos.getTeksti();
		final int kysely_id = tulos.getKysely_id();
		final int kysymys_id = tulos.getKysymys_id();
		
		Object[] parameters = new Object[] { teksti, kysely_id, kysymys_id };
		
		jdbcTemplate.update(sqlTulos, parameters);
	}
}


