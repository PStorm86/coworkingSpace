package ch.zli.m223.model.impl;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import ch.qos.logback.core.status.StatusUtil;
import ch.zli.m223.model.Booking;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity(name="Booking")
public class BookingImpl implements Booking{

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private AppUserImpl appUser;

    @DateTimeFormat
    private Date date;

    private Boolean morning;
    private Boolean afternoon;

    private StatusImpl status;


    public BookingImpl(
        Long id, AppUserImpl user, 
        Date date, Boolean morning, 
        Boolean afternoon, StatusImpl status) {
            this.id = id;
            this.appUser = user;
            this.date = date;
            this.morning = morning;
            this.afternoon = afternoon;
            this.status = status;
    }

    /** For JPA use only */
    protected BookingImpl() {} 

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public AppUserImpl getAppUser() {
        return appUser;
    }

    @Override
    public Date getDate() {
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

    public void setDate(Date date) {
        this.date = date;
    }

    public void setMorning() {
        this.morning = true;
    }

    public void setAfternoon() {
        this.afternoon = true;
    }

    public void setAppUser(AppUserImpl user) {
        this.appUser = user;
    }

    public void setStatus(StatusImpl status) {
        this.status = status;
    }

    

}
