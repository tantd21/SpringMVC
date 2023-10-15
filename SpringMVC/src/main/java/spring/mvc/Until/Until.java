package spring.mvc.Until;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.List;

import spring.mvc.model.Flashsale;
import spring.mvc.model.Product;
import spring.mvc.model.ProductType;

public class Until {
	public static String convertNumber(double d) {
		
        // Tạo một đối tượng DecimalFormat với mẫu số lượng
		 DecimalFormatSymbols symbols = new DecimalFormatSymbols();
	        symbols.setDecimalSeparator('.');
	        symbols.setGroupingSeparator('.');
		
        DecimalFormat decimalFormat = new DecimalFormat("#,###.###", symbols);
        // Sử dụng đối tượng DecimalFormat để chuyển đổi số thành chuỗi đã định dạng
        String formattedNumber = decimalFormat.format(d);
        return formattedNumber;
	}
	
	public static List<Product> products = new ArrayList<>();
	public static List<Flashsale> flashsales = new ArrayList<>();
	public static List<Product> productReviewList = new ArrayList<>();
	public static List<ProductType> productTypes = new ArrayList<>();
}
