package spring.mvc.repositoryJpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import spring.mvc.entity.GalleryProductJPA;

public interface GalleryProductJPARepository extends JpaRepository<GalleryProductJPA, Long>{
	
	@Transactional
	@Query("SELECT g FROM GalleryProductJPA g WHERE g.product.productId =:productId")
	List<GalleryProductJPA> findGalleryProductJPAsById(@Param("productId") Long productId);
	
	@Transactional
	@Modifying
	@Query("DELETE FROM GalleryProductJPA g WHERE g.galleryId =:galleryId")
	void deletedProduct(@Param("galleryId") Long galleryId);
	
	@Transactional
	@Modifying
	@Query("UPDATE GalleryProductJPA gp SET gp.galleryImageContent =:content WHERE gp.galleryId = :galleryId")
	void updateGalleryContent(@Param("galleryId") Long galleryId, @Param("content") String content);
	
	@Transactional
	@Modifying
	@Query("UPDATE GalleryProductJPA gp SET gp.galleryImageName =:content WHERE gp.galleryId = :galleryId")
	void updateGalleryName(@Param("galleryId") Long galleryId, @Param("content") String content);
}
