package com.api.service;

import com.api.entity.Order;
import com.api.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService
{
	private final OrderRepository orderRepository;

	public OrderService(OrderRepository orderRepository) {this.orderRepository = orderRepository;}

	public Order getOrderById(int orderId)
	{
		return orderRepository.findById(orderId)
				.orElse(null);
	}

	public List<Order> getAllOrders()
	{
		return orderRepository.findAll();
	}

	public Order addOrder(Order order)
	{
		return orderRepository.save(order);
	}

	public List<Order> getOrdersByUserId(int userId)
	{
		return orderRepository.findAllByUserId(userId);
	}
}
