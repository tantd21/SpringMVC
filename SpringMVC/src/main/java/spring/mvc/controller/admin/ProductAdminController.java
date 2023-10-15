package spring.mvc.controller.admin;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.annotation.JsonTypeInfo.As;

import spring.mvc.Until.Until;
import spring.mvc.entity.CategoryJPA;
import spring.mvc.entity.GalleryProductJPA;
import spring.mvc.entity.ProductJPA;
import spring.mvc.model.Product;
import spring.mvc.service.admin.ImpCategoryJPAService;
import spring.mvc.service.admin.ImpProductService;
import spring.mvc.service.admin.ProductService;
import spring.mvc.service.user.DetailProductService;

@Controller
@RequestMapping("/admin/products")
public class ProductAdminController {
	@Autowired
	ImpProductService productService;
	@Autowired
	ImpCategoryJPAService impCategoryJPAService;

	@RequestMapping(value = { "" })
	public String viewProductManager(Model model, @RequestParam("p") Optional<Integer> p) {
		PageRequest pageRequest = new PageRequest(p.orElse(0), 6);
		Pageable pageable = pageRequest;
		Page<ProductJPA> page = productService.getAllProductJPAs(pageable);
//		List<ProductJPA> productJPAs =  productService.getAllProductJPAs();
		List<CategoryJPA> categoryJPAs = impCategoryJPAService.getAllCategoryJPAs();
		for (CategoryJPA categoryJPA : categoryJPAs) {
			System.out.println(categoryJPA.getProducts().size());
		}
		model.addAttribute("categorys", categoryJPAs);
		model.addAttribute("products", page);
		return "/admin/products/list_products";
	}

	@RequestMapping(value = "/deleted-product", method = RequestMethod.DELETE)
	@ResponseBody
	public String deleteProduct(@RequestParam("delete_id") int deleted_id, @RequestParam("photo") String photo) {

		String imageString = "E:\\eclipse-workspace-1\\SpringMVC\\src\\main\\webapp\\assets\\web\\img\\product\\"
				+ photo;
		File file = new File(imageString);
		productService.deleteProduct((long) deleted_id);
		if (file.exists()) {
			if (file.delete()) {
				System.out.println("File đã xóa khỏi thư mục!");
			} else {
				System.out.println("File chưa xóa!");
			}
		} else {
			System.out.println("File không tồn tại!");
		}
		return "Thành Công";
	}

	@RequestMapping(value = "/add-product")
	public ModelAndView viewAddProduct() {
		ModelAndView mav = new ModelAndView("/admin/products/add_product");
		mav.addObject("categorys", impCategoryJPAService.getAllCategoryJPAs());
		return mav;
	}

	@RequestMapping(value = "/product-detail")
	public ModelAndView viewDetailProduct(@RequestParam("productId") Long proLong) {
		ModelAndView mav = new ModelAndView("/admin/products/product_detail");
		ProductJPA productJPA = productService.findProductById(proLong);
//		List<GalleryProductJPA> galleryProductJPAs = productJPA.getGalleryProducts();
//		System.out.println(galleryProductJPAs.size());
		mav.addObject("product", productService.findProductById(proLong));
		return mav;
	}

	@RequestMapping("/edit-product")
	public ModelAndView viewEditProduct(@RequestParam("productId") int productId) {
		ModelAndView mav = new ModelAndView("/admin/products/edit_product");
		mav.addObject("categorys", impCategoryJPAService.getAllCategoryJPAs());
		mav.addObject("product", productService.findProductById((long) productId));
		return mav;
	}

	@PostMapping("/save-product")
	public String saveProduct(@ModelAttribute("product") ProductJPA productJPA,
			@RequestParam("image") MultipartFile file, @RequestParam("categoryId") Long cateLong) {
		if (productService.saveProduct(productJPA, file, cateLong)) {
			return "redirect:/admin/products";
		} else {
			return "redirect:back";
		}
	}

	@PostMapping("/update-product")
	public String updateProduct(@ModelAttribute("product") ProductJPA productJPA,
			@RequestParam("image") MultipartFile file, @RequestParam("photo") String photo,
			@RequestParam("categoryId") Long catLong) {
		if (productService.updateProduct(productJPA, file, photo, catLong)) {
			return "redirect:/admin/products";
		}
		return "redirect:back";
	}

