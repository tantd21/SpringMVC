package spring.mvc.controller.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import spring.mvc.Until.Until;
import spring.mvc.entity.ProductJPA;
import spring.mvc.entity.ProductTypeJPA;
import spring.mvc.model.Flashsale;
import spring.mvc.model.GalleryProduct;
import spring.mvc.model.Product;
import spring.mvc.model.ProductType;
import spring.mvc.service.user.ImpDetailProductService;
import spring.mvc.service.user.DetailProductService;
import spring.mvc.service.user.HomeService;

@Controller
@RequestMapping("/cua-hang/san-pham")
public class ProductController {
	@Autowired
	DetailProductService interDetailProductService;
	@Autowired
	HomeService inneHomeService;

	@RequestMapping(value = "/san-pham-chi-tiet")
	public ModelAndView detailProduct(@RequestParam("product_id") Long product_id) {
		ProductJPA product = inneHomeService.getProductById(product_id);
		List<ProductJPA> productCategorys = new ArrayList<>();
		List<ProductTypeJPA> productTypes = new ArrayList<>();
		ModelAndView maView = new ModelAndView("/web/san_pham_chi_tiet");
		productCategorys = interDetailProductService.getDataProductCategoryList(product.getCategory().getCategoryId());
		for(int i = 0; i < productCategorys.size(); i++) {
			if(productCategorys.get(i).getProductId() == product_id) {
				productCategorys.remove(i);
			}
		}
		int temp = 0;
		for (ProductJPA itemProduct : Until.productReviewList) {
			if (itemProduct.getProductId() == product_id) {
				temp = 	1;
				break;
			}
		}
		if (Until.productTypes.size() > 0) {
			productTypes = Until.productTypes;
		} else {
			productTypes = interDetailProductService.getDataProductTypes();
		}

		if (temp != 1) {
			Until.productReviewList.add(product);
		}
		maView.addObject("product", product);	
		maView.addObject("productTypes", productTypes);
		maView.addObject("galleryProducts", interDetailProductService.getDataGalleryProducts(product_id));
		maView.addObject("productCategory", productCategorys);
		return maView;
	}

}
