package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Status;
import com.example.demo.model.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long>{

	List<Ticket> findAllByStatus(Status status);
}
