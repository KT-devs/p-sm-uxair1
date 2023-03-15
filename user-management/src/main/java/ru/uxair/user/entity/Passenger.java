package ru.uxair.user.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Entity
@Table(name = "passengers")
@Data
@ToString(of = {"firstName", "middleName", "last_name", "dateOfBirth"})
@EqualsAndHashCode(of = {"id"})
@NoArgsConstructor
@RequiredArgsConstructor
public class Passenger {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "first_name")
    @NotEmpty(message = "Input first name")
    @NonNull
    private String firstName;

    @Column(name = "middle_name")
    @NotEmpty(message = "Input middle name")
    @NonNull
    private String middleName;

    @Column(name = "last_name")
    @NotEmpty(message = "Input last name")
    @NonNull
    private String lastName;

    @Column(name = "date_of_birth")
    @NotEmpty(message = "Input date of birth as YYYY-MM-DD")
    @NonNull
    private LocalDate dateOfBirth;

    @Column(name = "user_id")
    @NotEmpty(message = "Input user id")
    @NonNull
    private String userId; // Temporary type String as plug, ToDo: User service and table links

    @Column(name = "documents")
    @NotEmpty(message = "Input documents")
    @NonNull
    private String documents; // Temporary type String as plug, ToDo: Document service and table links

    @Column(name = "field")
    @NonNull
    private String field;
}
