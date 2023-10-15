package spring.mvc.controller.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import spring.mvc.Until.Until;
import spring.mvc.model.Flashsale;
import spring.mvc.model.GalleryProduct;
import spring.mvc.model.Product;
import spring.mvc.model.ProductType;
import spring.mvc.service.user.DetailProductService;
import spring.mvc.service.user.InterDetailProductService;

@Controller
@RequestMapping("/cua-hang/san-pham")
public class ProductController {
	@Autowired
	InterDetailProductService interDetailProductService;

	@RequestMapping(value = "/san-pham-chi-tiet")
	public ModelAndView detailProduct(@RequestParam("product_id") int product_id) {
		Product product = new Product();
		List<Product> productCategorys = new ArrayList<>();
//		List<Flashsale> flashsaleCategorys = new ArrayList<>();
//		Flashsale flashsale = new Flashsale();
		List<ProductType> productTypes = new ArrayList<>();
		ModelAndView maView = new ModelAndView("/web/san_pham_chi_tiet");
		for (Product itemProduct : Until.products) {
			if (itemProduct.getProduct_id() == product_id) {
				product = itemProduct;
			}
		}
		productCategorys = interDetailProductService.getDataProductCategoryList(product.getCategory_id());
		for(int i = 0; i < productCategorys.size(); i++) {
			if(productCategorys.get(i).getProduct_id() == product_id) {
				productCategorys.remove(i);
			}
		}
		int temp = 0;
		for (Product itemProduct : Until.productReviewList) {
			if (itemProduct.getProduct_id() == product_id) {
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
//		maView.addObject("flashsale", flashsale);	
		maView.addObject("productTypes", productTypes);
		maView.addObject("galleryProducts", interDetailProductService.getDataGalleryProducts(product_id));
		maView.addObject("productCategory", productCategorys);
		return maView;
	}

}
