package spring.mvc.controller.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.aspectj.weaver.patterns.IfPointcut.IfFalsePointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import spring.mvc.Until.Until;
import spring.mvc.entity.CartEntity;
import spring.mvc.entity.CityJPA;
import spring.mvc.entity.CouponJPA;
import spring.mvc.entity.FeeJPA;
import spring.mvc.entity.OrderJPA;
import spring.mvc.entity.ProductJPA;
import spring.mvc.entity.ProductTypeJPA;
import spring.mvc.service.admin.CouponJPAService;
import spring.mvc.service.admin.ImpAddressService;
import spring.mvc.service.admin.ImpCouponJPAService;
import spring.mvc.service.admin.ImpFeeShipService;
import spring.mvc.service.admin.ImpProductService;
import spring.mvc.service.admin.ImpProductTypeJPAService;

@Controller
@RequestMapping("/gio-hang")
public class CartController {
	@Autowired
	ImpProductTypeJPAService productTypeJPAService;
	@Autowired
	ImpProductService productService;
	@Autowired
	ImpAddressService impAddressService;
	@Autowired
	ImpCouponJPAService impCouponJPAService;
	@Autowired
	ImpFeeShipService impFeeShipService;

	@RequestMapping("/")
	public ModelAndView viewCart() {
		ModelAndView mav = new ModelAndView("/web/gio_hang");
		List<CityJPA> cityJPAs = impAddressService.getCityJPAs();
		mav.addObject("cities", cityJPAs);
		return mav;
	}

	@RequestMapping(value = "/load-cart", produces = "application/x-www-form-urlencoded;charset=UTF-8")
	@ResponseBody
	public String loadCart(HttpSession session) {
		List<CartEntity> cartEntities = (List<CartEntity>) session.getAttribute("cart");
		return printCart(cartEntities);
	}

	@GetMapping("/delete-cart")
	@ResponseBody
	public String deleteProductCart(HttpSession session, @RequestParam("index") int index) {
		List<CartEntity> list = (List<CartEntity>) session.getAttribute("cart");
		list.remove(index);
		session.setAttribute("cart", list);
		return "Thành công";
	}
	
	@GetMapping(value = "/delete-coupon")
	@ResponseBody
	public String deleteCoupon(HttpSession session) {
		session.removeAttribute("coupon");
		return "success";
	}

	@GetMapping("/check-coupon")
	@ResponseBody
	public String checkCoupon(@RequestParam("couponName") String coupon, HttpSession httpSession) {
		CouponJPA couponJPA = impCouponJPAService.checkCoupon(coupon);
		if (coupon != null) {
			httpSession.setAttribute("coupon", couponJPA);
			httpSession.setMaxInactiveInterval(60 *60);
			return "success";
		} else {
			return "error";
		}
	}
	
	@PostMapping(value = "/caculate-fee")
	@ResponseBody
	public String caculateFee(@RequestParam("maTp") Long matp, @RequestParam("maQh") Long maQh, @RequestParam("maXp") Long maXp, HttpSession session) {
		FeeJPA feeJPA = impFeeShipService.getFeeShipJPAByIdXp(maXp);
		if(feeJPA != null) {
			session.setAttribute("fee", feeJPA);
		}else {
			FeeJPA feeJPA2 = new FeeJPA();
			feeJPA2.setCity(impAddressService.getCityJPAById(matp));
			feeJPA2.setDistrict(impAddressService.getDistrictJPAById(maQh));
			feeJPA2.setWard(impAddressService.getWardJPAById(maXp));
			feeJPA2.setFeeFeeship(30000);
			session.setAttribute("fee", feeJPA2);
		}
		return "success";
	}
	
