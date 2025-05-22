package com.api.service;

import com.api.entity.Order;
import com.api.entity.Slot;
import com.api.repository.SlotRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class SlotService
{
	private final SlotRepository slotRepository;
	private final OrderService orderService;

	public SlotService(SlotRepository slotRepository, OrderService orderService)
	{
		this.slotRepository = slotRepository;
		this.orderService = orderService;
	}

	public Slot getSlotById(int id)
	{
		return slotRepository.findBySlotId(id)
				.orElse(null);
	}

	public List<Slot> getAllSlots()
	{
		return slotRepository.findAll();
	}

	public Slot addSlot(LocalTime startTime, LocalTime endTime, float surcharge)
	{
		// Check slot is overlapped
		List<Slot> overlappingSlots = slotRepository.findOverlappingSlots(null, startTime, endTime);
		if (!overlappingSlots.isEmpty())
		{
			return null;
		}
		// Save Slot
		Slot slot = new Slot(startTime, surcharge, endTime);
		slotRepository.save(slot);
		return slot;
	}

	public Slot updateSlot(int slotId, LocalTime startTime, LocalTime endTime, float surcharge)
	{
		Slot slot = slotRepository.findBySlotId(slotId)
				.orElse(null);
		// Check slot is overlapped
		List<Slot> overlappingSlots = slotRepository.findOverlappingSlots(null, startTime, endTime);
		if (!overlappingSlots.isEmpty())
		{
			return null;
		}
		if (slot != null)
		{
			if (startTime != null && endTime != null)
			{
				slot.setStartTime(startTime);
				slot.setEndTime(endTime);
			}
			if (surcharge > 0)
			{
				slot.setSurcharge(surcharge);
			}
			slotRepository.save(slot);
		}
		return slot;
	}

	public boolean deleteSlot(int slotId)
	{
		Slot slot = slotRepository.findBySlotId(slotId)
				.orElse(null);
		if (slot != null)
		{
			slotRepository.delete(slot);
			return true;
		}
		return false;
	}
}
