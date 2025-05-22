package com.api.controller;

import com.api.entity.Slot;
import com.api.service.SlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/slot")
public class SlotController
{
	@Autowired
	private SlotService slotService;

	@GetMapping()
	public ResponseEntity<List<Slot>> getAllSlots()
	{
		List<Slot> slots = slotService.getAllSlots();
		return slots != null && !slots.isEmpty()
				? ResponseEntity.ok(slots)
				: ResponseEntity.status(404).body(null);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Slot> getSlotById(@PathVariable int id)
	{
		Slot slot = slotService.getSlotById(id);
		return slot != null ? ResponseEntity.ok(slot) : ResponseEntity.status(404).body(null);
	}

	@PostMapping("/add")
	public ResponseEntity<Slot> addSlot(@RequestParam LocalTime startTime, @RequestParam LocalTime endTime, @RequestParam float surcharge)
	{
		Slot slot = slotService.addSlot(startTime, endTime, surcharge);
		return slot != null ? ResponseEntity.ok(slot) : ResponseEntity.status(400).body(null);
	}

	@PatchMapping("/update/{id}")
	public ResponseEntity<Slot> updateSlot(@PathVariable int slotId, @RequestParam LocalTime startTime, @RequestParam LocalTime endTime, @RequestParam float surcharge)
	{
		Slot slot = slotService.updateSlot(slotId, startTime, endTime, surcharge);
		return slot != null ? ResponseEntity.ok(slot) : ResponseEntity.status(404).body(null);
	}

	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteSlot(@RequestParam int slotId)
	{
		return slotService.deleteSlot(slotId)
				? ResponseEntity.ok("Slot deleted successfully")
				: ResponseEntity.status(404).body("Slot not found");
	}
}
