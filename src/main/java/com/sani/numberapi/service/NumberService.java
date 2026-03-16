package com.sani.numberapi.service;

import java.util.List;

import com.sani.numberapi.model.NumberRecord;
import com.sani.numberapi.model.NumberResponse;
import com.sani.numberapi.model.NumberStatsResponse;

public interface NumberService {
    NumberResponse analyze(int num);
    NumberStatsResponse stats(java.util.List<Integer> values);
    List<NumberRecord> getHistory();
    NumberRecord getById(Long id);
    List<NumberRecord> getByNumber(int number);
}