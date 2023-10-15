package spring.mvc.service.admin;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import spring.mvc.entity.CategoryJPA;
import spring.mvc.repositoryJpa.CategoryJPARepository;
@Service
public class CategoryJPAService implements ImpCategoryJPAService{
	@Autowired
	private CategoryJPARepository categoryJPARepository; 
	@Override
	public List<CategoryJPA> getAllCategoryJPAs() {
		// TODO Auto-generated method stub
		return categoryJPARepository.findAll();
	}
	
	public Page<CategoryJPA> getAllCategorys(Optional<Integer> p){
		PageRequest pageRequest = new PageRequest(p.orElse(0), 5);
		Pageable pageable = pageRequest;
		Page<CategoryJPA> page = categoryJPARepository.findAll(pageable);
		return page;
	}
	
	@Override
	public void saveCategory(CategoryJPA categoryJPA) {
		categoryJPARepository.save(categoryJPA);
	}
	
	@Override
	public void updateCategory(CategoryJPA categoryJPA) {
		categoryJPARepository.save(categoryJPA);
	}
	
	@Override
	public CategoryJPA findCategoryJPAById(Long cateLong) {
		return categoryJPARepository.findOne(cateLong);
	}
	
	@Override
	public void deletedCategoryJPA(Long catLong) {
		categoryJPARepository.deleteCategoryJPA(catLong);
	}
}
