package com.example.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "fields")
public class Field
{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "field_id")
	private Long fieldId;

	@Column(name = "field_name")
	private String fieldName;
	private float price;
	private int status = 1; // 1: active, 0: inactive

	@Column(name = "image_url")
	private String imageUrl;

	public Field(String fieldName, float price, String imageUrl)
	{
		this.fieldName = fieldName;
		this.price = price;
		this.imageUrl = imageUrl;
	}

	public Long getFieldId()
	{
		return fieldId;
	}

	public void setFieldId(Long fieldId)
	{
		this.fieldId = fieldId;
	}

	public String getFieldName()
	{
		return fieldName;
	}

	public void setFieldName(String fieldName)
	{
		this.fieldName = fieldName;
	}

	public float getPrice()
	{
		return price;
	}

	public void setPrice(float price)
	{
		this.price = price;
	}

	public int getStatus()
	{
		return status;
	}

	public void setStatus(int status)
	{
		this.status = status;
	}

	public String getImageUrl()
	{
		return imageUrl;
	}

	public void setImageUrl(String imageUrl)
	{
		this.imageUrl = imageUrl;
	}
}
