package ru.uxair.flight.entity;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;


@Entity
@Table(name = "seat")
@Data
@ToString(of = {"seatType", "seatNumber"})
@EqualsAndHashCode(of = {"id"})
@NoArgsConstructor
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    @JoinColumn(name = "aircraft_Id")
    private Long aircraft = 2L;               //todo когда появится aircraft доделать метод
    @JoinColumn(name = "seatType")
    private Long seatType = 3L;      //todo когда появится seatType доделать метод
    @Column
    private String seatNumber;

}

