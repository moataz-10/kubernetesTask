package org.example.pingpong.repos;

import org.example.pingpong.models.Counter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface counterRepo extends JpaRepository<Counter, Integer> {
}
