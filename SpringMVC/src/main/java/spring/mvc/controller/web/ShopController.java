package spring.mvc.controller.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import spring.mvc.Until.Until;
import spring.mvc.entity.CategoryJPA;
import spring.mvc.entity.ProductJPA;
import spring.mvc.model.Product;
import spring.mvc.service.user.HomeService;

@Controller
public class ShopController {

	@Autowired
	HomeService homeService;

	@RequestMapping(value = "/cua-hang")
	public ModelAndView shopProduct() {
		ModelAndView mav = new ModelAndView("/web/shop_drink");
		List<ProductJPA> products = homeService.getDataProducts();
		List<CategoryJPA> categoryJPAs = homeService.getCategoryJPAs();
		ProductJPA productMax = homeService.findProductWithMaxPrice();
		ProductJPA productMin = homeService.findProductWithMinPrice();
		mav.addObject("products", products);
		mav.addObject("priceMin", productMin.getProductPrice());
		mav.addObject("priceMax", productMax.getProductPrice());
		mav.addObject("categories", categoryJPAs);
		return mav;
	}

	@RequestMapping(value = "/cua-hang/load-danh-sach-san-pham", produces = "application/x-www-form-urlencoded;charset=UTF-8")
	@ResponseBody
	public String getListProductBuilder() {
		String string = new String();
		List<ProductJPA> products = homeService.getDataProducts();
		string = print_danh_sach_san_pham(products).toString();
		return string.toString();
	}

	@RequestMapping(value = "/cua-hang/search-san-pham", produces = "application/x-www-form-urlencoded;charset=UTF-8")
	@ResponseBody
	public String searchProduct(@RequestParam("priceMin") int priceMin, @RequestParam("priceMax") int priceMax,
			@RequestParam("text") String text, @RequestParam("valueOption") String valueOption,
			@RequestParam("typeOption") String typeOption, @RequestParam("listId") List<Integer> categoryIdList) {
		System.out.println("hahaha");
		List<ProductJPA> productJPAs = homeService.searchProducts(priceMin, priceMax, text, valueOption, text, categoryIdList);
		return print_danh_sach_san_pham(productJPAs).toString();
	}

	public StringBuilder print_danh_sach_san_pham(List<ProductJPA> datas) {
		StringBuilder outputString = new StringBuilder();
		for (ProductJPA product : datas) {
			outputString.append("<div class=\"col-lg-4 col-md-6 col-sm-6\">"
					+ "<div class=\"flashsalehotel_boxcontent item\">"
					+ "<div class=\"flashsalehotel_boxcontent_img_text\">" + "<div class=\"flashsalehotel_img-box\">"
					+ "<a href=\"/SpringMVC/cua-hang/san-pham/san-pham-chi-tiet?product_id=" + product.getProductId()
					+ "\" class=\"flashsalehotel_boxcontent_hover\">"
					+ "<img class=\"flashsalehotel_img\" width=\"284px\" height=\"160px\" style=\"object-fit: cover;\""
					+ "src=\"assets/web/img/product/" + product.getProductImage() + "\" alt=\"\">" + "</a> </div>"
					+ "<div class=\"flashsalehotel_text\">" + "<div class=\"flashsalehotel_text-title\">"
					+ product.getCategory().getCategoryName() + "</div>" + "<div class=\"flashsalehotel_place\">"
					+ "<div>" + "     <i class=\"fa-solid fa-certificate\"></i> " + product.getProductName()
					+ "</div></div>");
			if (product.getFlashsaleStatus() == 1) {
				outputString.append("<div class=\"flashsalehotel_text-time\">Giảm giá</div>");
			} else {
				outputString.append("<div class=\"flashsalehotel_text-time\">\r\n" + "Sản phẩm" + "</div>'");
			}
			outputString.append("<div class=\"flashsalehotel_text-box-price\">");
			if (product.getFlashsaleStatus() == 0) {
				outputString.append(" <div class=\"flashsalehotel_text-box-price-two\">" + "<span>"
						+ Until.convertNumber(product.getProductPrice()) + " đ</span>" + "</div>");
				;
			} else {
				outputString.append("<div style=\"display: flex; justify-content:right\">\r\n"
						+ " <div class=\"flashsalehotel_text-box-price-two\">\r\n" + " <span>"
						+ Until.convertNumber(product.getFlashsale().getFlashsalePriceSale()) + "đ</span>\r\n"
						+ " </div>\r\n" + " <div class=\"flashsalehotel_text-box-price-one\">\r\n"
						+ " <span>/</span>\r\n" + " </div>\r\n"
						+ " <div class=\"flashsalehotel_text-box-price-one\">\r\n"
						+ " <span style=\"text-decoration: line-through\">"
						+ Until.convertNumber(product.getProductPrice()) + "đ</span>\r\n" + " </div>\r\n" + " </div>");
			}
			outputString.append("<div class=\"flashsalehotel_text-box-price-three bordernhay\">\r\n"
					+ "<div style=\"margin-left: 8px;\"\r\n"
					+ "    class=\"flashsalehotel_text-box-price-three-l chunhay\">\r\n"
					+ "  <div class=\"cart-hover\">\r\n" + " <i class=\"fa-solid fa-heart\"></i>\r\n"
					+ "<span style=\"font-size: 14px;\">Yêu Thích</span>\r\n" + "</div>\r\n" + "</div>\r\n"
					+ "<div class=\"flashsalehotel_text-box-price-three-r chunhay\">\r\n"
					+ "<div class=\"cart-hover\" data-toggle=\"modal\" data-target=\"#shopping\" data-product_id=\""
					+ product.getProductId() + "\">\r\n" + "<i class=\"fa-solid fa-cart-shopping\"></i>\r\n"
					+ "<span style=\"font-size: 14px;\">Đặt Hàng</span>\r\n" + "</div>\r\n" + "</div>\r\n"
					+ "</div>\r\n" + "</div>\r\n" + "</div>\r\n" + "</div>\r\n" + "</div>\r\n" + "\r\n" + "</div>");
		}
		return outputString;
	}

}
