package com.example.demo.repository;

import com.example.demo.entities.OrderLine;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderLineRepository extends ReactiveCrudRepository<OrderLine, Long> {

}
