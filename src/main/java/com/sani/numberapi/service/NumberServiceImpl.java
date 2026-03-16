package com.sani.numberapi.service;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.sani.numberapi.model.NumberResponse;
import com.sani.numberapi.model.NumberRecord;
import com.sani.numberapi.model.NumberStatsResponse;
import com.sani.numberapi.repository.NumberRepository;

@Service
public class NumberServiceImpl implements NumberService {
    
    public NumberResponse analyze (int num){
        NumberResponse res = new NumberResponse();
        res.number = num;
        res.even = num % 2 == 0;
        res.square = num * num;
        if (num <= 10)
            res.range = "Less than or equal to 10";
        else if (num <= 20)
            res.range = "Between 10 and 20";
        else
            res.range = "Greater than 20";
        res.prime = isPrime(num);
        res.factorial = fact(num);

        NumberRecord record = new NumberRecord(
            res.number,
            res.even,
            res.square,
            res.prime,
            res.range
        );

        repository.save(record);        
        return res;
    }

    public boolean isPrime(int number) {
        if (number <= 1) return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0)
                return false;
        }
        return true;
    }

    public int fact(int number) {
        int fact = 1;
        if(number<0)
            throw new IllegalArgumentException("Factorial is not defined for negative numbers");
        else if (number > 20)
            throw new IllegalArgumentException("Factorial too large");
        else {
            for (int i=1;i<=number;i++)
                fact = fact*i;
        }
        return fact;
    }

    public NumberStatsResponse stats(java.util.List<Integer> values) {

        NumberStatsResponse stats = new NumberStatsResponse();
        stats.count = values.size();
        stats.max = Integer.MIN_VALUE;
        stats.min = Integer.MAX_VALUE;
        for (int num : values) {
            if (num % 2 == 0)
                stats.evenCount++;
            else
                stats.oddCount++;
            if (isPrime(num))
                stats.primeCount++;
            if (num > stats.max)
                stats.max = num;
            if (num < stats.min)
                stats.min = num;
        }
        return stats;
    }
    private final NumberRepository repository;

    public NumberServiceImpl (NumberRepository repository) {
        this.repository = repository;
    }

    public List<NumberRecord> getHistory() {
        return repository.findAll(Sort.by(Sort.Direction.DESC,"id"));
    }

    public NumberRecord getById(Long id){
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Record Not Found"));
    }

    public List<NumberRecord> getByNumber(int number) {
        List<NumberRecord> records = repository.findByNumber(number);
        if (records.isEmpty())
            throw new RuntimeException("Record Not Found");
        return records;
    }
} 