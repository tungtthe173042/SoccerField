package com.api.service;

import com.api.entity.Field;
import com.api.repository.FieldRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

@Service
public class FieldService
{
	private final FieldRepository fieldRepository;

	public FieldService(FieldRepository fieldRepository)
	{
		this.fieldRepository = fieldRepository;
	}

	public Field addField(String fieldName, float price, MultipartFile image)
	{
		int fieldId = fieldRepository.findAll().size() + 1;
		// Tạo đối tượng Field
		Field field = new Field(fieldName, price, saveImage(image, fieldId));
		fieldRepository.save(field);
		return field;
	}


	public List<Field> getAllFields()
	{
		return fieldRepository.findAll();
	}

	public List<Field> search(String fieldName, float price)
	{
		return fieldRepository.search(fieldName, price);
	}

	public Field updateField(int fieldId, String fieldName, float price, MultipartFile image)
	{
		Field field = fieldRepository.findById(fieldId).orElse(null);
		if (field != null)
		{
			if (fieldName != null && !fieldName.isEmpty())
			{
				field.setFieldName(fieldName);
			}
			if (price > 0)
			{
				field.setPrice(price);
			}
			if (image != null && !image.isEmpty())
			{
				field.setImageUrl(saveImage(image, fieldId));
			}
			fieldRepository.save(field);
		}
		return field;
	}

	private String saveImage(MultipartFile image, int fieldId)
	{
		String imageUrl = "/image/field/" + fieldId + "_" + fieldId + image.getOriginalFilename().substring(image.getOriginalFilename().lastIndexOf('.'));
		try
		{
			String folderPath = "src/main/resources/static/image/field/";
			File directory = new File(folderPath);
			if (!directory.exists())
			{
				directory.mkdirs();
			}
			File[] files = directory.listFiles((d, name) -> name.startsWith("field_" + fieldId));
			if (files != null)
			{
				for (File file : files)
				{
					boolean deleted = file.delete();
					if (!deleted)
					{
						System.out.println("Không thể xóa file: " + file.getAbsolutePath());
					}
				}
			}
			image.transferTo(new File(folderPath + imageUrl));
		}
		catch (Exception e)
		{
			throw new RuntimeException("Failed to save image", e);
		}
		return imageUrl;
	}

	public boolean deleteField(int fieldId)
	{
		if (!fieldRepository.existsById(fieldId))
		{
			return false;
		}
		fieldRepository.deleteById(fieldId);
		return true;
	}

	public Field getFieldById(int id)
	{
		return fieldRepository.findById(id)
				.orElse(null);
	}
}
