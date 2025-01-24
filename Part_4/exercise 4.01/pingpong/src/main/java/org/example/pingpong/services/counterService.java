package org.example.pingpong.services;

import jakarta.transaction.Transactional;
import org.example.pingpong.models.Counter;
import org.example.pingpong.repos.counterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class counterService {
    @Autowired
    private counterRepo counterRepository;


    // Retrieve the current counter value
    public Integer getCounterValue() {
        Counter counter = counterRepository.findById(1)
                .orElseGet(() -> {
                    Counter newCounter = new Counter();
                    newCounter.setValue(0);
                    return counterRepository.save(newCounter);
                });
        return counter.getValue();
    }

    // Increment the counter
    @Transactional
    public Integer incrementCounter() {
        Integer countvalue = getCounterValue();
        Counter counter = counterRepository.findById(1)
                .orElseThrow(() -> new RuntimeException("Counter not found"));
        counter.setValue(countvalue + 1);
        return counter.getValue();
    }

    public void testDb() {
        counterRepository.flush();
    }
}
