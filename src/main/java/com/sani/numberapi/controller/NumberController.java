package com.sani.numberapi.controller;
        
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sani.numberapi.model.NumberRecord;
import com.sani.numberapi.model.NumberResponse;
import com.sani.numberapi.model.NumberStatsResponse;
import com.sani.numberapi.service.NumberService;

@RestController
public class NumberController {

    private final NumberService service;

    public NumberController (NumberService service) {
        this.service = service;
    }

    @GetMapping("/number/{num}")
    public NumberResponse processNumber(@PathVariable int num) {
        if(num<0)
            throw new IllegalArgumentException("Number Must be Positive");
        else if(num>1000)
            throw new IllegalArgumentException("Number Too Large");
       return service.analyze(num);
    }

    @GetMapping("/numbers")
    public List<NumberResponse> processNumbers(@RequestParam List<Integer> values) {

        List<NumberResponse> results = new ArrayList<>();

        for (int num : values) {
            results.add(service.analyze(num));
        }

       return results;
    }
    
    @GetMapping("/numbers/stats")
    public NumberStatsResponse stats(@RequestParam List<Integer> values) {
        return service.stats(values);
    }

    @GetMapping("/history")
    public List<NumberRecord> getHistory() {
        return service.getHistory();
    }

    @GetMapping("/history/{id}")
    public NumberRecord getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping("/history/by-number/{number}")
    public List<NumberRecord> getByNumber(@PathVariable int number) {
        return service.getByNumber(number);
    }
}