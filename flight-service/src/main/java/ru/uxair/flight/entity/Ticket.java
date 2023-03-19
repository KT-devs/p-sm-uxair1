package ru.uxair.flight.entity;

import lombok.*;
import ru.uxair.user.entity.Passenger;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;

@Entity
@Table(name = "ticket")
@Data
@ToString(of = {"passenger", "booking", "seatCategory", "inFlightServices", "currency"})
@EqualsAndHashCode(of = {"id"})
@NoArgsConstructor
public class Ticket {
    @Id
    @Column(name = "id")
    @Positive
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    private Passenger passenger;
    @Column(name = "booking")
    @NotEmpty(message = "Input booking")
    private String booking; // Temporary type String as plug, ToDo: Booking service and table links (joins)
    @Column(name = "seatCategory")
    @NotEmpty(message = "Input category")
    private SeatCategory seatCategory;
    @Column(name = "inFlightServices")
    @NotEmpty(message = "Input FlightServices")
    private String inFlightServices;
    @Column(name = "fare")
    @NotEmpty
    private float fare;
    @Column(name = "currency")
    @NotEmpty
    private float currency;
    //    @ManyToOne(fetch = FetchType.LAZY)
    @Column(name = "flight")
    @NotEmpty
    private String flight; // Temporary type String as plug, ToDo: Flight service and table links (joins)
}
