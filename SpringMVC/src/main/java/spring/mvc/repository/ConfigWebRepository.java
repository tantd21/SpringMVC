package spring.mvc.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import spring.mvc.mapper.ConfigWebMapper;
import spring.mvc.mapper.SlideMapper;
import spring.mvc.model.ConfigWeb;

@Repository
public class ConfigWebRepository extends BaseRepository{
	
	public List<ConfigWeb> getConfigWebList(){
		List<ConfigWeb> list = new ArrayList<>();
		String sqlString = "SELECT * FROM `tbl_configweb` WHERE tbl_configweb.config_type = 2";
		list = jdbcTemplate.query(sqlString, new ConfigWebMapper());
		return list;
	}
	
}
