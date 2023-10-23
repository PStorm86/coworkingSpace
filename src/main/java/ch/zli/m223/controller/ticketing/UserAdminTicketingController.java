package ch.zli.m223.controller.ticketing;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.zli.m223.controller.ticketing.dto.TicketDto;
import ch.zli.m223.model.impl.StatusImpl;
import ch.zli.m223.service.ticketing.ticketingService;
import lombok.RequiredArgsConstructor;

/**
 * Access point for administrator to the ticketing
 */
@RestController
@RequestMapping("/api/v1/admin/tickets")
@RequiredArgsConstructor
public class UserAdminTicketingController {

    private final ticketingService ticketingService;

    /**
     * Get list of all existing tickets
     * @return a list of tickets & HttpStatus.OK
     */
    @GetMapping()
    List<TicketDto> getTicketsList() {
        return ticketingService.getTicketsList().stream()
        .map(ticket -> new TicketDto(ticket))
        .collect(Collectors.toList());
    }


    /**
     * Create a new ticket
     * @param data everything you want to create in the ticket object
     * @return (HttpStatus.OK & the ticket as TicketDto) or HttpStatus.CONFLICT or HttpStatus.BAD_REQUEST)
     */
    @PostMapping()
    TicketDto addTicket(@RequestBody TicketDto data) {
        var newStatus = StatusImpl.New;
        return new TicketDto(ticketingService.addTicket(
            data.appUser, data.date, data.morning, data.afternoon, newStatus));
    }

    
    /**
     * Update a ticket given by its id
     * @param id the ticket id
     * @param data everything vou want to be changed in the ticket objekt
     * @return (HttpStatus.OK & the ticket as TicketDto) or HttpStatus.CONFLICT or HttpStatus.BADREQUEST if ticket not found
     */
    @PatchMapping("/{id}")
    TicketDto updateTicket(@PathVariable("id") Long id,
    @RequestBody TicketDto data) {
        return new TicketDto(ticketingService.updateTicket(
            id, data.appUser, data.date, data.morning, data.afternoon, data.status));
    }


    /**
     * Delete a ticket by Id from the server
     * @param id the ticket id
     * @return HttpStatus.OK
     */
    @DeleteMapping("/{id}")
    void deleteTicket(@PathVariable("id") Long id) {
        ticketingService.deleteTicket(id);
    }

}
