package com.chris.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chris.pojo.ProductInfo;

public interface ProductInfoRepository extends JpaRepository<ProductInfo,String>{
	List<ProductInfo> findByProductStatus(Integer status);
}
