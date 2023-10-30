package ch.zli.m223.model;

import java.time.LocalDate;

import ch.zli.m223.model.impl.AppUserImpl;
import ch.zli.m223.model.impl.StatusImpl;

public interface Ticketing {
    Long getId();
    AppUserImpl getAppUser();
    LocalDate getDate();
    Boolean getMorning();
    Boolean getAfternoon();
    StatusImpl getStatus();
}
