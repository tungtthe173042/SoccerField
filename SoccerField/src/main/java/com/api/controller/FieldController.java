package com.api.controller;

import com.api.entity.Field;
import com.api.service.FieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/field")
public class FieldController
{
	@Autowired
	private FieldService fieldService;

	@GetMapping
	public ResponseEntity<List<Field>> getAllFields()
	{
		List<Field> fields = fieldService.getAllFields();
		return fields != null && !fields.isEmpty()
				? ResponseEntity.ok(fields)
				: ResponseEntity.status(404).body(null);
	}

	@PostMapping("/add")
	public ResponseEntity<Field> addField(@RequestParam String fieldName, @RequestParam float price, @RequestParam MultipartFile image)
	{
		Field field = fieldService.addField(fieldName, price, image);
		return field != null ? ResponseEntity.ok(field) : ResponseEntity.status(400).body(null);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Field> getFieldById(@PathVariable int id)
	{
		Field field = fieldService.getFieldById(id);
		return field != null ? ResponseEntity.ok(field) : ResponseEntity.status(404).body(null);
	}

	@GetMapping("/search")
	public ResponseEntity<List<Field>> search(@RequestParam String fieldName, @RequestParam float price)
	{
		List<Field> fields = fieldService.search(fieldName, price);
		return fields != null && !fields.isEmpty() ? ResponseEntity.ok(fields) : ResponseEntity.status(404).body(null);
	}

	@PatchMapping("/update/{id}")
	public ResponseEntity<Field> updateField(@PathVariable int fieldId, @RequestParam String fieldName, @RequestParam float price, @RequestParam MultipartFile image)
	{
		Field field = fieldService.updateField(fieldId, fieldName, price, image);
		return field != null ? ResponseEntity.ok(field) : ResponseEntity.status(404).body(null);
	}

	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteField(@RequestParam int fieldId)
	{
		return fieldService.deleteField(fieldId)
				? ResponseEntity.ok("Field deleted successfully")
				: ResponseEntity.status(404).body("Field not found");
	}
}
