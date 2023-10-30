package ch.zli.m223.repository;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.zli.m223.model.AppUser;
import ch.zli.m223.model.Ticketing;
import ch.zli.m223.model.impl.AppUserImpl;
import ch.zli.m223.model.impl.StatusImpl;
import ch.zli.m223.model.impl.TicketingImpl;

public interface TicketingRepository extends JpaRepository<TicketingImpl, Long>{

    public default Ticketing addTicket(AppUser user, LocalDate date, Boolean morning, Boolean afternoon, StatusImpl status) {
        return save(new TicketingImpl(null, (AppUserImpl) user, date, morning, afternoon, status));
    }

    public default Ticketing update(
        Ticketing id,
        AppUser user, LocalDate date, 
        Boolean morning, Boolean afternoon, StatusImpl status) {
            TicketingImpl ticketingImpl = (TicketingImpl) id;
            return save(ticketingImpl);
        }
    
}
