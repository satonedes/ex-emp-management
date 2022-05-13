package jp.co.sample.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import jp.co.sample.domain.Administrator;

@Repository
public class AdministratorRepository {

	private static final RowMapper<Administrator> ADMINISTRACTOR_ROW_MAPPER = (rs, i) -> {
		Administrator administractor = new Administrator();
		administractor.setId(rs.getInt("id"));
		administractor.setName(rs.getString("name"));
		administractor.setMail(rs.getString("mail"));
		administractor.setPassword(rs.getString("password"));
		return administractor;
	};

	@Autowired
	private NamedParameterJdbcTemplate template;

	public void insert(Administrator administractor) {
		SqlParameterSource param = new BeanPropertySqlParameterSource(administractor);

		String insertSql = "insert into administractors(name,mail_adress,password)values(:name,:mail,;password)";
		template.update(insertSql, param);

	}

	public Administrator findByMailAddressAndPassword(String mailAddress, String password) {
		String sql = "select id, name, mail_address, password from administractors where mail_address =:mail and password =;password";
		SqlParameterSource param = new MapSqlParameterSource().addValue("password", password).addValue("mail", mailAddress);
		
		List<Administrator> administractorList = template.query(sql, param, ADMINISTRACTOR_ROW_MAPPER);
		if (administractorList.size() == 0) {
			return null;
		}
		return administractorList.get(0);
	}

}
