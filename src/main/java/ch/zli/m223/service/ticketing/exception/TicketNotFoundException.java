package ch.zli.m223.service.ticketing.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Ticket not found")
public class TicketNotFoundException extends RuntimeException {
    
}
