package spring.mvc.model;

public class Slider {
	private int slider_id;
	private String slider_name;
	private String slider_image;
	private int slider_status;
	private String slider_desc;
	private String created_at;
	private String updated_at;
	private String deleted_at;
	
	public Slider() {
		
	}
	public Slider(int slider_id, String slider_name, String slider_image, int slider_status, String slider_desc,
			String created_at, String updated_at, String deleted_at) {
		super();
		this.slider_id = slider_id;
		this.slider_name = slider_name;
		this.slider_image = slider_image;
		this.slider_status = slider_status;
		this.slider_desc = slider_desc;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.deleted_at = deleted_at;
	}
	
	public int getSlider_id() {
		return slider_id;
	}
	public void setSlider_id(int slider_id) {
		this.slider_id = slider_id;
	}
	public String getSlider_name() {
		return slider_name;
	}
	public void setSlider_name(String slider_name) {
		this.slider_name = slider_name;
	}
	public String getSlider_image() {
		return slider_image;
	}
	public void setSlider_image(String slider_image) {
		this.slider_image = slider_image;
	}
	public int getSlider_status() {
		return slider_status;
	}
	public void setSlider_status(int slider_status) {
		this.slider_status = slider_status;
	}
	public String getSlider_desc() {
		return slider_desc;
	}
	public void setSlider_desc(String slider_desc) {
		this.slider_desc = slider_desc;
	}
	public String getCreated_at() {
		return created_at;
	}
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	public String getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(String updated_at) {
		this.updated_at = updated_at;
	}
	public String getDeleted_at() {
		return deleted_at;
	}
	public void setDeleted_at(String deleted_at) {
		this.deleted_at = deleted_at;
	}
	
	
	
}
