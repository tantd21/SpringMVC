package spring.mvc.service.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.mvc.entity.ProductTypeJPA;
import spring.mvc.repositoryJpa.ProductTypeJPARepository;

@Service
public class ProductTypeJPAService implements ImpProductTypeJPAService{

	@Autowired
	ProductTypeJPARepository productTypeJPARepository;
	
	@Override
	public List<ProductTypeJPA> getAllProductTypeJPAs() {
		// TODO Auto-generated method stub
		return productTypeJPARepository.findAll();
	}

	@Override
	public ProductTypeJPA findProductTypeJPAById(Long id) {
		// TODO Auto-generated method stub
		return productTypeJPARepository.findOne(id);
	}

	@Override
	public void deleteProductTypeJPA(Long id) {
		// TODO Auto-generated method stub
		productTypeJPARepository.delete(id);
	}

	@Override
	public boolean saveProductType(ProductTypeJPA productTypeJPA) {
		productTypeJPARepository.save(productTypeJPA);
		return true;
	}
	
	@Override
	public boolean updateProductType(ProductTypeJPA productTypeJPA) {
		productTypeJPARepository.save(productTypeJPA);
		return true;
	}
	@Override
	public String updateUnActiveProductType(Long prodLong, int status) {
		productTypeJPARepository.updateUnActiveProduct(prodLong, status);
		String string = "";
		if(status == 0) {
			string = string + "<i style=\"color: rgb(196, 203, 196); font-size: 30px\"\r\n"
					+ "class=\"mdi mdi-toggle-switch-off btn-un-active\"\r\n"
					+ "data-product_id=\"" + prodLong + "\" data-status=\"1\"></i>";
		}else {
			string = string + "<i style=\"color: rgb(52, 211, 52); font-size: 30px\"\r\n"
					+ "class=\"mdi mdi-toggle-switch btn-un-active\"\r\n"
					+ "data-product_id=\""+ prodLong +"\" data-status=\"0\"></i>";
		}
		return string;
	}
}
