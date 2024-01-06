package spring.mvc.service.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.mvc.entity.FeeJPA;
import spring.mvc.repositoryJpa.FeeShipJPARepository;
@Service
public class FeeShipJPAService implements ImpFeeShipService{
	@Autowired
	FeeShipJPARepository feeShipJPARepository;
	
	@Override
	public FeeJPA getFeeShipJPAByIdXp(Long maxp) {
		return feeShipJPARepository.getFeeJPAByIdXa(maxp);
	}
}
