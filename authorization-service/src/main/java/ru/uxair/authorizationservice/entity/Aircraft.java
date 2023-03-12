package ru.uxair.authorizationservice.entity;

import javax.persistence.*;

@Entity
@Table(name = "Aircraft")
public class Aircraft {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JoinColumn(name = "BoardNumber")
    private String BoardNumber;
    @JoinColumn(name = "stamp")
    private String stamp;
    @JoinColumn(name = "ICAO_code")
    private int ICAO_code;
    @JoinColumn(name = "yearOfRelease")
    private int yearOfRelease;
    @JoinColumn(name = "seats")
    private String seats;

//________________________________________________________________________________________________
    public Aircraft() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getBoardNumber() {
        return BoardNumber;
    }

    public void setBoardNumber(String boardNumber) {
        BoardNumber = boardNumber;
    }

    public String getStamp() {
        return stamp;
    }

    public void setStamp(String stamp) {
        this.stamp = stamp;
    }

    public int getICAO_code() {
        return ICAO_code;
    }

    public void setICAO_code(int ICAO_code) {
        this.ICAO_code = ICAO_code;
    }

    public int getYearOfRelease() {
        return yearOfRelease;
    }

    public void setYearOfRelease(int yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }

    public String getSeats() {
        return seats;
    }

    public void setSeats(String seats) {
        this.seats = seats;
    }
}
