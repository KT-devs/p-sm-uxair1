package ru.uxair.user.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Entity
@Table(name = "payments")
@Data
@ToString(exclude = {"id"})
@EqualsAndHashCode(of = {"id"})
@NoArgsConstructor
@RequiredArgsConstructor
public class Payment {
    @Id
    @Column(name = "id")
    @Positive
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @OneToMany(mappedBy = "user")
    @Column(name = "user")
    @NotEmpty(message = "Input user")
    @NonNull
    private String user; // Temporary type String as plug, ToDo: User service and table links (joins)

    @Column(name = "sum")
    @NotNull(message = "Input sum")
    @NonNull
    private Double sum;

    @Column(name = "currency")
    @NotEmpty(message = "Input currency")
    @NonNull
    private String currency;

    @Column(name = "card")
    @NotEmpty(message = "Input card")
    @NonNull
    private String card;

    @Column(name = "booking_id")
    @NotNull(message = "Input bookingId")
    @NonNull
    private Long bookingId;
}
