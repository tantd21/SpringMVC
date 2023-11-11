package spring.mvc.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "tbl_product")
public class ProductJPA {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "product_id")
	private Long productId;

	@Column(name = "product_name")
	private String productName;

//	@Column(name = "category_id")
//	private Long categoryId;

	@Column(name = "product_desc")
	private String productDesc;

	@Column(name = "product_image")
	private String productImage;

	@Column(name = "product_price")
	private double productPrice;

	@Column(name = "product_status")
	private int productStatus;

	@Column(name = "flashsale_status", nullable = true)
	private int flashsaleStatus;

	@Column(name = "product_view", nullable = true)
	private int productView;
	
	@OneToOne(mappedBy = "product", cascade = CascadeType.ALL)
	private FlashsaleJPA flashsale;

	@Column(name = "created_at", nullable = true)

	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;

	@Column(name = "updated_at", nullable = true)

	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedAt;

	@Column(name = "deleted_at", nullable = true)

	@Temporal(TemporalType.TIMESTAMP)
	private Date deletedAt;

	@PrePersist
	protected void onCreate() {
		createdAt = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		updatedAt = new Date();
	}

	@ManyToOne
	@JoinColumn(name = "category_id")
	private CategoryJPA category;


	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
	private List<GalleryProductJPA> galleryProducts;

	public FlashsaleJPA getFlashsale() {
		return flashsale;
	}

	public void setFlashsale(FlashsaleJPA flashsale) {
		this.flashsale = flashsale;
	}

	public List<GalleryProductJPA> getGalleryProducts() {
		return galleryProducts;
	}

	public void setGalleryProducts(List<GalleryProductJPA> galleryProducts) {
		this.galleryProducts = galleryProducts;
	}

	public CategoryJPA getCategory() {
		return category;
	}

	public void setCategory(CategoryJPA category) {
		this.category = category;
	}
	


	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

//	public Long getCategoryId() {
//		return categoryId;
//	}
//
//	public void setCategoryId(Long categoryId) {
//		this.categoryId = categoryId;
//	}

	public String getProductDesc() {
		return productDesc;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}

	public String getProductImage() {
		return productImage;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public int getProductStatus() {
		return productStatus;
	}

	public void setProductStatus(int productStatus) {
		this.productStatus = productStatus;
	}

	public int getFlashsaleStatus() {
		return flashsaleStatus;
	}

	public void setFlashsaleStatus(int flashsaleStatus) {
		this.flashsaleStatus = flashsaleStatus;
	}

	public int getProductView() {
		return productView;
	}

	public void setProductView(int productView) {
		this.productView = productView;
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

	public Date getDeletedAt() {
		return deletedAt;
	}

	public void setDeletedAt(Date deletedAt) {
		this.deletedAt = deletedAt;
	}

}
