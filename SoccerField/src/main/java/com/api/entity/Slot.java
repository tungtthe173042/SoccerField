package com.api.entity;

import javax.persistence.*;
import java.time.LocalTime;

@Entity
@Table(name = "slots")
public class Slot
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "slot_id", unique = true)
	private int slotId;

	@Column(name = "start_time")
	private LocalTime startTime;

	@Column(name = "end_time")
	private LocalTime endTime;

	private float surcharge;

	public Slot(LocalTime startTime, float surcharge, LocalTime endTime)
	{
		this.startTime = startTime;
		this.surcharge = surcharge;
		this.endTime = endTime;
	}

	public int getSlotId()
	{
		return slotId;
	}

	public void setSlotId(int slotId)
	{
		this.slotId = slotId;
	}

	public LocalTime getStartTime()
	{
		return startTime;
	}

	public void setStartTime(LocalTime startTime)
	{
		this.startTime = startTime;
	}

	public LocalTime getEndTime()
	{
		return endTime;
	}

	public void setEndTime(LocalTime endTime)
	{
		this.endTime = endTime;
	}

	public float getSurcharge()
	{
		return surcharge;
	}

	public void setSurcharge(float surcharge)
	{
		this.surcharge = surcharge;
	}
}
