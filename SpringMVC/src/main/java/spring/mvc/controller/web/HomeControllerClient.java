package spring.mvc.controller.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import spring.mvc.Until.Until;
import spring.mvc.entity.CartEntity;
import spring.mvc.entity.CustomerJPA;
import spring.mvc.entity.ProductJPA;
import spring.mvc.entity.ProductTypeJPA;
import spring.mvc.model.Flashsale;
import spring.mvc.model.Product;
import spring.mvc.model.ProductType;
import spring.mvc.repository.SlideRepository;
import spring.mvc.service.user.HomeService;
import spring.mvc.service.user.LoginAndResgiterService;

@Controller
public class HomeControllerClient {

	@Autowired
	private HomeService interHomeService;
	@Autowired
	private LoginAndResgiterService loginAndResgiterService;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public String login(HttpSession session, @RequestParam("customerEmail") String customerEmail,
			@RequestParam("customerPassword") String customerPass) {
		CustomerJPA customerJPA = loginAndResgiterService.findCustomerJPALogin(customerEmail, customerPass);
		if (customerJPA != null) {
			session.setAttribute("customer", customerJPA);
			session.setMaxInactiveInterval(60 * 60);
			return "true";
		} else {
			return "false";
		}
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	@ResponseBody
	public String register(@RequestParam("customerName") String customerName,
			@RequestParam("customerPhone") String customerPhone, @RequestParam("customerEmail") String customerEmail,
			@RequestParam("customerPassword") String customerPassword,
			@RequestParam("customerPasswordConfirm") String customerPassword1) {
		if (!customerPassword.equals(customerPassword1)) {
			return "confirm";
		} else {
			CustomerJPA customerJPA = loginAndResgiterService.findCustomerExit(customerEmail);
			if (customerJPA != null) {
				return "trung";
			} else {
				System.out.println("123");
				CustomerJPA customerJPA2 = new CustomerJPA();
				customerJPA2.setCustomerName(customerName);
				customerJPA2.setCustomerEmail(customerEmail);
				customerJPA2.setCustomerPhone(customerPhone);
				customerJPA2.setCustomerPassword(customerPassword1);
				customerJPA2.setCustomerStatus(1);
				customerJPA2.setOrderBoom("0");
				customerJPA2.setTotalOrder(0);
				loginAndResgiterService.registerCustomer(customerJPA2);
				return "success";
			}
		}
	}

	@RequestMapping(value = "/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("customer");
		return "redirect:/";
	}

	@RequestMapping(value = { "/", "trang-chu" }, method = RequestMethod.GET)
	public ModelAndView Home(HttpSession session) {
		ModelAndView modelAndView = new ModelAndView("/web/welcome");
		Until.products = interHomeService.getDataProducts();
		Until.flashsales = interHomeService.getDataFlashsales();
		modelAndView.addObject("sliders", interHomeService.getDataSliders());
		modelAndView.addObject("config_webs", interHomeService.getDataConfigWebs());
		modelAndView.addObject("flashsales", interHomeService.getDataFlashsales());
		modelAndView.addObject("productPopulars", interHomeService.getDataProductPopulars());
		modelAndView.addObject("coupons", interHomeService.getDataCoupons());
		if (Until.productReviewList.size() > 0) {
			if (Until.productReviewList.get(0).getProductName() == "") {
				Until.productReviewList = new ArrayList<>();
			}
		}
		List<CartEntity> listCarts = (List<CartEntity>) session.getAttribute("cart");
		// System.out.println("Cart: " + listCarts.size());
		modelAndView.addObject("cart", listCarts);
		return modelAndView;
	}

	@GetMapping(value = "/load-price-product-type", produces = "application/x-www-form-urlencoded;charset=UTF-8")
	@ResponseBody
	public String editPriceInType(@RequestParam("productId") Long productId,
			@RequestParam("productTypeId") Long productTypeId) {
		ProductJPA product = interHomeService.getProductById(productId);
		ProductTypeJPA productType = interHomeService.getProductTypeJPA(productTypeId);
		String string = "";
		if (product.getFlashsaleStatus() == 1) {
			string = Until
					.convertNumber(product.getFlashsale().getFlashsalePriceSale() + productType.getProductTypePrice())
					+ " đ / " + "<span style=\"text-decoration: line-through;\">"
					+ Until.convertNumber(product.getProductPrice() + productType.getProductTypePrice()) + "đ</span>";
		} else {
			string = Until.convertNumber(product.getProductPrice() + productType.getProductTypePrice()) + " đ";
		}
		return string;
	}

	@GetMapping(value = "/save-cart")
	@ResponseBody
	public String addCart(@RequestParam("productId") Long productId, @RequestParam("productTypeId") Long productTypeId,
			@RequestParam("productQuantity") int productQuantity, HttpSession session) {
		ProductJPA product = interHomeService.getProductById(productId);
		session.setMaxInactiveInterval(60 * 60);
		ProductTypeJPA productType = interHomeService.getProductTypeJPA(productTypeId);
		CustomerJPA customerJPA = (CustomerJPA) session.getAttribute("customer");
		if (customerJPA == null) {
			return "customer";
		}
		List<CartEntity> listCarts = (List<CartEntity>) session.getAttribute("cart");
		if (listCarts == null) {
			listCarts = new ArrayList<CartEntity>();
			double price = 0;
			if(product.getFlashsaleStatus() == 1) {
				price = product.getFlashsale().getFlashsalePriceSale();
			}else {
				price = product.getProductPrice();
			}
			CartEntity cartEntity = new CartEntity(customerJPA.getCustomerId(), productId, product.getProductName(),
					product.getProductImage(), price + productType.getProductTypePrice(),
					productQuantity, productTypeId);
			listCarts.add(cartEntity);
			//System.out.println("hihi");
			session.setAttribute("cart", listCarts);
		} else {
			for (CartEntity cartEntity : listCarts) {
				if (cartEntity.getProductTypeId() == productTypeId && cartEntity.getProductId() == productId) {
					//System.out.println("huhu");
					cartEntity.setProductQuantity(cartEntity.getProductQuantity() + productQuantity);
					session.setAttribute("cart", listCarts);
					return "Thành công";
				}
			}
			double price = 0;
			if(product.getFlashsaleStatus() == 1) {
				price = product.getFlashsale().getFlashsalePriceSale();
			}else {
				price = product.getProductPrice();
			}
			CartEntity cartEntity = new CartEntity(customerJPA.getCustomerId(), productId, product.getProductName(),
					product.getProductImage(), price + productType.getProductTypePrice(),
					productQuantity, productTypeId);
			listCarts.add(cartEntity);
			//System.out.println("hhhh");
			session.setAttribute("cart", listCarts);
		}
		return "Thành công";
	}

	@PostMapping(value = "/watch-product", produces = "application/x-www-form-urlencoded;charset=UTF-8")
	@ResponseBody
	public String watchProduct(@RequestParam("product_id") Long data) {
		ProductJPA product = interHomeService.getProductById(data);
		List<ProductTypeJPA> list = new ArrayList<>();
		if (Until.productTypes.size() == 0) {
			list = interHomeService.getDataPeoProductTypes();
		} else {
			list = Until.productTypes;
		}
		StringBuilder stringBuilder = new StringBuilder();
		for (ProductTypeJPA productType : list) {
			stringBuilder.append("<div class=\"size-main\">" + "<label class=\"size-detail\" for=\""
					+ productType.getProductTypeId() + "\"><i class=\"fas fa-coffee\"></i> "
					+ productType.getProductTypeName() + " + " + Until.convertNumber(productType.getProductTypePrice())
					+ "đ</label> <input id=\"" + productType.getProductTypeId() + "\" value=\""
					+ productType.getProductTypeId() + "\" type=\"radio\" name=\"size\" hidden/></div>");
		}

		String priceString = "";
		if (product.getFlashsaleStatus() != 0) {
			priceString = Until.convertNumber(product.getFlashsale().getFlashsalePriceSale())
					+ "đ / <span style=\"text-decoration: line-through;\">"
					+ Until.convertNumber(product.getProductPrice()) + "đ</span>";
		} else {
			priceString = Until.convertNumber(product.getProductPrice()) + "đ";
		}
		String outString = "<div class=\"row\">" + "      <div class=\"col-lg-5 col-sm-12 img\">"
				+ "          <img class=\"flashsalehotel_img\" width=\"284px\" height=\"160px\" style=\"object-fit: cover;\""
				+ "          src=\"assets/web/img/product/" + product.getProductImage() + "\" alt=\"\">"
				+ "      </div>\r\n" + "      <div class=\"col-lg-7 col-sm-12\">\r\n"
				+ "      <input type=\"text\" id=\"product_id\" name=\"product_id\" hidden value=\""
				+ product.getProductId() + "\">" + "            <div class=\"product_name\">" + "            <h2>"
				+ product.getProductName() + "</h2>" + "               </div>"
				+ "          <div class=\"flashsalehotel_place\">\r\n"
				+ "              <div  class=\"category_name\">\r\n"
				+ "                  <i class=\"fa-solid fa-certificate\"></i>\r\n"
				+ product.getCategory().getCategoryName() + "         </div><br>           <div class=\"price\">"
				+ priceString + "           </div> </div><hr width=\"100%\">"
				+ "          <div class=\"product-size-box\"> <div class=\"product-size\">" + stringBuilder + " </div>"
				+ "          </div>" + "          <hr>   <div class=\"row quantity_row\">"
				+ "              <div class=\"quantity-class\">\r\n"
				+ "                  <span>Quantity: </span> <input id=\"quantity\" type=\"number\" min=\"1\" max=\"100\" value=\"1\">\r\n"
				+ "              </div>\r\n" + "          </div>\r\n" + "      </div>\r\n" + "    </div>";

		return outString;
	}

}
