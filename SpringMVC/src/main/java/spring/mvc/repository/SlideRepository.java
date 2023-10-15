package spring.mvc.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import spring.mvc.controller.web.HomeController;
import spring.mvc.mapper.SlideMapper;
import spring.mvc.model.Slider;

@Repository
public class SlideRepository extends BaseRepository{
	
	public List<Slider> getSlideList() {
		List<Slider> listSliders = new ArrayList<>();
		String sqlString = "SELECT * FROM `tbl_slider` WHERE tbl_slider.deleted_at IS NULL";
		listSliders = jdbcTemplate.query(sqlString, new SlideMapper());
		return listSliders;
	}
	
}
