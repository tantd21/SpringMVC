package spring.mvc.controller.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import spring.mvc.Until.Until;
import spring.mvc.model.Product;

@Controller

public class ShopController {

	@RequestMapping(value = "/cua-hang")
	public ModelAndView shopProduct() {
		ModelAndView mav = new ModelAndView("/web/shop_drink");
		List<Product> products = new ArrayList<>();
		products = Until.products;
		mav.addObject("products", products);
		return mav;
	}
	@RequestMapping(value = "/cua-hang/load-danh-sach-san-pham")
	@ResponseBody
	public String getListProductBuilder() {
		String string = new String();
		string = print_danh_sach_san_pham(Until.products).toString();
		return string.toString();
	}

	public StringBuilder print_danh_sach_san_pham(List<Product> datas){
		StringBuilder outputString = new StringBuilder();
        for(Product product: datas){
            outputString.append("<div class=\"col-lg-4 col-md-6 col-sm-6\">"
            		+ "<div class=\"flashsalehotel_boxcontent item\">"
                    + "<div class=\"flashsalehotel_boxcontent_img_text\">"
                    + "<div class=\"flashsalehotel_img-box\">"
                    + "<a href=\"/SpringMVC/cua-hang/san-pham/san-pham-chi-tiet?product_id=" + product.getProduct_id() + "\" class=\"flashsalehotel_boxcontent_hover\">"
                    + "<img class=\"flashsalehotel_img\" width=\"284px\" height=\"160px\" style=\"object-fit: cover;\""
            		+ "src=\"assets/web/img/product/" + product.getProduct_image() + "\" alt=\"\">"
                    + "</a> </div>"
                    + "<div class=\"flashsalehotel_text\">"
                    + "<div class=\"flashsalehotel_text-title\">"
                    +  product.getProduct_name()
                    + "</div>"
                    + "<div class=\"flashsalehotel_place\">"
                    + "<div>"
                    + "     <i class=\"fa-solid fa-certificate\"></i>"
                    + product.getCategory_name()
                    + "</div></div>");
                            if(product.getFlashsale_status() == 1){
                                outputString.append("<div class=\"flashsalehotel_text-time\">Giảm giá</div>");
                            }else{
                            	outputString.append(
                            			"<div class=\"flashsalehotel_text-time\">\r\n"
                            			+ "Sản phẩm"
                            			+ "</div>'");
                            }
                            outputString.append("<div class=\"flashsalehotel_text-box-price\">");
                                if(product.getFlashsale_status() == 0){
                                	outputString.append(" <div class=\"flashsalehotel_text-box-price-two\">"
                                			+ "<span>" + Until.convertNumber(product.getProduct_price()) + " đ</span>"
                                			+ "</div>");                                   ;
                                }else{
                                	outputString.append("<div style=\"display: flex; justify-content:right\">\r\n"
                                			+ " <div class=\"flashsalehotel_text-box-price-two\">\r\n"
                                			+ " <span>" + Until.convertNumber(product.getFlashsale().getFlashsale_price_sale()) + "đ</span>\r\n"
                                			+ " </div>\r\n"
                                			+ " <div class=\"flashsalehotel_text-box-price-one\">\r\n"
                                			+ " <span>/</span>\r\n"
                                			+ " </div>\r\n"
                                			+ " <div class=\"flashsalehotel_text-box-price-one\">\r\n"
                                			+ " <span style=\"text-decoration: line-through\">" + Until.convertNumber(product.getProduct_price()) + "đ</span>\r\n"
                                			+ " </div>\r\n"
                                			+ " </div>");
                                }
                                outputString.append("<div class=\"flashsalehotel_text-box-price-three bordernhay\">\r\n"
                                		+ "<div style=\"margin-left: 8px;\"\r\n"
                                		+ "    class=\"flashsalehotel_text-box-price-three-l chunhay\">\r\n"
                                		+ "  <div class=\"cart-hover\">\r\n"
                                		+ " <i class=\"fa-solid fa-heart\"></i>\r\n"
                                		+ "<span style=\"font-size: 14px;\">Yêu Thích</span>\r\n"
                                		+ "</div>\r\n"
                                		+ "</div>\r\n"
                                		+ "<div class=\"flashsalehotel_text-box-price-three-r chunhay\">\r\n"
                                		+ "<div class=\"cart-hover\" data-toggle=\"modal\" data-target=\"#shopping\" data-product_id=\"'.$data->product_id.'\">\r\n"
                                		+ "<i class=\"fa-solid fa-cart-shopping\"></i>\r\n"
                                		+ "<span style=\"font-size: 14px;\">Đặt Hàng</span>\r\n"
                                		+ "</div>\r\n"
                                		+ "</div>\r\n"
                                		+ "</div>\r\n"
                                		+ "</div>\r\n"
                                		+ "</div>\r\n"
                                		+ "</div>\r\n"
                                		+ "</div>\r\n"
                                		+ "\r\n"
                                		+ "</div>");
        }
        
        return outputString;
    }

}
