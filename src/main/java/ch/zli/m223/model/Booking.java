package ch.zli.m223.model;

import java.util.Date;

import ch.zli.m223.model.impl.AppUserImpl;
import ch.zli.m223.model.impl.StatusImpl;

public interface Booking {
    Long getId();
    AppUserImpl getAppUser();
    Date getDate();
    Boolean getMorning();
    Boolean getAfternoon();
    StatusImpl getStatus();
}
