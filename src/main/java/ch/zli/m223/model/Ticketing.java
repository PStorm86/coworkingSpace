package ch.zli.m223.model;

import java.util.Date;

import ch.zli.m223.model.impl.StatusImpl;

public interface Ticketing {
    Long getId();
    Long getAppUser();
    Date getDate();
    Boolean getMorning();
    Boolean getAfternoon();
    StatusImpl getStatus();
}
