package spring.mvc.service.admin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import spring.mvc.entity.AdminJPA;
import spring.mvc.entity.RolesJPA;
import spring.mvc.repositoryJpa.AdminJPARepository;
@Service
public class ImpAdminService implements UserDetailsService{
	@Autowired
    private AdminJPARepository adminRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("hahu");
		 AdminJPA admin = adminRepository.findByAdminEmail(username);
		 System.out.println(admin.getAdminName());
		 System.out.println(admin.getAdminPassword());
	        if (admin == null) {
	            throw new UsernameNotFoundException("User not found");
	        }
	        List<GrantedAuthority> authorities = new ArrayList<>();

	        if (admin.getAdminRolesJPA() != null && admin.getAdminRolesJPA().getRoles() != null) {
	        	System.out.println(admin.getAdminRolesJPA().getRoles().getRolesName());
	            RolesJPA roles = admin.getAdminRolesJPA().getRoles();
	            authorities.add(new SimpleGrantedAuthority(roles.getRolesName()));
	        }
	        return new org.springframework.security.core.userdetails.User(
	            admin.getAdminEmail(), admin.getAdminPassword(), authorities);
	}
}
