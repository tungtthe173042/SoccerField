package com.api.controller;

import com.api.entity.Order;
import com.api.entity.User;
import com.api.service.AuthenticateService;
import com.api.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController
{
	@Autowired
	private OrderService orderService;
	private AuthenticateService authenticateService;

	@PostMapping("/add")
	public ResponseEntity<Order> addOrder(@RequestParam String fieldName, @RequestParam LocalTime startTime,
	                                      @RequestParam LocalTime endTime, @RequestParam int userId,
	                                      @RequestParam LocalDate selectedDate, @RequestParam float price,
	                                      @RequestParam float surcharge)
	{
		User user = authenticateService.getUserById(userId);
		Order order = new Order(user, fieldName, startTime, endTime, selectedDate, price, surcharge, price + surcharge);
		Order newOrder = orderService.addOrder(order);
		return newOrder != null
				? ResponseEntity.ok(newOrder)
				: ResponseEntity.badRequest().build();
	}
}
