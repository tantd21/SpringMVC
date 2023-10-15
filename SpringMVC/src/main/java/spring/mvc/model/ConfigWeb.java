package spring.mvc.model;

public class ConfigWeb {
	private int config_id;
	private String config_image;
	private String config_title;
	private String config_content;
	private int config_type;
	private String created_at;
	private String updated_at;
	
	public ConfigWeb() {}
	
	public ConfigWeb(
			int config_id, 
			String config_image, 
			String config_title, 
			String config_content, 
			int config_type,
			String created_at, 
			String updated_at) {
		super();
		this.config_id = config_id;
		this.config_image = config_image;
		this.config_title = config_title;
		this.config_content = config_content;
		this.config_type = config_type;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}
	public int getConfig_id() {
		return config_id;
	}
	public void setConfig_id(int config_id) {
		this.config_id = config_id;
	}
	public String getConfig_image() {
		return config_image;
	}
	public void setConfig_image(String config_image) {
		this.config_image = config_image;
	}
	public String getConfig_title() {
		return config_title;
	}
	public void setConfig_title(String config_title) {
		this.config_title = config_title;
	}
	public String getConfig_content() {
		return config_content;
	}
	public void setConfig_content(String config_content) {
		this.config_content = config_content;
	}
	public int getConfig_type() {
		return config_type;
	}
	public void setConfig_type(int config_type) {
		this.config_type = config_type;
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
	
	
}
