package spring.mvc.controller.web;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import spring.mvc.entity.DistrictJPA;
import spring.mvc.entity.WardJPA;
import spring.mvc.service.admin.ImpAddressService;

@Controller
@RequestMapping("/address")
public class AddressController {
	@Autowired
	ImpAddressService impAddressService;

	@PostMapping(value = "/change-address", produces = "application/x-www-form-urlencoded;charset=UTF-8")
	@ResponseBody
	public String changeAddess(@RequestParam("action") String action, @RequestParam("maId") Long maId) {
		System.out.println(action);
		System.out.println(maId);
		StringBuilder stringBuilder = new StringBuilder();
		if(action.equals("city")) {
			List<DistrictJPA> districts = impAddressService.getDistrictJPAs(maId);
			stringBuilder.append("<option value=\"\"> ---Chọn Quận Huyện--- </option>");
			for (DistrictJPA district: districts) {
				stringBuilder.append("<option value=\""+district.getMaQh()+"\"> " + district.getNameProvince() + "</option>");
			}
		}else if(action.equals("province")) {
			List<WardJPA> wardJPAs = impAddressService.getWardJPAs(maId);
			stringBuilder.append("<option value=\"\"> ---Chọn Xã Phường Thị Trấn--- </option>");
			for(WardJPA ward: wardJPAs) {
				stringBuilder.append("<option value=\"" + ward.getXaid() + "\">" + ward.getNameWard() + "</option>");
			}
		}
		return stringBuilder.toString();
	}
}
