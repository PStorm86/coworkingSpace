package ch.zli.m223.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.zli.m223.model.Ticketing;
import ch.zli.m223.model.impl.StatusImpl;
import ch.zli.m223.model.impl.TicketingImpl;

public interface TicketingRepository extends JpaRepository<TicketingImpl, Long>{

    Ticketing addTicket(Long user, Date date, Boolean morning, Boolean afternoon, StatusImpl status);

    Ticketing update(Long user, Date date, Boolean morning, Boolean afternoon, StatusImpl status);
    
}