	@RequestMapping("/search-products")
	@ResponseBody
	public String searchProducts(@RequestParam("p") Optional<Integer> p, @RequestParam("text") String text) {
		List<ProductJPA> productJPAs = productService.searchProductJPAs(text, p);
		return printProducts(productJPAs);
	}

	@RequestMapping(value = "/load-products", method = RequestMethod.GET)
	@ResponseBody
	public String loadAllProduct(@RequestParam("p") Optional<Integer> p) {
		PageRequest pageRequest = new PageRequest(p.orElse(0), 6);
		Pageable pageable = pageRequest;
		Page<ProductJPA> page = productService.getAllProductJPAs(pageable);
		return printProducts(page.getContent());
	}

	@PostMapping(value = "/save-gallery")
	public String saveGalleryProduct(@RequestParam("image") List<MultipartFile> files,
			@RequestParam("productId") Long productId) {
		productService.saveGallerys(files, productId);
		return "redirect:/admin/products/product-detail?productId=" + productId;
	}
	
	@DeleteMapping(value = "/delete-gallery")
	@ResponseBody
	public String deleteGallery(@RequestParam("delete-id") Long deleteId, @RequestParam("image") String imageString) {
		if(productService.deleteGallery(deleteId, imageString)) {
			return "success";			
		}else {
			return "error";
		}
	}
	
	@PostMapping(value = "/update-gallery-content")
	@ResponseBody
	public String dupdateGalleryContent(@RequestParam("galleryId") Long deleteId, @RequestParam("content") String imageString, @RequestParam("type") int type) {
		if(productService.updateGalleryContent(deleteId, imageString, type)) {
			return "success";			
		}else {
			return "error";
		}
	}

	public String printProducts(List<ProductJPA> productJPAs) {
		StringBuilder stringBuilder = new StringBuilder();
		if (productJPAs.size() > 0) {

			for (ProductJPA productJPA : productJPAs) {
				stringBuilder.append("<tr><td>" + productJPA.getProductName() + "</td><td>"
						+ productJPA.getCategory().getCategoryName() + "</td>\r\n" + "<td>"
						+ Until.convertNumber(productJPA.getProductPrice()) + "đ</td><td><img\r\n"
						+ "src=\"/SpringMVC/assets/web/img/product/" + productJPA.getProductImage() + "\" /></td><td>");
				if (productJPA.getProductStatus() == 1) {
					stringBuilder.append("<i style=\"color: rgb(52, 211, 52); font-size: 30px\"\r\n"
							+ "class=\"mdi mdi-toggle-switch btn-un-active\"\r\n" + "data-product_id=\""
							+ productJPA.getProductId() + "\" data-status=\"0\"></i>");
				} else {
					stringBuilder.append("<i style=\"color: rgb(196, 203, 196); font-size: 30px\"\r\n"
							+ "class=\"mdi mdi-toggle-switch-off btn-un-active\"\r\n" + "data-product_id=\""
							+ productJPA.getProductId() + "\" data-status=\"1\"></i>");
				}

				stringBuilder.append("<td>\r\n" + "<button type=\"button\"\r\n"
						+ "class=\"btn btn-inverse-info btn-icon btn-restore\"\r\n" + "data-restore_id=\""
						+ productJPA.getProductId() + "\"\r\n" + "data-delete_id=\"-1\">\r\n"
						+ "<i class=\"mdi mdi-keyboard-return\"></i>\r\n" + "</button>\r\n <button type=\"button\"\r\n"
						+ "class=\"btn btn-inverse-success btn-icon btn-delete-force\"\r\n"
						+ "data-delete_id=\"${ product.productId }\"\r\n"
						+ "data-photo=\"${ product.productImage }\" data-restore_id=\"0\">\r\n"
						+ "<i class=\"mdi mdi-delete-forever\"></i>\r\n" + "</button>" + "<button type=\"button\"\r\n"
						+ "class=\"btn btn-inverse-danger btn-icon btn-delete-force\"\r\n" + "data-delete_id=\""
						+ productJPA.getProductId() + "\"\r\n" + "data-restore_id=\"0\">\r\n"
						+ "<i class=\"mdi mdi-delete-forever\"></i>\r\n" + "</button>\r\n" + "</td>\r\n" + "</tr>");
			}
		} else {
			stringBuilder.append("<tr>"
					+ "            <th colspan=\"7\" style=\"text-align: center;\">Không có sản phẩm này</a></th>\r\n"
					+ "        </tr>");
		}
		return stringBuilder.toString();
	}

}
