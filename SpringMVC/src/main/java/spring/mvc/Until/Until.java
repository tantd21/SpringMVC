package spring.mvc.Until;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.List;

import spring.mvc.entity.FlashsaleJPA;
import spring.mvc.entity.ProductJPA;
import spring.mvc.entity.ProductTypeJPA;
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
	
	public static String convertMD5(String password) {
		MessageDigest digest = null;
        try {
            digest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        // Chuyển chuỗi thành mảng bytes
        byte[] encodedhash = digest.digest(password.getBytes());

        // Chuyển mảng bytes thành chuỗi hex
        StringBuilder hexString = new StringBuilder(2 * encodedhash.length);
        for (byte b : encodedhash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        System.out.println("MD5 Hash: " + hexString.toString());
		return hexString.toString();
	}
	
	public static List<ProductJPA> products = new ArrayList<>();
	public static List<FlashsaleJPA> flashsales = new ArrayList<>();
	public static List<ProductJPA> productReviewList = new ArrayList<>();
	public static List<ProductTypeJPA> productTypes = new ArrayList<>();
}
