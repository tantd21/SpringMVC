package spring.mvc.service.admin;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import spring.mvc.entity.CategoryJPA;

public interface ImpCategoryJPAService {
	public List<CategoryJPA> getAllCategoryJPAs();
	public Page<CategoryJPA> getAllCategorys(Optional<Integer> p);
	public void saveCategory(CategoryJPA categoryJPA);
	public void updateCategory(CategoryJPA categoryJPA);
	public CategoryJPA findCategoryJPAById(Long cateLong);
	public void deletedCategoryJPA(Long catLong);
}
