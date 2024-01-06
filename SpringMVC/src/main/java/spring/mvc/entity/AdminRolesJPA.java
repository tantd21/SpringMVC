package spring.mvc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "admin_roles")
public class AdminRolesJPA {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "admin_roles_id")
    private Long adminRolesId;
	
	@OneToOne
	@JoinColumn(name = "admin_id")
	private AdminJPA adminJPA;
	
	@ManyToOne
    @JoinColumn(name = "roles_id")
    private RolesJPA roles;

	public Long getAdminRolesId() {
		return adminRolesId;
	}

	public void setAdminRolesId(Long adminRolesId) {
		this.adminRolesId = adminRolesId;
	}

	public AdminJPA getAdminJPA() {
		return adminJPA;
	}

	public void setAdminJPA(AdminJPA adminJPA) {
		this.adminJPA = adminJPA;
	}

	public RolesJPA getRoles() {
		return roles;
	}

	public void setRoles(RolesJPA roles) {
		this.roles = roles;
	}
}
