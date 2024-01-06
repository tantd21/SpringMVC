package spring.mvc.config;

import org.aspectj.weaver.ast.And;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.InMemoryTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import spring.mvc.service.admin.ImpAdminService;

@Configuration
@EnableWebSecurity
@EnableTransactionManagement
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private ImpAdminService adminService;

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	@Bean // Chú ý đánh dấu là @Bean để Spring có thể quản lý Bean này
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(adminService);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		System.out.println("Huhuhu");
		http.csrf().disable(); // CSRF ( Cross Site Request Forgery) là kĩ thuật tấn công bằng cách sử dụng
								// quyền chứng thực của người sử dụng đối với 1 website khác
//        http.authorizeRequests().antMatchers("/userInfo").access("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')");

		http.authorizeRequests().antMatchers("/admin").access("hasAnyRole('admin', 'manager')");
		http.authorizeRequests().antMatchers("/admin/**").access("hasAnyRole('admin', 'manager')");
		http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/denied");

		http.authorizeRequests().and().formLogin().loginPage("/auth/admin-login").defaultSuccessUrl("/admin/home")
				.usernameParameter("adminEmail").passwordParameter("adminPassword").and().logout().logoutUrl("/logout")
				.logoutSuccessUrl("/auth/admin-login").and().exceptionHandling().accessDeniedPage("/denied");
		http.exceptionHandling().accessDeniedHandler((request, response, accessDeniedException) -> {
			response.sendRedirect("/SpringMVC/denied");
		});
		http.authorizeRequests().and() //
				.rememberMe().tokenRepository(this.persistentTokenRepository()) //
				.tokenValiditySeconds(1 * 24 * 60 * 60); // 24h

	}

	@Bean
	public PersistentTokenRepository persistentTokenRepository() {
		InMemoryTokenRepositoryImpl memory = new InMemoryTokenRepositoryImpl(); // Ta lưu tạm remember me trong memory
																				// (RAM). Nếu cần mình có thể lưu trong
																				// database
		return memory;
	}

}
