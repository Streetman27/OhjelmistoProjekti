package fi.swd22.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import fi.swd22.bean.Kysely;
import fi.swd22.bean.Kysymys;
import fi.swd22.bean.LuoKysymys;
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

// Kyselyiden k‰sittely
	public List<Kysely> haeKaikkiKyselyt() {
		String sqlKaikkiKyselyt="SELECT id, nimi, kuvaus "
				+ "FROM kysely";
		
		RowMapper<Kysely> mapper = new KyselyRowMapper();
		List<Kysely> kyselyt = jdbcTemplate.query(sqlKaikkiKyselyt, mapper);
		
		return kyselyt;
	}
	
	public int luoKysely(Kysely kysely){
		//lis‰‰ kyselyn
		final String sql = "INSERT INTO kysely (nimi, kuvaus) VALUES (?,?)";
		
		//anonyymi sis‰luokka tarvitsee vakioina v‰litett‰v‰t arvot,
		//jotta roskien keruu onnistuu t‰m‰n metodin suorituksen p‰‰ttyess‰. 
		final String kyselyNimi = kysely.getNimi();
		final String kyselyKuvaus = kysely.getKuvaus();
		
		//jdbc pist‰‰ generoidun id:n t‰nne talteen
		KeyHolder idHolder = new GeneratedKeyHolder();
	    
		//suoritetaan p‰ivitys itse m‰‰ritellyll‰ PreparedStatementCreatorilla ja KeyHolderilla
		jdbcTemplate.update(
	    	    new PreparedStatementCreator() {
	    	        public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
	    	            PreparedStatement ps = connection.prepareStatement(sql, new String[] {"id"});
	    	            ps.setString(1, kyselyNimi);
	    	            ps.setString(2, kyselyKuvaus);
	    	            return ps;
	    	        }
	    	    }, idHolder);
	    
		return idHolder.getKey().intValue();
	}
	
	public Kysely haeKysely(int id) {
		//kysely
		String sqlKysely="SELECT id, nimi, kuvaus "
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
	
// Kysymyksien k‰sittely
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

	public int luoKysymys(LuoKysymys kysymys) {
	//hakee tyypille id:n
		String sqlTyyppiMaaritelma = "SELECT id FROM kysymys_tyyppi WHERE maaritelma = ?";
		String tyyppi = kysymys.getTyyppi();
		final int tyyppi_id = jdbcTemplate.queryForObject(sqlTyyppiMaaritelma, Integer.class, tyyppi);
	//lis‰‰ kysymyksen
		final String sql = "INSERT INTO kysymys (kysymys, tyyppi_id, kysely_id) VALUES (?,?,?)";
		
		//anonyymi sis‰luokka tarvitsee vakioina v‰litett‰v‰t arvot,
		//jotta roskien keruu onnistuu t‰m‰n metodin suorituksen p‰‰ttyess‰. 
		final String kysymysTeksti = kysymys.getKysymys();
		//final int tyyppi_id
		final int kysely_id = kysymys.getKysely_id();
		
		//jdbc pist‰‰ generoidun id:n t‰nne talteen
		KeyHolder idHolder = new GeneratedKeyHolder();
	    
		//suoritetaan p‰ivitys itse m‰‰ritellyll‰ PreparedStatementCreatorilla ja KeyHolderilla
		jdbcTemplate.update(
	    	    new PreparedStatementCreator() {
	    	        public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
	    	            PreparedStatement ps = connection.prepareStatement(sql, new String[] {"id"});
	    	            ps.setString(1, kysymysTeksti);
	    	            ps.setInt(2, tyyppi_id);
	    	            ps.setInt(3, kysely_id);
	    	            return ps;
	    	        }
	    	    }, idHolder);
	    
		//tallennetaan id takaisin beaniin, koska
		//kutsujalla pit‰isi olla viittaus samaiseen olioon
	    int kysymys_id = idHolder.getKey().intValue();
	    
	//lis‰‰ vastaukset
		List<Vastaus> vastaukset = kysymys.getVastaukset();
		for (Vastaus vastaus : vastaukset) {
			String sqlLuoVastaus = "INSERT INTO vastaus (teksti, kysymys_id) VALUES (?, ?)";
			jdbcTemplate.update(sqlLuoVastaus, vastaus.getArvo(), kysymys_id);
		}
		return idHolder.getKey().intValue();
	}

	public Kysymys paivitaKysymys(Kysymys kysymys) {
		// TODO Auto-generated method stub
		return null;
	}

	public int poistaKysymys(int id) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
// Tulosten k‰sittely
	public int talletaTulos(Tulos tulos) {
		final String sqlTulos = "INSERT INTO tulos (teksti, kysely_id, kysymys_id) "
				+ "VALUES (?, ?, ?)";
		
		final String teksti = tulos.getTeksti();
		final int kysely_id = tulos.getKysely_id();
		final int kysymys_id = tulos.getKysymys_id();
		
		KeyHolder idHolder = new GeneratedKeyHolder();
	    
		//suoritetaan p‰ivitys itse m‰‰ritellyll‰ PreparedStatementCreatorilla ja KeyHolderilla
		jdbcTemplate.update(
	    	    new PreparedStatementCreator() {
	    	        public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
	    	            PreparedStatement ps = connection.prepareStatement(sqlTulos, new String[] {"id"});
	    	            ps.setString(1, teksti);
	    	            ps.setInt(2, kysely_id);
	    	            ps.setInt(3, kysymys_id);
	    	            return ps;
	    	        }
	    	    }, idHolder);
	    
		//tallennetaan id takaisin beaniin, koska
		//kutsujalla pit‰isi olla viittaus samaiseen olioon
	    
		return idHolder.getKey().intValue();
	}
	
	public void talletaTulos2(Tulos tulos) {
		String sqlTulos = "INSERT INTO tulos (teksti, kysely_id, kysymys_id) VALUES (?, ?, ?)";
		
		final String teksti = tulos.getTeksti();
		final int kysely_id = tulos.getKysely_id();
		final int kysymys_id = tulos.getKysymys_id();
		
		Object[] parameters = new Object[] { teksti, kysely_id, kysymys_id };
		
		jdbcTemplate.update(sqlTulos, parameters);
	}
	
	public List<Tulos> haeTulosKysymys(int id) {
		String sqlTulokset="SELECT id, teksti, kysely_id, kysymys_id "
				+ "FROM tulos "
				+ "WHERE kysymys_id = ?";
		
		Object[] parameters = new Object[] { id };
		
		RowMapper<Tulos> mapperTulos = new TulosRowMapper();
		List<Tulos> tulokset = jdbcTemplate.query(sqlTulokset, parameters, mapperTulos);
		return tulokset;
	}
}