	@RequestMapping(value = "/load-payment", produces = "application/x-www-form-urlencoded;charset=UTF-8")
	@ResponseBody
	public String loadPayment(HttpSession session) {
		StringBuilder stringBuilder = new StringBuilder();
		double priceTotal = 0;
		List<CartEntity> listsCartEntities = (List<CartEntity>) session.getAttribute("cart");
		if (listsCartEntities != null) {
			for(CartEntity cartEntity: listsCartEntities) {
				priceTotal += cartEntity.getProductPrice() * cartEntity.getProductQuantity();
			}			
		}
		CouponJPA couponJPA = (CouponJPA) session.getAttribute("coupon");
		double priceForSale = 0;
		String stringCoupon = "";
		double priceSale = 0;
		if(couponJPA != null) {
			if(couponJPA.getCouponCondition() == 1) {
				priceSale = couponJPA.getCouponPriceSale() * priceTotal / 100;
				priceForSale = priceTotal - priceSale;
				stringCoupon = "<td> -" + couponJPA.getCouponPriceSale() + "% </td>";
			}else {
				priceSale = couponJPA.getCouponPriceSale();
				priceForSale = priceTotal - priceSale;
				stringCoupon = "<td> -" + Until.convertNumber(couponJPA.getCouponPriceSale()) + "đ </td>";
			}
		}else {
			priceForSale = priceTotal;
			stringCoupon = "<td>Chưa Áp Dụng</td>";
		}
		FeeJPA feeJPA = (FeeJPA) session.getAttribute("fee");
		String stringFee = "";
		double feeDouble = 0;
		if(feeJPA != null) {
			feeDouble = feeJPA.getFeeFeeship();
			stringFee = "<td class=\"fee_feeship\"> + " + Until.convertNumber(feeJPA.getFeeFeeship()) + "đ</td>";
		}else {
			stringFee = "<td class=\"fee_feeship\">Xác nhận địa chỉ</td>";
		}
		String couponName = "không có";
		if(couponJPA != null) {
			couponName = couponJPA.getCouponNameCode();
		}
		OrderJPA order = new OrderJPA();
		order.setProductFee(feeDouble);
		order.setCouponSale(priceSale);
		order.setProductCoupon(couponName);
		order.setTotalPrice(priceTotal);
		session.setAttribute("order", order);
		session.setMaxInactiveInterval(60 * 60);
		stringBuilder.append("<tr>"
				+ "<th>Tổng tiền</th>"
				+ "<td>" + Until.convertNumber(priceTotal) + "đ</td>"
				+ "</tr> <tr> <th>Phiếu giảm giá</th>"
				+ stringCoupon + "</tr>"
				+ "<tr>"
				+ "<th>Phí vận chuyển</th>"
				+ stringFee + "</tr> \r\n"
				+ "<tr>"
				+ "<th>Tổng cộng </th>"
				+ "<td>" + Until.convertNumber(priceForSale + feeDouble) + "đ "+ "<input type=\"text\" id=\"priceTotal\" name=\"priceTotal\" hidden value=\"" + priceTotal + "\">"+"</td>\r\n"
				+ "</tr>"
				);
		return stringBuilder.toString();
	}
	@GetMapping(value = "/load-coupon", produces = "application/x-www-form-urlencoded;charset=UTF-8")
	@ResponseBody
	public String loadCoupon(HttpSession session) {
		StringBuilder stringBuilder = new StringBuilder();
		CouponJPA couponJPA = (CouponJPA) session.getAttribute("coupon");
		if (couponJPA != null) {
			if (couponJPA.getCouponCondition() == 1) {
				stringBuilder.append("<div class=\"coupon-apply\">" + couponJPA.getCouponName() + ": giảm giá "
						+ couponJPA.getCouponPriceSale() + " % <i class=\"fa-solid fa-circle-xmark\"></i>\r\n"
						+ "</div>");
			} else {
				stringBuilder.append("<div class=\"coupon-apply\">" + couponJPA.getCouponName() + ": giảm giá "
						+ Until.convertNumber(couponJPA.getCouponPriceSale())
						+ "đ <i class=\"fa-solid fa-circle-xmark\"></i></div>");
			}
		} else {
			stringBuilder.append("<div class=\"coupon-apply\" style=\"display:flex;justify-content:center;\">\r\n"
					+ "Chưa áp dụng mã giảm giá nào!</div>");
		}
		return stringBuilder.toString();
	}

	@PostMapping("/update-cart-quantity")
	@ResponseBody
	public String updateQuantityCart(HttpSession session, @RequestParam("index") int index,
			@RequestParam("quantity") int quantity) {
		List<CartEntity> list = (List<CartEntity>) session.getAttribute("cart");
		list.get(index).setProductQuantity(quantity);
		return "Thành công";
	}

