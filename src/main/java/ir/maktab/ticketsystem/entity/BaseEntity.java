package ir.maktab.ticketsystem.entity;

import java.io.Serializable;

public interface BaseEntity<ID extends Number> {
    ID getId();
    void setId(ID id);
}
