package spring.mvc.specification;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;

import org.springframework.data.jpa.domain.Specification;

import spring.mvc.entity.CategoryJPA;
import spring.mvc.entity.ProductJPA;

public class ProductSpecifications {
	public static Specification<ProductJPA> filterProducts(int priceMin, int priceMax, String text, String valueOption, String typeOption, List<Integer> categoryIdList) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (priceMin > 0) {
                predicates.add((Predicate) criteriaBuilder.greaterThanOrEqualTo(root.get("productPrice"), priceMin));
            }
            if (priceMax > 0) {
                predicates.add((Predicate) criteriaBuilder.lessThanOrEqualTo(root.get("productPrice"), priceMax));
            }
            if (text != null && !text.isEmpty()) {
                predicates.add((Predicate) criteriaBuilder.like(root.get("productName"), "%" + text + "%"));
            }
            
            if (!categoryIdList.isEmpty()) {
                Join<ProductJPA, CategoryJPA> categoryJoin = root.join("category");
                predicates.add((Predicate) categoryJoin.get("categoryId").in(categoryIdList));
            }
            
            Predicate[] predicatesArray = predicates.toArray(new Predicate[0]);
            query.where(criteriaBuilder.and((javax.persistence.criteria.Predicate[]) predicatesArray));

            // Sắp xếp theo trường và hướng được chỉ định
            if (valueOption.equals("ASC")) {
                query.orderBy(criteriaBuilder.asc(root.get("productPrice")));
            } else if(valueOption.equals("DESC")) {
                query.orderBy(criteriaBuilder.desc(root.get("productPrice")));
            }
            return query.getRestriction();
        };
    }
}
