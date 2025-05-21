package com.example.demo.service;

import com.example.demo.entity.Field;
import com.example.demo.repository.FieldRepository;
import org.springframework.stereotype.Service;

@Service
public class FieldService
{
	private final FieldRepository fieldRepository;

	public FieldService(FieldRepository fieldRepository)
	{
		this.fieldRepository = fieldRepository;
	}

	public void addField(String fieldName, float price, String imageUrl)
	{
		fieldRepository.save(new Field(fieldName, price, imageUrl));
	}

}
