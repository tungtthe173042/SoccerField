package com.api.repository;

import com.api.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer>
{
	@Query("SELECT o FROM Order o WHERE o.user.id = :userId")
	List<Order> findAllByUserId(@Param("userId") Integer userId);
}
