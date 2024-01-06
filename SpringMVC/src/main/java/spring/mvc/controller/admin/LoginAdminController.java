package spring.mvc.controller.admin;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import spring.mvc.Until.Until;

@Controller
public class LoginAdminController {
	@Autowired
	private AuthenticationManager authenticationManager;

	@RequestMapping("/auth/admin-login")
	public ModelAndView viewLogin(@RequestParam(value = "error", required = false) String error) {
        ModelAndView mav = new ModelAndView("/layout/login-admin");
        if (error != null) {
            mav.addObject("error", "Invalid email or password");
        }
        return mav;
    }

	@PostMapping("/login-admin") // Xử lý yêu cầu POST đến /login
	public String login(@RequestParam("adminEmail") String email, @RequestParam("adminPassword") String password,
			RedirectAttributes attributes, HttpServletRequest request) {
		System.out.println("Xác thực 1");
		try {
			String pasString = Until.convertMD5(password);
			// Xác thực người dùng
			Authentication authentication = authenticationManager
					.authenticate(new UsernamePasswordAuthenticationToken(email, pasString));
			System.out.println("Xác thực 1");
			
			SecurityContextHolder.getContext().setAuthentication(authentication);
			System.out.println("Xác thực 2");
			// Chuyển hướng sau khi đăng nhập thành công
			return "redirect:/admin/home";
		} catch (AuthenticationException e) {
			System.out.println(e.getMessage());
			// Xử lý khi xác thực thất bại
			attributes.addFlashAttribute("error", "Invalid email or password huhu");
			return "redirect:/auth/admin-login?error=true";
		}
	}
	
	@GetMapping("/logout")
    public String logout(HttpServletRequest request, Authentication authentication) {
        if (authentication != null) {
            SecurityContextHolder.clearContext(); // Xóa thông tin xác thực hiện tại
            request.getSession().invalidate(); // Hủy phiên làm việc

            // Thực hiện các xử lý khác khi logout (nếu cần)

            return "redirect:/auth/admin-login"; // Chuyển hướng về trang login với thông báo logout
        }

        return "redirect:/auth/admin-login"; // Hoặc chuyển hướng đến trang khác nếu không có phiên làm việc
    }
	
	@GetMapping("/denied")
	public ModelAndView view403() {
		return new ModelAndView("/layout/access-denied");
	}
}
