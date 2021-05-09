package com.chris.pojo.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.chris.pojo.ProductCategory;

public interface ProductCategoryMapper {

	@Insert("insert into product_category(category_name,category_type) values(#{category_name,jdbcType=VARCHAR},#{category_type,jdbcType=INTEGER})")
	int insertByMap(Map<String,Object> map);
	
	@Select("select * from product_category where category_type=#{categoryType}")
	@Results({
		@Result(column="category_id",property="categoryId"),
		@Result(column="category_name",property="categoryName"),
		@Result(column="category_type",property="categoryType")
	})
	ProductCategory findByCategoryType(Integer categoryType);
	
	@Update("update product_category set category_name=#{categoryName} where category_type=#{categoryType}")
	int updateCategoryName(@Param("categoryName") String categoryName,@Param("categoryType") Integer categoryType);


//	使用mapper.xml的方式
	ProductCategory selectCategoryType(Integer categoryType);
}
