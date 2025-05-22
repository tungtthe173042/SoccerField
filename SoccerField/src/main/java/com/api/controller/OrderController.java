package com.api.controller;

import com.api.entity.Order;
import com.api.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController
{
	@Autowired
	private OrderService orderService;

	@GetMapping()
	public ResponseEntity<List<Order>> getAllOrders()
	{
		List<Order> orders = orderService.getAllOrders();
		return orders != null && !orders.isEmpty()
				? ResponseEntity.ok(orders)
				: ResponseEntity.noContent().build();
	}

	@GetMapping("/{userId}")
	public ResponseEntity<List<Order>> getOrdersByUserId(int userId)
	{
		List<Order> orders = orderService.getOrdersByUserId(userId);
		return orders != null && !orders.isEmpty()
				? ResponseEntity.ok(orders)
				: ResponseEntity.noContent().build();
	}

	@PostMapping("/add")
	public ResponseEntity<Order> addOrder(Order order)
	{
		Order newOrder = orderService.addOrder(order);
		return newOrder != null
				? ResponseEntity.ok(newOrder)
				: ResponseEntity.badRequest().build();
	}
}
