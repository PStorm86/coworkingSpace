package ch.zli.m223.controller.ticketing.dto;


import java.time.LocalDate;

import ch.zli.m223.model.Ticketing;
import ch.zli.m223.model.impl.AppUserImpl;
import ch.zli.m223.model.impl.StatusImpl;

public class TicketDto {
    public Long id;
    public AppUserImpl appUser;
    public LocalDate date;
    public boolean morning;
    public boolean afternoon;
    public StatusImpl status;

    public TicketDto(Ticketing ticket) {
        id = ticket.getId();
        appUser = ticket.getAppUser();
        date = ticket.getDate();
        morning = ticket.getMorning();
        afternoon = ticket.getAfternoon();
        status = ticket.getStatus();
    }
}
