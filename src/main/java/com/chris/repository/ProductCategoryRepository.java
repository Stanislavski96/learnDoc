package com.chris.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chris.pojo.ProductCategory;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Integer>{
	List<ProductCategory> findByCategoryTypeIn(List<Integer> categorys);
}
