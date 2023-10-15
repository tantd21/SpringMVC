package spring.mvc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import spring.mvc.model.ConfigWeb;

public class ConfigWebMapper implements RowMapper<ConfigWeb>{

	@Override
	public ConfigWeb mapRow(ResultSet rs, int arg1) throws SQLException {
		ConfigWeb configWeb = new ConfigWeb();
		configWeb.setConfig_id(rs.getInt("config_id"));
		configWeb.setConfig_content(rs.getString("config_content"));
		configWeb.setConfig_image(rs.getString("config_image"));
		configWeb.setConfig_title(rs.getString("config_title"));
		configWeb.setConfig_type(rs.getInt("config_type"));
		configWeb.setCreated_at(rs.getString("created_at"));
		configWeb.setUpdated_at(rs.getString("updated_at"));		
		return configWeb;
	}
	
}