	@GetMapping("/update-size-cart")
	@ResponseBody
	public String updateSizeCart(HttpSession session, @RequestParam("index") int index,
			@RequestParam("value") Long productTypeId, @RequestParam("productId") Long productId,
			@RequestParam("quantity") int quantity) {
		List<CartEntity> list = (List<CartEntity>) session.getAttribute("cart");
		for (CartEntity cartEntity : list) {
			if (cartEntity.getProductId() == productId && cartEntity.getProductTypeId() == productTypeId) {
				cartEntity.setProductQuantity(cartEntity.getProductQuantity() + quantity);
				list.remove(index);
				session.setAttribute("cart", list);
				return "Thành công";
			}
		}
		ProductJPA product = productService.findProductById(productId);
		double price = 0;
		ProductTypeJPA prodcType = productTypeJPAService.findProductTypeJPAById(productTypeId);
		if (product.getFlashsaleStatus() == 1) {
			price = product.getFlashsale().getFlashsalePriceSale() + prodcType.getProductTypePrice();
		} else {
			price = product.getProductPrice() + prodcType.getProductTypePrice();
		}
		list.get(index).setProductTypeId(productTypeId);
		list.get(index).setProductPrice(price);
		session.setAttribute("cart", list);
		return "Thành công";
	}

	public String printCart(List<CartEntity> list) {
		List<ProductTypeJPA> productTypeJPAs = productTypeJPAService.getAllProductTypeJPAs();
		StringBuilder stringBuilder = new StringBuilder();
		int i = 0;
		double priceTotal = 0;
		if (list != null) {
			for (CartEntity cartEntity : list) {
				stringBuilder.append("<tr>\r\n" + "<td width=\"180px\">"
						+ "<img src=\"/SpringMVC/assets/web/img/product/"
						+ cartEntity.getProductImage() + "\" alt=\"\" width=\"100px\" height=\"100px\"></td>\r\n"
						+ "<td style=\"text-align: left;font-size:18px;width:250px\">" + cartEntity.getProductName()
						+ "</td><td width=\"170px\">" + "<select name=\"\" id=\"type-product\" data-quantity=\""
						+ cartEntity.getProductQuantity() + "\" data-rowid=\"" + i + "\" data-product_id=\""
						+ cartEntity.getProductId() + "\">");
				for (ProductTypeJPA productType : productTypeJPAs) {
					if (productType.getProductTypeId() == cartEntity.getProductTypeId()) {
						stringBuilder.append("<option selected value=\"" + productType.getProductTypeId() + "\">"
								+ productType.getProductTypeName() + " + "
								+ Until.convertNumber(productType.getProductTypePrice()) + "đ</option>");
					} else {
						stringBuilder.append("<option value=\"" + productType.getProductTypeId() + "\">"
								+ productType.getProductTypeName() + " + "
								+ Until.convertNumber(productType.getProductTypePrice()) + "đ</option>");
					}
				}
				priceTotal = priceTotal + cartEntity.getProductPrice() * cartEntity.getProductQuantity();
				stringBuilder.append("</select>" + "</td>" + "<td width=\"170px\">"
						+ Until.convertNumber(cartEntity.getProductPrice()) + "đ</td>"
						+ "<td width=\"140px\"><input type=\"number\" value=\"" + cartEntity.getProductQuantity()
						+ "\" min=\"1\" name=\"quantity\" data-rowId=\"" + i
						+ "\" id=\"quantity\" class=\"changequantity\" width=\"20px\"></td>");
				stringBuilder.append("<td>"
						+ Until.convertNumber(cartEntity.getProductPrice() * cartEntity.getProductQuantity())
						+ "đ</td>\r\n"
						+ "<td class=\"deleted-btn\"><i class=\"fas fa-trash-alt btn-deleted\" data-rowId=\"" + i
						+ "\" data-toggle=\"modal\"\r\n" + "data-target=\"#Delete\" ></i></td>\r\n" + "</tr>");
				i++;
			}
		} else {
			stringBuilder.append("<tr>"
					+ "<td colspan=\"7\" style=\"\">Không có sản phẩm nào trong giỏ hàng. <a href=\"/SpringMVC/trang-chu\">Đi tới danh sách sản phẩm</a></td>\r\n"
					+ "</tr>");
		}
		stringBuilder.append("<tr class=\"table-foot\">\r\n" + "<td colspan=\"5\">Tổng tiền</td>\r\n"
				+ "<td colspan=\"2\">" + Until.convertNumber(priceTotal) + "đ</td>\r\n" + "</tr>");
		return stringBuilder.toString();
	}
}
