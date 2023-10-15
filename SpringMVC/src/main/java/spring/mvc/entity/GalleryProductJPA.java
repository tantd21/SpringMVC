package spring.mvc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_gallery_product")
public class GalleryProductJPA {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "gallery_id")
	private Long galleryId;
	
	@Column(name = "gallery_image_product")
	private String galleryImageProduct;
	
	@Column(name = "gallery_image_name")
	private String galleryImageName;
	
	@Column(name = "gallery_image_content")
	private String galleryImageContent;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_id")
	ProductJPA product;

	public Long getGalleryId() {
		return galleryId;
	}

	public void setGalleryId(Long galleryId) {
		this.galleryId = galleryId;
	}

	public String getGalleryImageProduct() {
		return galleryImageProduct;
	}

	public void setGalleryImageProduct(String galleryImageProduct) {
		this.galleryImageProduct = galleryImageProduct;
	}

	public String getGalleryImageName() {
		return galleryImageName;
	}

	public void setGalleryImageName(String galleryImageName) {
		this.galleryImageName = galleryImageName;
	}

	public String getGalleryImageContent() {
		return galleryImageContent;
	}

	public void setGalleryImageContent(String galleryImageContent) {
		this.galleryImageContent = galleryImageContent;
	}

	public ProductJPA getProduct() {
		return product;
	}

	public void setProduct(ProductJPA product) {
		this.product = product;
	}
	
}
