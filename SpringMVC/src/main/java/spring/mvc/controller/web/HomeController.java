package spring.mvc.controller.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import spring.mvc.Until.Until;
import spring.mvc.model.Flashsale;
import spring.mvc.model.Product;
import spring.mvc.model.ProductType;
import spring.mvc.repository.SlideRepository;
import spring.mvc.service.user.InterHomeService;

@Controller
public class HomeController {

	@Autowired
	private InterHomeService interHomeService;

	@RequestMapping(value = { "/", "trang-chu" }, method = RequestMethod.GET)
	public ModelAndView Home() {
		ModelAndView modelAndView = new ModelAndView("/web/welcome");
		Until.products = interHomeService.getDataProducts();
		Until.flashsales = interHomeService.getDataFlashsales();
		modelAndView.addObject("sliders", interHomeService.getDataSliders());
		modelAndView.addObject("config_webs", interHomeService.getDataConfigWebs());
		modelAndView.addObject("flashsales", interHomeService.getDataFlashsales());
		modelAndView.addObject("productPopulars", interHomeService.getDataProductPopulars());
		modelAndView.addObject("coupons", interHomeService.getDataCoupons());
		if(Until.productReviewList.size() > 0) {
			if(Until.productReviewList.get(0).getProduct_name() == "") {
				Until.productReviewList = new ArrayList<>();
			}			
		}
		return modelAndView;
	}

	@PostMapping("/watch-product")
	@ResponseBody
	public String watchProduct(@RequestParam("product_id") int data) {
		Product product = new Product();
		Flashsale flashsale = new Flashsale();
		List<ProductType> list = new ArrayList<>();
		if (Until.productTypes.size() == 0) {
			list = interHomeService.getDataPeoProductTypes();			
		}else {
			list = Until.productTypes;
		}
		for (Product item : Until.products) {
			if (item.getProduct_id() == data) {
				product = item;
				break;
			}
		}

		for (Flashsale item : Until.flashsales) {
			if (item.getProduct().getProduct_id() == data) {
				flashsale = item;
				break;
			}
		}
		StringBuilder stringBuilder = new StringBuilder();
		for (ProductType productType : list) {
			stringBuilder.append("<div class=\"size-main\">"
					+ "<label class=\"size-detail\" for=\"$size->product_type_id\"><i class=\"fas fa-coffee\"></i> "
					+ productType.getProduct_type_name() + " + "
					+ Until.convertNumber(productType.getProduct_type_price()) + "$</label> <input id=\""
					+ productType.getProduct_type_id() + "\" value=\"" + productType.getProduct_type_id()
					+ "\" type=\"radio\" name=\"size\" hidden/></div>");
		}

		String priceString = "";
		if (flashsale.getFlashsale_price_sale() != 0) {
			product = flashsale.getProduct();
			priceString = Until.convertNumber(flashsale.getFlashsale_price_sale())
					+ "đ / <span style=\\\"text-decoration: line-through;\\\">"
					+ Until.convertNumber(product.getProduct_price()) + "đ</span>";
		} else {
			priceString = Until.convertNumber(product.getProduct_price()) + "đ";
		}

		String outString = "<div class=\"row\">" + "      <div class=\"col-lg-5 col-sm-12 img\">"
				+ "          <img class=\"flashsalehotel_img\" width=\"284px\" height=\"160px\" style=\"object-fit: cover;\""
				+ "          src=\"assets/web/img/product/" + product.getProduct_image() + "\" alt=\"\">"
				+ "      </div>\r\n" + "      <div class=\"col-lg-7 col-sm-12\">\r\n"
				+ "      <input type=\"text\" id=\"product_id\" name=\"product_id\" hidden value=\"' . $product_id . '\">"
				+ "            <div class=\"product_name\">" + "            <h2>" + product.getProduct_name() + "</h2>"
				+ "               </div>" + "          <div class=\"flashsalehotel_place\">\r\n"
				+ "              <div  class=\"category_name\">\r\n"
				+ "                  <i class=\"fa-solid fa-certificate\"></i>\r\n" + product.getCategory_name()
				+ "         </div><br>           <div class=\"price\">" + priceString
				+ "           </div> </div><hr width=\"100%\">"
				+ "          <div class=\"product-size-box\"> <div class=\"product-size\">" + stringBuilder + " </div>"
				+ "          </div>" + "          <hr>   <div class=\"row quantity_row\">"
				+ "              <div class=\"quantity-class\">\r\n"
				+ "                  <span>Quantity: </span> <input id=\"quantity\" type=\"number\" min=\"1\" max=\"100\" value=\"1\">\r\n"
				+ "              </div>\r\n" + "          </div>\r\n" + "      </div>\r\n" + "    </div>";

		return outString;
	}

}
