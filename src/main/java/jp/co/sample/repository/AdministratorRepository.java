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

	private static final RowMapper<Administrator> ADMINISTRATOR_ROW_MAPPER = (rs, i) -> {
		Administrator administrator = new Administrator();
		administrator.setId(rs.getInt("id"));
		administrator.setName(rs.getString("name"));
		administrator.setMailAddress(rs.getString("mailAddress"));
		administrator.setPassword(rs.getString("password"));
		return administrator;
	};

	@Autowired
	private NamedParameterJdbcTemplate template;

	public void insert(Administrator administractor) {
		SqlParameterSource param = new BeanPropertySqlParameterSource(administractor);

		String insertSql = "insert into administrators (name,mail_address,password) values (:name, :mailAddress, :password)";
		template.update(insertSql, param);

	}

	public Administrator findByMailAddressAndPassword(String mailAddress, String password) {
		String sql = "select id, name, mail_address, password from administrators where mail_address =:mailAddress and password =:password";
		SqlParameterSource param = new MapSqlParameterSource().addValue("password", password).addValue("mailAddress", mailAddress);
		
		List<Administrator> administratorList = template.query(sql, param, ADMINISTRATOR_ROW_MAPPER);
		if (administratorList.size() == 0) {
			return null;
		}
		return administratorList.get(0);
	}

}
