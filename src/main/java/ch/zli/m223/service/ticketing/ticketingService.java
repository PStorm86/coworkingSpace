package ch.zli.m223.service.ticketing;

import java.security.Principal;
import java.util.Date;
import java.util.List;

import ch.zli.m223.model.Ticketing;
import ch.zli.m223.model.impl.StatusImpl;
import ch.zli.m223.service.user.exception.InvalidIdException;

public interface ticketingService {

    /**
     * @return a possibly empty list of tickets
     */
    List<Ticketing> getTicketsList();

    /**
     * 
     * @param appUser
     * @return a possibly empty list of tickets
     */
    List<Ticketing> getTicketsList(Principal principal);

    Ticketing getTicket(Long id);

    /**
     * Add a new booking
     * @param user Id from User
     * @param date date when is this room booked
     * @param morning is room on morning booked
     * @param afternoon is room on afternoon booked
     * @param status status of this booking (Enum: NEW, REJECTED, BOOKED)
     * @return
     */
    Ticketing addTicket(
        Long user, Date date,
        Boolean morning, Boolean afternoon,
        StatusImpl status
    );
 

    /**
     * Delete a ticket
     * @param id
     * @throws InvalidIdException
     */
    void deleteTicket(Long id);

    /**
     * update a ticket
     * @param id the booking id
     * @param user the user id
     * @param date the date when the room is booked
     * @param morning is room on morning booked
     * @param afternoon is room on afternoon booked
     * @param status status of booking (ENUM: NEW, REJECTED, BOOKED)
     * @return the changed booking
     * @throws InvalidIdException
     */
    Ticketing updateTicket(
        Long id,
        Long user, Date date,
        Boolean morning, Boolean afternoon,
        StatusImpl status
    );

    Ticketing setStatus(Long id, StatusImpl status);

}
