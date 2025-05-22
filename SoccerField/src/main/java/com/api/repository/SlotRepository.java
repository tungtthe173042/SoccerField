package com.api.repository;

import com.api.entity.Slot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface SlotRepository extends JpaRepository<Slot, Integer>
{

	Optional<Slot> findBySlotId(Integer slotId);

	@Query("SELECT s FROM Slot s WHERE s.id <> :id AND :newStart < s.endTime AND :newEnd > s.startTime")
	List<Slot> findOverlappingSlots(@Param("id") Long id,
	                                @Param("newStart") LocalTime newStart,
	                                @Param("newEnd") LocalTime newEnd);
}
