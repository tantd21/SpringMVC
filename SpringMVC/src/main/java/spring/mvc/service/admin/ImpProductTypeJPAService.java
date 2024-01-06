package spring.mvc.service.admin;

import java.util.List;

import spring.mvc.entity.ProductTypeJPA;

public interface ImpProductTypeJPAService {
	public List<ProductTypeJPA> getAllProductTypeJPAs();
	public ProductTypeJPA findProductTypeJPAById(Long id);
	public void deleteProductTypeJPA(Long id);
	public boolean saveProductType(ProductTypeJPA productTypeJPA);
	public boolean updateProductType(ProductTypeJPA productTypeJPA);
	public String updateUnActiveProductType(Long prodLong, int status);
}
