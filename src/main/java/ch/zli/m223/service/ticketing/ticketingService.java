package ch.zli.m223.service.ticketing;

import java.util.Date;
import java.util.List;

import ch.zli.m223.model.Booking;
import ch.zli.m223.model.impl.AppUserImpl;
import ch.zli.m223.model.impl.StatusImpl;

public interface ticketingService {

    /**
     * @return a possibly empty list of booking
     */
    List<Booking> getBookingList();

    /**
     * Add a new booking
     * @param user Id from User
     * @param date date when is this room booked
     * @param morning is room on morning booked
     * @param afternoon is room on afternoon booked
     * @param status status of this booking (Enum: NEW, REJECTED, BOOKED)
     * @return
     */
    Booking addBooking(
        AppUserImpl user, Date date,
        Boolean morning, Boolean afternoon,
        StatusImpl status
    );

    /**
     * Delete a booking
     * @param id
     * @throws InvalidIdException
     */
    void deleteBooking(Long id);

    /**
     * update a booking
     * @param id the booking id
     * @param user the user id
     * @param date the date when the room is booked
     * @param morning is room on morning booked
     * @param afternoon is room on afternoon booked
     * @param status status of booking (ENUM: NEW, REJECTED, BOOKED)
     * @return the changed booking
     * @throws InvalidIdException
     */
    Booking updateBooking(
        Long id,
        AppUserImpl user, Date date,
        Boolean morning, Boolean afternoon,
        StatusImpl status
    );

}
