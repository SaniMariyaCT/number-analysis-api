package com.sani.numberapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sani.numberapi.model.NumberRecord;

public interface NumberRepository extends JpaRepository<NumberRecord, Long> {
    List<NumberRecord> findByNumber(int number);
}