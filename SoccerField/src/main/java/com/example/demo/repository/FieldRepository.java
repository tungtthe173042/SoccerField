package com.example.demo.repository;

import com.example.demo.entity.Field;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FieldRepository extends JpaRepository<Field, Integer>
{
	Optional<Field> findByUserName(String userName);
}
