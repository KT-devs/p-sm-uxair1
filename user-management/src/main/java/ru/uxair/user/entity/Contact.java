package ru.uxair.user.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Entity
@Table(name = "contacts")
@Data
@ToString(exclude = {"id"})
@EqualsAndHashCode(of = {"id"})
@NoArgsConstructor
@RequiredArgsConstructor
public class Contact {
    @Id
    @Column(name = "id")
    @Positive
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    @NotNull(message = "Select contact type")
    @NonNull
    private String type; // ToDo ContactType

    @Column(name = "value")
    @NotEmpty(message = "Input your contact")
    @NonNull
    private String value;

    @Column(name = "preferred_contact")
    @NotNull(message = "Is preferred contact?")
    @NonNull
    private Boolean preferredContact;
}
