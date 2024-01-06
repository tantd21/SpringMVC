package spring.mvc.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tbl_roles")
public class RolesJPA {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "roles_id")
    private Long rolesId;

    @Column(name = "roles_name")
    private String rolesName;

    @Column(name = "created_at", nullable = true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;

	@Column(name = "updated_at", nullable = true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedAt;

	@PrePersist
	protected void onCreate() {
		createdAt = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		updatedAt = new Date();
	}
	
	@OneToMany(mappedBy = "roles", cascade = CascadeType.ALL)
	private List<AdminRolesJPA> adminRolesJPAs;

	public Long getRolesId() {
		return rolesId;
	}

	public void setRolesId(Long rolesId) {
		this.rolesId = rolesId;
	}

	public String getRolesName() {
		return rolesName;
	}

	public void setRolesName(String rolesName) {
		this.rolesName = rolesName;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public List<AdminRolesJPA> getAdminRolesJPAs() {
		return adminRolesJPAs;
	}

	public void setAdminRolesJPAs(List<AdminRolesJPA> adminRolesJPAs) {
		this.adminRolesJPAs = adminRolesJPAs;
	}
}
