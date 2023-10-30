package ch.zli.m223.service.ticketing.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Status not found")
public class InvalidStatusException extends RuntimeException{
    
}
