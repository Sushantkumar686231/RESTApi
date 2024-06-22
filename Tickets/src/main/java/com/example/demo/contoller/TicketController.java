package com.example.demo.contoller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Status;
import com.example.demo.model.Ticket;
import com.example.demo.repository.TicketRepository;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api")
public class TicketController {

	TicketRepository ticketrepo;
	
	
	//Create
	@PostMapping("/tickets")
	public String createTicket(@RequestBody Ticket ticket) {
		ticketrepo.save(ticket);
		return "Succesfully ticket generated";
	}
	
	//update ----------PUT
	@PutMapping("/ticket/{ID}")
	public String updateTicketByID(@PathVariable long ID,@RequestBody Ticket ticket)
	{
		Optional<Ticket> t=ticketrepo.findById(ID);
		if(t.isPresent())
		{
			Ticket existticket=t.get();
			existticket.setStatus(ticket.getStatus());
			existticket.setResolutionDetails(ticket.getResolutionDetails());
			existticket.setResolutionDateTime(ticket.getResolutionDateTime());
			ticketrepo.save(ticket);
			return "succesfully updated";
		}
		return "Failed";

	}
	
	//fetch all open tickets----------->GET
	@GetMapping("/open")
	public ResponseEntity<List<Ticket>> getAllOpenTickets()
	{
		List<Ticket> ticket=ticketrepo.findAllByStatus(Status.OPEN);
		return new ResponseEntity<List<Ticket>>(ticket,HttpStatus.OK);
		
	}
	
	
	//fetch all  tickets by ID----------->GET
		@GetMapping("/ticket/{ID}")
		public ResponseEntity<Ticket> getTicketsByID(@PathVariable long ID)
		{
			Optional<Ticket> ticket=ticketrepo.findById(ID);
			if(ticket.isPresent())
				return new ResponseEntity<Ticket>(ticket.get(),HttpStatus.FOUND);
			
			else
				return new ResponseEntity<Ticket>(HttpStatus.NOT_FOUND);
			
		}
}
