package ch.zli.m223.service.ticketing.impl;

import java.security.Principal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


import org.springframework.stereotype.Service;

import ch.zli.m223.model.AppUser;
import ch.zli.m223.model.Ticketing;
import ch.zli.m223.model.impl.AppUserImpl;
import ch.zli.m223.model.impl.StatusImpl;
import ch.zli.m223.repository.TicketingRepository;
import ch.zli.m223.service.ticketing.ticketingService;
import ch.zli.m223.service.ticketing.exception.InvalidStatusException;
import ch.zli.m223.service.ticketing.exception.TicketNotFoundException;
import ch.zli.m223.service.user.UserService;
import ch.zli.m223.service.user.exception.InvalidIdException;
import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class TicketingServiceImpl implements ticketingService {

    private final TicketingRepository ticketingRepository;
    private final UserService userService;

    @Override
    public List<Ticketing> getTicketsList() {
        return new ArrayList<>(ticketingRepository.findAll());
    }

    @Override
    public List<Ticketing> getTicketsList(Principal principal) {
        return new ArrayList<>(ticketingRepository.findAll());
    }

    @Override
    public Ticketing addTicket(
        AppUser userId, LocalDate date, 
        Boolean morning, Boolean afternoon, 
        StatusImpl status) {

        status = StatusImpl.New;
        AppUser user =  userService.getUser(userId.getId());

        return ticketingRepository.addTicket(user, date, morning, afternoon, status);
    }

    @Override
    public void deleteTicket(Long id) {
        if (id == null) {
            throw new InvalidIdException();
        }
        ticketingRepository.deleteById(id);
    }

    @Override
    public Ticketing updateTicket(
        Long id, AppUserImpl user, 
        LocalDate date, Boolean morning, 
        Boolean afternoon, StatusImpl status) {
        
        return ticketingRepository.update(null, user, date, morning, afternoon, status);
    }

    @Override
    public Ticketing setStatus(Long id, StatusImpl status) {
        if (id == null) {
            throw new InvalidIdException();
        }
        if (status == null) {
            throw new InvalidStatusException();
        }
        return ticketingRepository.update(null, null, null, null, null, status);
    }

    @Override
    public Ticketing getTicket(Long id) {
        if (id == null) {
            throw new InvalidIdException();        
        }
        return ticketingRepository.findById(id)
            .orElseThrow(() -> new TicketNotFoundException());
    }
    

}
