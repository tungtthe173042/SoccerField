package com.api.repository;

import com.api.entity.Field;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FieldRepository extends JpaRepository<Field, Integer>
{
	@Query("SELECT f FROM Field f WHERE " +
			"(:fieldName IS NULL OR f.fieldName LIKE CONCAT('%', :fieldName, '%')) AND " +
			"(:price IS NULL OR f.price <= :price)")
	List<Field> search(@Param("fieldName") String fieldName, @Param("price") float price);
}
