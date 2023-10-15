package spring.mvc.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class BaseRepository {
	@Autowired
	public JdbcTemplate jdbcTemplate;
}
