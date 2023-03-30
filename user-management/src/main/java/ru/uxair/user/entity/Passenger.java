package ru.uxair.user.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDate;

@Entity
@Table(name = "passengers")
@Data
@ToString(of = {"firstName", "middleName", "lastName", "dateOfBirth"})
@EqualsAndHashCode(of = {"id"})
@NoArgsConstructor
@RequiredArgsConstructor
public class Passenger {
    @Id
    @Column(name = "id")
    @Positive
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
    @NotNull(message = "Input date of birth as YYYY-MM-DD")
    @NonNull
    private LocalDate dateOfBirth;

    //    @ManyToOne
//    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @Column(name = "user_id")
    @NotEmpty(message = "Input user id")
    @NonNull
    private String userId; // Temporary type String as plug, ToDo: User service and table links (joins)

    //    @OneToOne(mappedBy = "documents")
    @Column(name = "documents")
    @NotEmpty(message = "Input documents")
    @NonNull
    private String documents; // Temporary type String as plug, ToDo: Document service and table links (joins)

    @Column(name = "field")
    @NonNull
    private String field;
}