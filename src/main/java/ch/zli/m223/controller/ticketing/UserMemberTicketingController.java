package ch.zli.m223.controller.ticketing;

import java.security.Principal;
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

@RestController
@RequestMapping("/api/v1/member/tickets")
@RequiredArgsConstructor
public class UserMemberTicketingController {

    private final ticketingService ticketingService;  

    /**
     * Get a list of tickets only from this member
     * @param principal injected
     * @return HttpStatus.OK
     */
    @GetMapping("")
    List<TicketDto> getTicketsList(Principal principal) {
        return ticketingService.getTicketsList().stream()
        .filter((ticket) -> ticket.getAppUser() == ticket.getAppUser())
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
     * Update a ticket given by id
     * @param id the ticket id
     * @param data everything you want to be changed in the ticket object
     * @return (HttpStatus.OK & the ticket as TicketDto) or HttpStatus.CONFLICT or HttpStatus.BADREQUEST if ticket not found
     */
    @PatchMapping("/{id}")
    TicketDto updateTicket(@PathVariable("id") Long id, @RequestBody TicketDto data) {
        return new TicketDto(ticketingService.updateTicket(
            id, data.appUser, data.date, data.morning, data.afternoon, data.status));
    }

    /**
     * Delete a ticket by ID from the server
     * @param id the ticket id
     * @return HttpStatus.OK
     */
    @DeleteMapping("{id}")
    void deleteTicket(@PathVariable("id") Long id) {
        ticketingService.deleteTicket(id);
    }
}
