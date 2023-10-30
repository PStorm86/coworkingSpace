package ch.zli.m223.model.impl;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import ch.zli.m223.model.Ticketing;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity(name="Booking")
public class TicketingImpl implements Ticketing{

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Long appUser;

    @DateTimeFormat
    private LocalDate date;

    private Boolean morning;
    private Boolean afternoon;

    private StatusImpl status;


    public TicketingImpl(
        Long id, Long user, 
        LocalDate date, Boolean morning, 
        Boolean afternoon, StatusImpl status) {
            this.id = id;
            this.appUser = user;
            this.date = date;
            this.morning = morning;
            this.afternoon = afternoon;
            this.status = status;
    }

    /** For JPA use only */
    protected TicketingImpl() {} 

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public Long getAppUser() {
        return appUser;
    }

    @Override
    public LocalDate getDate() {
        return date;
    }

    @Override
    public Boolean getMorning() {
        return morning;
    }

    @Override
    public Boolean getAfternoon() {
        return afternoon;
    }

    @Override
    public StatusImpl getStatus() {
        return status;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setMorning() {
        this.morning = true;
    }

    public void setAfternoon() {
        this.afternoon = true;
    }

    public void setAppUser(AppUserImpl user) {
        this.appUser = user.getId();
    }

    public void setStatus(StatusImpl status) {
        this.status = status;
    }

    

}
