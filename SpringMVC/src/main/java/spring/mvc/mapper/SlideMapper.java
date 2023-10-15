package spring.mvc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import spring.mvc.model.Slider;

public class SlideMapper implements RowMapper<Slider>{

	@Override
	public Slider mapRow(ResultSet rs, int arg1) throws SQLException {
		Slider slider = new Slider();
		slider.setSlider_id(rs.getInt("slider_id"));
		slider.setSlider_name(rs.getString("slider_name"));
		slider.setSlider_image(rs.getString("slider_image"));
		slider.setSlider_status(rs.getInt("slider_status"));
		slider.setSlider_desc(rs.getString("slider_desc"));
		slider.setCreated_at(rs.getString("created_at"));
		slider.setUpdated_at(rs.getString("updated_at"));
		slider.setDeleted_at(rs.getString("deleted_at"));
		return slider;
	}
}
