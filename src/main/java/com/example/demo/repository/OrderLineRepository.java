package com.example.demo.repository;

import com.example.demo.entities.OrderLine;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.util.List;

@Repository
public interface OrderLineRepository extends ReactiveCrudRepository<OrderLine, Long> {

    Flux<OrderLine> findByTransactionId(Long transactionId);

}
