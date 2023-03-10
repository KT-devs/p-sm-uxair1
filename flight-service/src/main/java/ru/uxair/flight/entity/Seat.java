package ru.uxair.flight.entity;


import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "seat")
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @JoinColumn(name = "aircraft_Id")
    private Long aircraft=2L;               //todo когда появится aircraft доделать метод

    @JoinColumn(name = "seatType")
    private Long seatType = 3L;      //todo когда появится seatType доделать метод

    @Column
    private String seatNumber;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAircraft() {
        return aircraft;
    }

    public void setAircraft(Long aircraft) {
        this.aircraft = aircraft;
    }

    public Long getSeatType() {
        return seatType;
    }

    public void setSeatType(Long seatType) {
        this.seatType = seatType;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Seat seat = (Seat) o;
        return Objects.equals(id, seat.id) && Objects.equals(aircraft, seat.aircraft) && Objects.equals(seatType, seat.seatType) && Objects.equals(seatNumber, seat.seatNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, aircraft, seatType, seatNumber);
    }
}

