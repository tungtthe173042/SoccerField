package com.api.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "orders")
public class Order
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id")
	private Long orderId;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	@Column(name = "order_field_name")
	private String orderFieldName;

	@Column(name = "order_start")
	private LocalTime orderStart;

	@Column(name = "order_end")
	private LocalTime orderEnd;

	@Column(name = "order_date")
	private LocalDate date;

	@Column(name = "order_field_price")
	private float orderFieldPrice;

	@Column(name = "order_slot_surcharge")
	private float orderSlotSurcharge;

	@Column(name = "tprice")
	private float totalPrice;

	public Order(User user, String orderFieldName, LocalTime orderStart, LocalTime orderEnd,
	             LocalDate date, float orderFieldPrice, float orderSlotSurcharge, float totalPrice)
	{
		this.user = user;
		this.orderFieldName = orderFieldName;
		this.orderStart = orderStart;
		this.orderEnd = orderEnd;
		this.date = date;
		this.orderFieldPrice = orderFieldPrice;
		this.orderSlotSurcharge = orderSlotSurcharge;
		this.totalPrice = totalPrice;
	}

	// Getters and Setters

	public Long getOrderId()
	{
		return orderId;
	}

	public void setOrderId(Long orderId)
	{
		this.orderId = orderId;
	}

	public User getUser()
	{
		return user;
	}

	public void setUser(User user)
	{
		this.user = user;
	}

	public String getOrderFieldName()
	{
		return orderFieldName;
	}

	public void setOrderFieldName(String orderFieldName)
	{
		this.orderFieldName = orderFieldName;
	}

	public LocalTime getOrderStart()
	{
		return orderStart;
	}

	public void setOrderStart(LocalTime orderStart)
	{
		this.orderStart = orderStart;
	}

	public LocalTime getOrderEnd()
	{
		return orderEnd;
	}

	public void setOrderEnd(LocalTime orderEnd)
	{
		this.orderEnd = orderEnd;
	}

	public LocalDate getDate()
	{
		return date;
	}

	public void setDate(LocalDate date)
	{
		this.date = date;
	}

	public float getOrderFieldPrice()
	{
		return orderFieldPrice;
	}

	public void setOrderFieldPrice(float orderFieldPrice)
	{
		this.orderFieldPrice = orderFieldPrice;
	}

	public float getOrderSlotSurcharge()
	{
		return orderSlotSurcharge;
	}

	public void setOrderSlotSurcharge(float orderSlotSurcharge)
	{
		this.orderSlotSurcharge = orderSlotSurcharge;
	}

	public float getTotalPrice()
	{
		return totalPrice;
	}

	public void setTotalPrice(float totalPrice)
	{
		this.totalPrice = totalPrice;
	}
}
